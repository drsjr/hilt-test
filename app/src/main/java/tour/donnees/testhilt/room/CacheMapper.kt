package tour.donnees.testhilt.room

import tour.donnees.testhilt.mapper.EntityMapper
import tour.donnees.testhilt.model.Movie
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<MovieCacheEntity, Movie>{

    override fun mapFromEntity(response: MovieCacheEntity): Movie {
        return Movie(response.id, response.title, response.description)
    }

    override fun mapToEntity(model: Movie): MovieCacheEntity {
        return MovieCacheEntity(model.id, model.title, model.description)
    }

    fun  mapFromEntityList(response: List<MovieCacheEntity>): List<Movie> {
        return response.map { mapFromEntity(it) }
    }
}