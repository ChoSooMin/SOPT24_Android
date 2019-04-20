package com.example.firstseminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun postSignUpResponse(u_id : String, u_pw : String, u_name : String) {
        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val e_time = simpleDateFormat.format(Date())

        val intent : Intent = Intent()
        intent.putExtra("end_time", e_time)
        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}
