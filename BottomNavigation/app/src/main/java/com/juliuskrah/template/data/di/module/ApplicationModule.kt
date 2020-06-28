package com.juliuskrah.template.data.di.module

import com.juliuskrah.template.data.repository.ExampleRepository
import com.juliuskrah.template.data.repository.ExampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(ApplicationComponent::class, FragmentComponent::class)
abstract class ApplicationModule {
    @Binds abstract fun bindExampleRepository(exampleRepository: ExampleRepositoryImpl): ExampleRepository
}