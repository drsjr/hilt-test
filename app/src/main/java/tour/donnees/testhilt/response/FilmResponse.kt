package tour.donnees.testhilt.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FilmResponse (
    @Expose @SerializedName("id") val id: String,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("description") val description: String
)