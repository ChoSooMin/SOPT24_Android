package com.example.seminar2_review.Activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.seminar2_review.R
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // LoginActivity에서 넘긴 intent에서 데이터 가져오기
        val s_time = intent!!.getStringExtra("start_time")
        toast("Start time : ${s_time}")

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
        edtSignupName.onFocusChangeListener = edtOnFocusChangeListener
        edtSignupID.onFocusChangeListener = edtOnFocusChangeListener
        edtSignupPW.onFocusChangeListener = edtOnFocusChangeListener

        // 회원가입 버튼 리스너
        btnSignupSubmit.setOnClickListener {
            // EditText에 사용자가 입력한 값들 가져오기
            val signup_u_name = edtSignupName.text.toString()
            val signup_u_id = edtSignupID.text.toString()
            val signup_u_pw = edtSignupPW.text.toString()

            // 입력 받지 않은 EditText에 포커스가 가도록
            if (signup_u_name == "" ) {
                edtSignupName.requestFocus()
            }
            else if (signup_u_id == "") {
                edtSignupID.requestFocus()
            }
            else if (signup_u_pw == "") {
                edtSignupPW.requestFocus()
            }
            else { // 다 입력이 되었다면 postSignupResponse
                postSignupResponse(signup_u_name, signup_u_id, signup_u_pw)
            }
        }
    }

    fun postSignupResponse(u_name : String, u_id : String, u_pw : String) {

        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss") // 날짜 포맷
        val e_time = simpleDateFormat.format(Date()) // 현재 시간, 날짜

        val intent : Intent = Intent()
        intent.putExtra("end_time", e_time) // 부모 Activity에 전달할 데이터
        setResult(Activity.RESULT_OK, intent) // 부모 Activity에 intent 전달

        finish()
    }

}
