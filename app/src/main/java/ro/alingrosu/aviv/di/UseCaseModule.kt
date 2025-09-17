package ro.alingrosu.aviv.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alingrosu.aviv.domain.repository.RealEstateRepository
import ro.alingrosu.aviv.domain.usecase.RealEstateUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetRealEstatesUseCase(realEstateRepository: RealEstateRepository): RealEstateUseCase =
        RealEstateUseCase(realEstateRepository)
}