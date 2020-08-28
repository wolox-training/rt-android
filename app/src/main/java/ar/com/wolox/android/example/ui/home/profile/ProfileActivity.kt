package ar.com.wolox.android.example.ui.home.profile

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class ProfileActivity : WolmoActivity() {
    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, ProfileFragment.newInstance())
    }
}