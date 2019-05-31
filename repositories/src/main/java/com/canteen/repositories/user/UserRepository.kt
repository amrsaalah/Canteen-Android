package com.canteen.repositories.user

import com.canteen.base.di.scopes.AppScope
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.preferences.UpdateUser
import com.canteen.data.preferences.User
import com.canteen.data.preferences.UserPreferences
import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import com.canteen.network.remoteDataSource.user.IUserRemoteDataSource
import com.canteen.repositories.BaseRepository
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/25/2019.
 */

@AppScope
class UserRepository @Inject constructor(
    private val userRemoteDataSource: IUserRemoteDataSource,
    private val userPreferences: UserPreferences,
    private val entryLocalDataSource: IEntryLocalDataSource
) : BaseRepository(entryLocalDataSource), IUserRepository {

    override suspend fun login(username: String, password: String): LoginResponse {
        return userRemoteDataSource.login(LoginRequest(username, password))
    }


    var currentUser: User? = initUser()


    override fun createUserIfNotExist(user: User) {
        if (this.currentUser == null) {
            createUser(user)
        }
    }

    override fun updateUser(user: UpdateUser) {
        user.isVerified?.let {
            userPreferences.setUserIsVerified(it)
            this.currentUser?.isVerified = it
        }

        user.name?.let {
            userPreferences.setUserName(it)
            this.currentUser?.name = it
        }

        user.token?.let {
            userPreferences.setUserToken(it)
            this.currentUser?.token = it
        }
    }

    override fun clearUser() {
        userPreferences.clearUser()
        this.currentUser = null
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
        this.currentUser = user
    }

}