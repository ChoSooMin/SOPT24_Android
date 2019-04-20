package com.example.seminar2_review

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string"

    fun setUserID(ctx : Context, user_id : String) {
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE) // MODE_PRIVATE는 해당 어플리케이션 외 다른 곳에서는 사용할 수 없음
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString("u_id", user_id)
        editor.commit()
    }

    fun getUserID(ctx : Context) : String {
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)

        return preference.getString("u_id", "")
    }

    fun clearUserID(ctx : Context) {
        val preference : SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE) // MODE_PRIVATE는 해당 어플리케이션 외 다른 곳에서는 사용할 수 없음
        val editor : SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}