package com.example.apicallappication.INTREFACE

import com.example.apicallappication.RESPONSE.RetrofitResponse
import retrofit2.http.GET

interface PoductInreface {

    @GET("products")
    suspend fun getProduct() : retrofit2.Response<RetrofitResponse>
}