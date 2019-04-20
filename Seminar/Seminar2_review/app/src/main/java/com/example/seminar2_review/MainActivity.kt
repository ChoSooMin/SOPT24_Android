package com.example.seminar2_review

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity
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

            startActivityForResult<LoginActivity>(REQUEST_LOGIN_CODE) // LoginActivity
        }

        btnMainClose.setOnClickListener {
            finish()
        }


        // toolbar 설정
        configureTitleBar()
        txt_toolbar_main_action.setOnClickListener {
            // 자동로그인이 되어있지 않은 상태라면
            if (SharedPreferenceController.getUserID(this) == "" ) {
                startActivity<LoginActivity>() // toolbar의 로그인 버튼을 눌렀을 때, 로그인 액티비티로 이동하도록
            }
            else { // 자동 로그인이 되어있는 상태라면
                // 현재 SharedPreferences에 저장되어 있는 값들을 모두 삭제한다.
                SharedPreferenceController.clearUserID(this)
                // 하고 다시 configureTitleBar
                configureTitleBar()
            }
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

    // onResume은 액티비티가 최상단에 띄워질 때마다 호출된다.
    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    // Toolbar의 로그인/로그아웃 버튼 텍스트 설정
    private fun configureTitleBar() {
        if (SharedPreferenceController.getUserID(this) == "") {
            txt_toolbar_main_action.text = "로그인"
        }
        else {
            txt_toolbar_main_action.text = "로그아"
        }
    }
}
