package com.canteen.repositories.user

import com.canteen.base.Session
import com.canteen.base.User
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.preferences.UserPreferences
import com.canteen.network.api.LoginRequest
import com.canteen.network.remoteDataSource.user.IUserRemoteDataSource
import com.canteen.repositories.BaseRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/25/2019.
 */


class UserRepository @Inject constructor(
    private val userRemoteDataSource: IUserRemoteDataSource,
    private val userPreferences: UserPreferences,
    private val entryLocalDataSource: IEntryLocalDataSource,
    private val session: Session
) : BaseRepository(entryLocalDataSource), IUserRepository {


    init {
        session.currentUser = initUser()
    }


    override suspend fun login(username: String, password: String): Boolean {
        val response = userRemoteDataSource.login(LoginRequest(username, password))
        return if (response.status.isSuccessful()) {
            val user = User("", response.data!!.token, true)
            updateUser(user)
            GlobalScope.launch {
                val userResponse = userRemoteDataSource.getCurrentUser()
                if (userResponse.status.isSuccessful()) {
                    val data = userResponse.data!!
                    val user2 = User(data.name, userPreferences.getUserToken(), true)
                    updateUser(user2)
                }
            }
            true
        } else {
            false
        }
    }

    override suspend fun getCurrentUser(): User? {
        val response = userRemoteDataSource.getCurrentUser()
        return if (response.status.isSuccessful()) {
            val data = response.data!!
            val user = User(data.name, userPreferences.getUserToken(), true)
            updateUser(user)
            user
        } else {
            null
        }
    }


    override fun updateUser(user: User) {
        if (session.currentUser == null) {
            createUser(user)
        } else {
            userPreferences.setUserIsVerified(user.isVerified)
            session.currentUser?.isVerified = user.isVerified

            userPreferences.setUserName(user.name)
            session.currentUser?.name = user.name

            userPreferences.setUserToken(user.token)
            session.currentUser?.token = user.token
        }


    }

    override fun clearUser() {
        userPreferences.clearUser()
        session.currentUser = null
    }

    private fun initUser(): User? {

        val name = userPreferences.getUserName()
        val token = userPreferences.getUserToken()
        val isVerified = userPreferences.getUserIsVerified()

        if (name != null && token != null) {
            return User(name, token, isVerified)
        }

        return null
    }

    private fun createUser(user: User) {
        userPreferences.setUserIsVerified(user.isVerified)
        userPreferences.setUserName(user.name)
        userPreferences.setUserToken(user.token)
        session.currentUser = user
    }

}