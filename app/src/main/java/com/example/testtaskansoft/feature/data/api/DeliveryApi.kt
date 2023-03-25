package com.example.testtaskansoft.feature.data.api

import com.example.testtaskansoft.feature.data.dto.DeliveryListDto
import com.example.testtaskansoft.feature.domain.body.BodyComplete
import okhttp3.ResponseBody
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DeliveryApi {

    @GET(GET_DELIVERY)
    suspend fun getAllDelivery(): DeliveryListDto

    @POST(SET_DELIVERY)
    suspend fun completeDelivery(@Body bodyComplete: BodyComplete):Response<ResponseBody>

    private companion object {
        const val SET_DELIVERY = "set_delivery.php"
        const val GET_DELIVERY = "get_delivery.php"
    }
}

