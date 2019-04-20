package com.example.firstseminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.firstseminar.DB.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_name.*
import org.jetbrains.anko.startActivityForResult

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("tagtag", "loglog")

        configureTitleBar() // 여기서는 딱히 안해줘도 되는데 onResume에서는 꼭 해줘야 함

        btnMainLogin.setOnClickListener {
            // 기본 문법
//            val intent : Intent = Intent(this, LoginActivity::class.java)
//            intent.putExtra("id", 1)
//            startActivity(intent)

            // anko 사용
//            startActivity<LoginActivity>("id" to 1)

            startActivityForResult<LoginActivity>(REQUEST_CODE_LOGIN)
        }

        btnMainClose.setOnClickListener {
            finish()
        }

        txt_toolbar_main_action.setOnClickListener {
            if (SharedPreferenceController.getUserID(this).isEmpty()) {
                txt_toolbar_main_action.text = "로그인"
            }
            else {
                SharedPreferenceController.clearUserID(this)
                configureTitleBar()
            }
        }
    }

    // onActivity가 화면 최상단에 띄워질 때마다 호출
    override fun onResume() {
        super.onResume()

        configureTitleBar()
    }

    // SharedPreferences에 아이디 값이 있느냐 없느냐에 따라 달라지는 처리
    private fun configureTitleBar() {

        Log.v("hihihi", SharedPreferenceController.getUserID(this))

        if (SharedPreferenceController.getUserID(this).isEmpty()) {
            txt_toolbar_main_action.text = "로그인"
        }
        else {
            txt_toolbar_main_action.text = "로그아웃"
        }
    }

    //
    private fun configureMainTab() {
        vp_main_product.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout : View = (this.getSystemService())
    }
}
