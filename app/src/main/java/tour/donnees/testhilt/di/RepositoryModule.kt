package tour.donnees.testhilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import tour.donnees.testhilt.network.MovieMapper
import tour.donnees.testhilt.network.StudioService
import tour.donnees.testhilt.repository.StudioRepository
import tour.donnees.testhilt.room.CacheMapper
import tour.donnees.testhilt.room.MovieDAO
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideStudioRepository(
        movieDao: MovieDAO,
        studioService: StudioService,
        cacheMapper: CacheMapper,
        movieMapper: MovieMapper
    ): StudioRepository {
        return StudioRepository(movieDao, studioService, cacheMapper, movieMapper)
    }

}