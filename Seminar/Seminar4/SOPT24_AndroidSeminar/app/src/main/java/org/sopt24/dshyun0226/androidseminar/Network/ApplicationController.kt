package org.sopt24.dshyun0226.androidseminar.Network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : Application() {

    private val baseURL = "http://hyunjkluz.ml:2424/"
    lateinit var networkService : NetworkService // 객체 하나를 만든다고 생각

    // companion object는 이 클래스 내에서 사용하는 상수 인스턴스들을 여기다 정의해준다.
    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this // instance,,,?
        buildNetwork()
    }

    fun buildNetwork() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // 여기까지 하면 네트워크 통신을 할 수 있는 객체가 만들어짐

        networkService = retrofit.create(NetworkService::class.java)
    }
}