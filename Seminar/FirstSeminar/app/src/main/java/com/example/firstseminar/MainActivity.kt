package com.example.firstseminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainLogin.setOnClickListener {
            // 기본 문법
            val intent : Intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("id", 1)
            startActivity(intent)

            // anko 사용
//            startActivity<LoginActivity>("id" to 1)
        }

        btnMainClose.setOnClickListener {
            finish()
        }
    }
}
