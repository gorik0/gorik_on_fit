package com.gorik.goriktrainee.di

import android.content.Context
import androidx.compose.ui.platform.UriHandler
import com.gorik.goriktrainee.data.GorikUriHandler
import com.gorik.goriktrainee.data.StringHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @IoDispatcher
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DefaultDispatcher
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    @ApplicationScope
    fun providesCoroutineScope(
        @DefaultDispatcher dispatcher: CoroutineDispatcher,
    ): CoroutineScope = CoroutineScope(SupervisorJob() + dispatcher)

    @Provides
    @Singleton
    fun provideContext(
        @ApplicationContext context: Context
    ): Context = context

    @Provides
    @Singleton
    fun provideUriHandler(
        @ApplicationContext context: Context
    ): UriHandler = GorikUriHandler(context)

    @Provides
    @Singleton
    fun provideStringHandler(
        @ApplicationContext context: Context
    ): StringHandler = StringHandler(context)

}
