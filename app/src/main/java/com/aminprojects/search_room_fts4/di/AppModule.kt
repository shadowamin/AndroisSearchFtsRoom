package com.aminprojects.search_room_fts4.di

import android.content.Context
import androidx.room.Room
import com.aminprojects.search_room_fts4.data.Repository
import com.aminprojects.search_room_fts4.data.RepositoryImpl
import com.aminprojects.search_room_fts4.data.room.AppDatabase
import com.aminprojects.search_room_fts4.data.room.dao.NewsDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module(includes = [ApplicationModuleBinds::class])
class AppModule {

    @Provides
    fun provideMyDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "news.db"
        )
            .build()
    }

    @Provides
    internal fun provideNewsDao(appDatabase: AppDatabase): NewsDao {
        return appDatabase.newsDao()
    }

}

@InstallIn(ApplicationComponent::class)
@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: RepositoryImpl): Repository

}