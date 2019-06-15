package com.canteen.data.preferences

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/27/2019.
 */


class UserPreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val USER_NAME = "user_name"
        private const val USER_TOKEN = "user_token"
        private const val USER_IS_VERIFIED = "user_is_verified"
        private const val USER_ID = "user_id"
    }

    private val editor = preferences.edit()

    fun setUserId(userId: String?) {
        editor.putString(USER_ID, userId).commit()
    }

    fun getUserId() = preferences.getString(USER_ID, null)

    fun setUserName(name: String?) {
        editor.putString(USER_NAME, name).commit()
    }

    fun getUserName() = preferences.getString(USER_NAME, null)


    fun setUserToken(token: String?) {
        editor.putString(USER_TOKEN, token).commit()
    }

    fun getUserToken() = preferences.getString(USER_TOKEN, null)

    fun getUserIsVerified() = preferences.getBoolean(USER_IS_VERIFIED, false)

    fun setUserIsVerified(isVerified: Boolean) =
        editor.putBoolean(USER_IS_VERIFIED, isVerified).commit()


    fun clearUser() {
        editor.clear().commit()
    }
}