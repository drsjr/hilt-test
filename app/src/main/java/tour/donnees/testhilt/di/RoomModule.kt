package tour.donnees.testhilt.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import tour.donnees.testhilt.room.MovieDAO
import tour.donnees.testhilt.room.StudioDatabase
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideStudioDb(@ApplicationContext context: Context): StudioDatabase {
        return Room.databaseBuilder(
                context,
                StudioDatabase::class.java,
                StudioDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(database: StudioDatabase): MovieDAO {
        return database.MovieDAO()
    }
}