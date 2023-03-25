package com.example.testtaskansoft.di

import com.example.testtaskansoft.feature.data.api.DeliveryApi
import com.example.testtaskansoft.feature.data.repository.NetworkDeliveryRepositoryImpl
import com.example.testtaskansoft.feature.domain.repository.NetworkDeliveryRepository
import com.example.testtaskansoft.feature.domain.usecase.AllDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.CompleteDeliveryUseCase
import com.example.testtaskansoft.feature.domain.usecase.impl.AllDeliveryUseCaseImpl
import com.example.testtaskansoft.feature.domain.usecase.impl.CompleteDeliveryUseCaseImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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
            .baseUrl("http://vseotlichno.com/api/v1/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    single<DeliveryApi> { get<Retrofit>(named("retrofit")).create() }
}

val repositoryModule = module {

    singleOf(::NetworkDeliveryRepositoryImpl) { bind<NetworkDeliveryRepository>() }

}

