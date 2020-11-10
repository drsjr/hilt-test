package tour.donnees.testhilt.network

import tour.donnees.testhilt.mapper.EntityMapper
import tour.donnees.testhilt.model.Movie
import tour.donnees.testhilt.response.FilmResponse
import javax.inject.Inject

class MovieMapper
@Inject constructor(): EntityMapper<FilmResponse, Movie>
{
    override fun mapFromEntity(response: FilmResponse): Movie {
        return Movie(response.id, response.title, response.description)
    }

    override fun mapToEntity(model: Movie): FilmResponse {
        return FilmResponse(model.id, model.title, model.description)
    }

    fun mapFromEntityList(response: List<FilmResponse>): List<Movie> {
        return response.map { mapFromEntity(it) }
    }
}