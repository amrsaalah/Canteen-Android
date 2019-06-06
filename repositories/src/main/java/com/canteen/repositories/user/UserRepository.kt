package com.canteen.repositories.user

import com.canteen.base.Session
import com.canteen.base.UpdateUser
import com.canteen.base.User
import com.canteen.base.response.Resource
import com.canteen.data.localDataSource.entry.IEntryLocalDataSource
import com.canteen.data.preferences.UserPreferences
import com.canteen.network.api.LoginRequest
import com.canteen.network.api.LoginResponse
import com.canteen.network.remoteDataSource.user.IUserRemoteDataSource
import com.canteen.repositories.BaseRepository
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



    companion object {
        private const val TAG = "UserRepository"
    }

    init {
        session.currentUser = initUser()
    }


    override suspend fun login(username: String, password: String): Resource<LoginResponse> {
        return userRemoteDataSource.login(LoginRequest(username, password))
    }


    override fun createUserIfNotExist(user: User) {
        if (session.currentUser == null) {
            createUser(user)
        }
    }

    override fun updateUser(user: UpdateUser) {
        user.isVerified?.let {
            userPreferences.setUserIsVerified(it)
            session.currentUser?.isVerified = it
        }

        user.name?.let {
            userPreferences.setUserName(it)
            session.currentUser?.name = it
        }

        user.token?.let {
            userPreferences.setUserToken(it)
            session.currentUser?.token = it
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