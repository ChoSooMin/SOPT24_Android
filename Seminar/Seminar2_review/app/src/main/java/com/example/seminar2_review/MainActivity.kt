package com.example.seminar2_review

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val REQUEST_LOGIN_CODE = 24

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainLogin.setOnClickListener {
            // 기본
//            val intent = Intent(this, LoginActivity::class.java)
//            intent.putExtra("id", 1)
//            startActivity(intent)

            // anko
//            startActivity<LoginActivity>()

            startActivityForResult<LoginActivity>(REQUEST_LOGIN_CODE)
        }

        btnMainClose.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_LOGIN_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val login_id = data!!.getStringExtra("login_id")

                toast("${login_id}님, 환영합니다!")
            }
        }
    }
}
