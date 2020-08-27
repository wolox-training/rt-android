package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment private constructor() : WolmoFragment<HomePresenter>(), HomeView {

    override fun layout(): Int = R.layout.fragment_home

    override fun init() {}

    override fun setListeners() {
        vLogoutLink.setOnClickListener { presenter.onLogoutLinkClick() }
    }

    override fun logoutHome() = LoginActivity.start(requireContext())

    companion object {
        fun newInstance() = HomeFragment()
    }
}