package com.canteen

import android.os.Bundle
import com.canteen.base.BaseActivity
import com.canteen.data.localDataSource.category.CategoryLocalDataSource
import javax.inject.Inject

class MainActivity : BaseActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    @Inject
    lateinit var categoryLocalDaSource: CategoryLocalDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
