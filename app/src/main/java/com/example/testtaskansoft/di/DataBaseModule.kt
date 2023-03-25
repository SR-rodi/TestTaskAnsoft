package com.example.testtaskansoft.di

import androidx.room.Room
import com.example.testtaskansoft.feature.data.database.DeliveryDatabase
import com.example.testtaskansoft.feature.data.repository.LocalDeliveryRepositoryImpl
import com.example.testtaskansoft.feature.domain.repository.LocalDeliveryRepository
import org.koin.dsl.module

val dataBaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            DeliveryDatabase::class.java,
            "DeliveryDataBase"
        ).build()
    }

    single {
        get<DeliveryDatabase>().deliveryDao()
    }

    //singleOf(::LocalDeliveryRepositoryImpl){bind<LocalDeliveryRepository>()}

    single<LocalDeliveryRepository> { LocalDeliveryRepositoryImpl(get()) }
}