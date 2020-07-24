package com.example.initiativetracker.storage

import android.content.Context
import com.example.initiativetracker.domain.Session

class SharedPrefManager private constructor(private val mCtx: Context) {

    val session: Session
        get() {
            val sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return Session(
                sharedPreferences.getString("sessionId", null) ?: "WRONG", // TODO
                sharedPreferences.getString("masterCode", "null") ?: "AAAAAA" // TODO

            )
        }

    fun saveSession(session: Session) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("sessionId", session.sessionId)
        editor.putString("masterCode", session.masterCode)

        editor.apply()
    }

    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_pref"
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }
}
