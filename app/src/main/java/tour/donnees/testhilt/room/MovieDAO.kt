package tour.donnees.testhilt.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieCacheEntity: MovieCacheEntity)

    @Query("SELECT * FROM movie")
    suspend fun get(): List<MovieCacheEntity>
}