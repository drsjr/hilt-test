package tour.donnees.testhilt.network

import retrofit2.http.GET
import tour.donnees.testhilt.response.FilmResponse

interface StudioService {

    @GET("/films")
    suspend fun getFilm(): List<FilmResponse>

}