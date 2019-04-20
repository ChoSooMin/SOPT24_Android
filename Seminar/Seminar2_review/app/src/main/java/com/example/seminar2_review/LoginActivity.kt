package com.example.seminar2_review

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY = 1000 // LoginActivity에서 SignupActivity로 화면 전환할 때 넘기는 코드

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // EditText FocusChangeListener
        val edtOnFocusChangeListener: View.OnFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if(hasFocus) {
                v.setBackgroundResource(R.drawable.primary_border)
            }
            else  {
                v.setBackgroundResource(R.drawable.gray_border)
            }
        }

        // EditText에 FocusChangeListener 설정해주기
        edtLoginID.onFocusChangeListener = edtOnFocusChangeListener
        edtLoginPW.onFocusChangeListener = edtOnFocusChangeListener

        txtLoginSignup.setOnClickListener {

            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss") // 이 포맷으로
            val s_time = simpleDateFormat.format(Date()) // 현재 시간, 날짜를 받아온다.

            startActivityForResult<SignupActivity>(REQUEST_CODE_LOGIN_ACTIVITY, "start_time" to s_time)
        }

        btnLoginSubmit.setOnClickListener {
            // EditText에 사용자가 입력한 값들 가져오기
            val login_id = edtLoginID.text.toString()
            val login_pw = edtLoginPW.text.toString()

            // 입력 받지 않은 EditText에 포커스가 가도록
            if (login_id == "" ) {
                edtLoginID.requestFocus()
            }
            else if (login_pw == "") {
                edtLoginPW.requestFocus()
            }
            else { // 다 입력이 되었다면 postSignupResponse
                postLoginResponse(login_id)
            }
        }
    }

    // 로그인 버튼 누르면 실행
    fun postLoginResponse(login_id : String) {
        val intent = Intent()
        intent.putExtra("login_id", login_id) // 부모 Activity에 전달할 데이터
        setResult(Activity.RESULT_OK, intent) // 부모 Activity에 intent 전달

        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { // data는 받아온 intent,,,
        super.onActivityResult(requestCode, resultCode, data)

        // requestCode와 resultCode가 제대로 되었다
        if (requestCode == REQUEST_CODE_LOGIN_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                val e_time = data!!.getStringExtra("end_time") // 받은 intent에서 데이터를 가져온다.

                // Anko 사용
                toast("End time : ${e_time}")
            }
        }
    }
}
