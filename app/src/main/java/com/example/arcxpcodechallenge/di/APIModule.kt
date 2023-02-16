package com.example.arcxpcodechallenge.di

import com.example.arcxpcodechallenge.di.NetworkModule.BASE_URL_TAG
import com.example.arcxpcodechallenge.framework.networking.WashingtonPostAPI
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideWashingtonAPI(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
        @Named(BASE_URL_TAG) baseUrl: String
    ): WashingtonPostAPI =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build().create(WashingtonPostAPI::class.java)

}
