package com.example.firstseminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.firstseminar.DB.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_login_id.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus == true) {
                v.setBackgroundResource(R.drawable.primary_border)
            }
            else {
                v.setBackgroundResource(R.drawable.gray_border)
            }
        }

        edt_login_pw.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus == true) {
                v.setBackgroundResource(R.drawable.primary_border)
            }
            else {
                v.setBackgroundResource(R.drawable.gray_border)
            }
        }

        btn_login_submit.setOnClickListener {
            if (edt_login_id.text.toString() == "") {
                edt_login_id.requestFocus() // 포커스 요청
            }
            else if (edt_login_pw.text.toString() == "") {
                edt_login_pw.requestFocus()
            }
            else {
                finish()
            }
        }

        txt_login_signUp.setOnClickListener {
            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())

            // with Anko
            startActivityForResult<SignupActivity>(REQUEST_CODE_LOGIN_ACTIVITY, "start_time" to s_time)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_LOGIN_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                val e_time = data!!.getStringExtra("end_time")

                // with Anko
                toast("End time : ${e_time}")
            }
        }
    }

    // SharedPreference에 값 저장
    fun postLoginResponse(u_id : String, u_pw : String) {
        // Request Login
        SharedPreferenceController.setUserID(this, u_id)

        finish()
    }
}
