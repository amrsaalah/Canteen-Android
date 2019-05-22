package com.canteen

import android.os.Bundle
import android.util.Log
import com.canteen.base.BaseActivity
import com.canteen.data.entities.Category
import com.canteen.data.localDataSource.category.CategoryLocalDataSource
import com.canteen.data.localDataSource.product.ProductLocalDataSource
import com.canteen.tasks.TasksHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : BaseActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    @Inject
    lateinit var categoryLocalDaSource: CategoryLocalDataSource

    @Inject
    lateinit var productLocalDataSource: ProductLocalDataSource

    @Inject
    lateinit var tasksHandler: TasksHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            categoryLocalDaSource.insert(Category("chips"))

            Log.d(TAG, "onCreate: " + categoryLocalDaSource.getAllCategories())
            Log.d(TAG, "onCreate: " + productLocalDataSource.getAllProducts())
            Log.d(TAG, "onCreate: " + productLocalDataSource.getProductsByCategoryId(1))
        }

        tasksHandler.startWorker()
    }

}
