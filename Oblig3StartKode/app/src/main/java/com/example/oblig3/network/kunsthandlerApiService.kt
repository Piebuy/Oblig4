package com.example.oblig3.network

import com.example.oblig3.data.Artist
import com.example.oblig3.data.Category
import com.example.oblig3.data.FrameType
import com.example.oblig3.data.Photo
import com.example.oblig3.data.PhotoSize
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.GET

private const val BASE_URL="http://10.0.2.2:3000/"

@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder().addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface KunsthandlerApiService {
    @GET("categories")
    suspend fun getCategories(): List<Category>

    @GET("artists")
    suspend fun getArtists(): List<Artist>

    @GET("photos")
    suspend fun getPhotos(): List<Photo>

    @GET("frametypes")
    suspend fun getFrameTypes(): List<FrameType>

    @GET("photosizes")
    suspend fun getPhotoSizes(): List<PhotoSize>
}

object KunsthandlerApi {
    val retrofitService: KunsthandlerApiService by lazy {
        retrofit.create(KunsthandlerApiService::class.java)
    }
}