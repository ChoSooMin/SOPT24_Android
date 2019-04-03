package com.example.firstseminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

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
    }
}
