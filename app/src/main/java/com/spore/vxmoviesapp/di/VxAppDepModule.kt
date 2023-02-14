package com.spore.vxmoviesapp.di

import com.spore.vxmoviesapp.data.network.RetrofitMovieService
import com.spore.vxmoviesapp.data.offline.db.VxRoomDb
import com.spore.vxmoviesapp.data.pagingsource.NowPlayingMoviePagingSource
import com.spore.vxmoviesapp.data.pagingsource.PopularMoviePagingSource
import com.spore.vxmoviesapp.data.pagingsource.TopRatedMoviePagingSource
import com.spore.vxmoviesapp.data.pagingsource.UpcomingMoviePagingSource
import com.spore.vxmoviesapp.data.repository.bannermovie.VxBannerMovieRepository
import com.spore.vxmoviesapp.data.repository.bannermovie.VxBannerMovieRepositoryImpl
import com.spore.vxmoviesapp.data.repository.moviedetails.VxMovieDetails
import com.spore.vxmoviesapp.data.repository.moviedetails.VxMovieDetailsImpl
import com.spore.vxmoviesapp.data.repository.nowplaying.VxNowPlayingMovieRepository
import com.spore.vxmoviesapp.data.repository.nowplaying.VxNowPlayingMovieRepositoryImpl
import com.spore.vxmoviesapp.data.repository.popular.VxPopularMovieRepository
import com.spore.vxmoviesapp.data.repository.popular.VxPopularMovieRepositoryImpl
import com.spore.vxmoviesapp.data.repository.search.VxSearchRepository
import com.spore.vxmoviesapp.data.repository.search.VxSearchRepositoryImpl
import com.spore.vxmoviesapp.data.repository.toprated.VxTopRatedRepository
import com.spore.vxmoviesapp.data.repository.toprated.VxTopRatedRepositoryImpl
import com.spore.vxmoviesapp.data.repository.upcoming.VxUpComingMovieRepository
import com.spore.vxmoviesapp.data.repository.upcoming.VxUpComingMovieRepositoryImpl
import com.spore.vxmoviesapp.data.repository.watchlist.VxLocalWatchListRepository
import com.spore.vxmoviesapp.data.repository.watchlist.VxLocalWatchListRepositoryImpl
import com.spore.vxmoviesapp.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VxAppDepModule {


    /*Paging Data Sources */
    @Singleton
    @Provides
    fun providePopularMovieSource(retrofitMovieService: RetrofitMovieService): PopularMoviePagingSource {
        return PopularMoviePagingSource(retrofitMovieService)
    }

    @Singleton
    @Provides
    fun provideTopRatedMovieSource(retrofitMovieService: RetrofitMovieService): TopRatedMoviePagingSource {
        return TopRatedMoviePagingSource(retrofitMovieService, "")
    }

    @Singleton
    @Provides
    fun provideUpComingMovieSource(retrofitMovieService: RetrofitMovieService): UpcomingMoviePagingSource {
        return UpcomingMoviePagingSource(retrofitMovieService)
    }

    @Singleton
    @Provides
    fun provideNowPlayingMovieSource(retrofitMovieService: RetrofitMovieService): NowPlayingMoviePagingSource {
        return NowPlayingMoviePagingSource(retrofitMovieService)
    }

    /* Repositories */
    @Singleton
    @Provides
    fun provideTrendingBanner(api: RetrofitMovieService): VxBannerMovieRepository {
        return VxBannerMovieRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideTopRatedMovieRepository(topRatedMoviePagingSource: TopRatedMoviePagingSource): VxTopRatedRepository {
        return VxTopRatedRepositoryImpl(topRatedMoviePagingSource)
    }

    @Singleton
    @Provides
    fun providePopularMovieRepository(popularMoviePagingSource: PopularMoviePagingSource): VxPopularMovieRepository {
        return VxPopularMovieRepositoryImpl(popularMoviePagingSource)
    }


    @Singleton
    @Provides
    fun provideUpcomingMovieRepository(upcomingMoviePagingSource: UpcomingMoviePagingSource): VxUpComingMovieRepository {
        return VxUpComingMovieRepositoryImpl(upcomingMoviePagingSource)
    }

    @Singleton
    @Provides
    fun provideNowPlayingMovieRepository(nowPlayingMoviePagingSource: NowPlayingMoviePagingSource): VxNowPlayingMovieRepository {
        return VxNowPlayingMovieRepositoryImpl(nowPlayingMoviePagingSource)
    }

    @Singleton
    @Provides
    fun provideMovieDetailsRepository(retrofitMovieService: RetrofitMovieService): VxMovieDetails {
        return VxMovieDetailsImpl(retrofitMovieService)
    }

    @Singleton
    @Provides
    fun provideSearchRepository(retrofitMovieService: RetrofitMovieService): VxSearchRepository {
        return VxSearchRepositoryImpl(retrofitMovieService)
    }

    @Singleton
    @Provides
    fun provideWatchListRepository(vxRoomDb : VxRoomDb): VxLocalWatchListRepository {
        return VxLocalWatchListRepositoryImpl(vxRoomDb)
    }

    /* Domain Level Use Cases */
    @Singleton
    @Provides
    fun providePopularMovieUseCase(repository: VxPopularMovieRepository): PopularMovieUseCase {
        return PopularMovieUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideNowPlayingMovieUseCase(repository: VxNowPlayingMovieRepository): NowPlayingMovieUseCase {
        return NowPlayingMovieUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideTopRatedMovieUseCase(repository: VxTopRatedRepository): TopRateMovieUseCase {
        return TopRateMovieUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideUpcomingMovieUseCase(repository: VxUpComingMovieRepository): UpComingMovieUseCase {
        return UpComingMovieUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideMovieBannerUseCase(repository: VxBannerMovieRepository): TrendingBannerUseCase {
        return TrendingBannerUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideMovieDetailsUseCase(repository: VxMovieDetails): MovieDetailsUseCase {
        return MovieDetailsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSearchUseCase(repository: VxSearchRepository): SearchUseCase {
        return SearchUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideWatchListUseCase(repository: VxLocalWatchListRepository): WatchListUseCase {
        return WatchListUseCase(repository)
    }
}