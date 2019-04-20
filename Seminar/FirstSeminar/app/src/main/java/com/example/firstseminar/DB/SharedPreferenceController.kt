package com.example.firstseminar.DB

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string" // 얘를 테이블 하나라고 생각하면 됨

    fun setUserID(ctx: Context, u_id: String) {
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString("u_id", u_id)
        editor.commit()
    }

    fun getUserID(ctx: Context) : String {
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)

        return preference.getString("u_id", "")
    }

    fun clearUserID(ctx: Context) {
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}