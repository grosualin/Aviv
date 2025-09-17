package ro.alingrosu.aviv.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alingrosu.aviv.data.remote.service.RealEstateApi
import ro.alingrosu.aviv.data.repository.RealEstateRepositoryImpl
import ro.alingrosu.aviv.domain.repository.RealEstateRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRealEstateRepository(realEstateApi: RealEstateApi): RealEstateRepository =
        RealEstateRepositoryImpl(realEstateApi)
}