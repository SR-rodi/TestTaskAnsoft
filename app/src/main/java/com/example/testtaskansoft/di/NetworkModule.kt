package com.example.testtaskansoft.di

import com.example.testtaskansoft.feature.data.api.DeliveryApi
import com.example.testtaskansoft.feature.data.repository.NetworkDeliveryRepositoryImpl
import com.example.testtaskansoft.feature.domain.repository.NetworkDeliveryRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "http://vseotlichno.com/api/v1/"

val networkModule = module {

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    single(named("retrofit")) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    single<DeliveryApi> { get<Retrofit>(named("retrofit")).create() }
}

val repositoryModule = module {

    singleOf(::NetworkDeliveryRepositoryImpl) { bind<NetworkDeliveryRepository>() }
}

