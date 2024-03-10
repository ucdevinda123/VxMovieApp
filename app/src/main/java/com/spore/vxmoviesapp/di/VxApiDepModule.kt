package com.spore.vxmoviesapp.di

import com.spore.vxmoviesapp.data.network.RetrofitMovieService
import com.spore.vxmoviesapp.data.network.constant.ApiConstant
import com.spore.vxmoviesapp.util.shimmer.apiKeyAsQuery
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VxApiDepModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { apiKeyAsQuery(it) }
                    .build(),
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitMovieService {
        return retrofit.create(RetrofitMovieService::class.java)
    }
}
