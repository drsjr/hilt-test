package tour.donnees.testhilt.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import tour.donnees.testhilt.model.Movie
import tour.donnees.testhilt.network.MovieMapper
import tour.donnees.testhilt.network.StudioService
import tour.donnees.testhilt.room.CacheMapper
import tour.donnees.testhilt.room.MovieDAO
import tour.donnees.testhilt.util.DataState
import java.lang.Exception
import javax.inject.Inject

class StudioRepository
constructor(
    private val movieDao: MovieDAO,
    private val studioService: StudioService,
    private val cacheMapper: CacheMapper,
    private val movieMapper: MovieMapper
){

    suspend fun getMovie(): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading)
        delay(1000)

        try {
            val network = studioService.getFilm()
            val movies = movieMapper.mapFromEntityList(network)
            for (movie in movies) {
                movieDao.insert(cacheMapper.mapToEntity(movie))
            }
            val cachedMovie = movieDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedMovie)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }

}