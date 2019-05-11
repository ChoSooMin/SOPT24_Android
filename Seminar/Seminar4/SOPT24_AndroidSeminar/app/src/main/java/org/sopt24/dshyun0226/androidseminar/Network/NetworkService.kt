package org.sopt24.dshyun0226.androidseminar.Network

import com.google.gson.JsonObject
import org.sopt24.dshyun0226.androidseminar.Network.Get.GetMainProductListResponse
import org.sopt24.dshyun0226.androidseminar.Network.Post.PostLoginResponse
import org.sopt24.dshyun0226.androidseminar.Network.Post.PostSignupResponse
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @POST("/api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type : String,
        @Body() body : JsonObject
    ) : Call<PostLoginResponse>

    @POST("/api/auth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type : String,
        @Body() body: JsonObject
    ) : Call<PostSignupResponse>

//    @GET("/api/webtoons/main")
//    fun getMainProductListResponse(
//        @Header("Content-Type") content_type : String,
//        // Query는 ?key=value 값의 형태로 된 것,,
//        @Query("flag") flag: Int // flag에 따라 인기, 신작, 완결 작품 목록을 가져옴
//    ) : Call<GetMainProductListResponse>

    @GET("/api/webtoons/main/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type") content_type : String,
        // /로 구분되어 넣을 때는 Path를 사용하여 넣는다.
        @Path("flag") flag: Int
    ) : Call<GetMainProductListResponse>
}