package com.canteen.dashboard

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.canteen.R
import com.canteen.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class DashboardActivity : BaseActivity() {

    companion object {
        private const val TAG = "DashboardActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navController = findNavController(R.id.navHosthome)

        val appBarConfig: AppBarConfiguration = AppBarConfiguration
            .Builder(R.id.searchFragment, R.id.homeFragment, R.id.favoriteFragment)
            .build()

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfig)
        NavigationUI.setupWithNavController(bottomNav, navController)

    }

}
