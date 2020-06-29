package com.juliuskrah.template.data.di.module

import android.app.Application
import com.juliuskrah.template.data.ApplicationDatabase
import com.juliuskrah.template.data.dao.ExampleDao
import com.juliuskrah.template.data.repository.ExampleRepository
import com.juliuskrah.template.data.repository.ExampleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent

@Module(includes = [ApplicationModule.BindsModule::class])
@InstallIn(ApplicationComponent::class, ActivityComponent::class, FragmentComponent::class)
object ApplicationModule {
    @Provides
    fun provideDatabase(application: Application): ApplicationDatabase = ApplicationDatabase.getInstance(application)

    @Provides
    fun provideExampleDao(database: ApplicationDatabase): ExampleDao = database.exampleDao()

    @Module
    @InstallIn(ApplicationComponent::class, ActivityComponent::class, FragmentComponent::class)
    interface BindsModule {
        @Binds fun bindExampleRepository(exampleRepository: ExampleRepositoryImpl): ExampleRepository
    }
}