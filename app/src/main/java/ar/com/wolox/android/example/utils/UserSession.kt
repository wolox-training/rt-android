package ar.com.wolox.android.example.utils

import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager

import javax.inject.Inject

@ApplicationScope
class UserSession @Inject constructor(private val sharedPreferencesManager: SharedPreferencesManager) {

    // Really, we don't need to query the username because this instance live as long as the
    // application, but we should add a check in case Android decides to kill the application
    // and return to a state where this isn't initialized.
    var username: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.USERNAME, null].also {
            field = it
        }
        set(username) {
            field = username
            sharedPreferencesManager.store(Extras.UserLogin.USERNAME, username)
        }

    var email: String? = null
        get() = sharedPreferencesManager[EMAIL_KEY, null]
        set(email) {
            field = email
            sharedPreferencesManager.store(EMAIL_KEY, email)
        }

    val userIsLogged: Boolean?
        get() = !email.isNullOrEmpty()

    fun clearEmail() = sharedPreferencesManager.clearKey(EMAIL_KEY)

    companion object {
        private const val EMAIL_KEY = "email"
    }
}
