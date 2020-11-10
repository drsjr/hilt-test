package tour.donnees.testhilt.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MovieCacheEntity::class], version = 1)
abstract class StudioDatabase: RoomDatabase() {

    abstract fun MovieDAO(): MovieDAO

    companion object {
        const val DATABASE_NAME = "studio"
    }

}