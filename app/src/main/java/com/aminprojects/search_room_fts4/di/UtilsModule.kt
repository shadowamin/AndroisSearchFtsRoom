package com.aminprojects.search_room_fts4.di

import android.content.Context
import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ApplicationComponent::class)
@Module
class UtilsModule {

    @Provides
    internal fun provideAssets(@ApplicationContext context: Context): AssetManager {
        return context.assets
    }

    @Provides
    internal fun provideMoshi() : Moshi {
        return Moshi.Builder().apply {
            // Kotlin adapter
            add(KotlinJsonAdapterFactory())
        }.build()
    }


}