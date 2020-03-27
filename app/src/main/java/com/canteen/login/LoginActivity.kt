package com.canteen.login

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import com.canteen.R
import com.canteen.base.BaseActivity
import com.canteen.product.ProductActivity

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val navController = findNavController(R.id.navHostLogin)

        startActivity(Intent(this, ProductActivity::class.java))
    }

}
