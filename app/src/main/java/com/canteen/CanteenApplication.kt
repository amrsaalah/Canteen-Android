package com.canteen

import androidx.databinding.DataBindingUtil
import androidx.work.Configuration
import androidx.work.WorkManager
import com.canteen.base.utils.LineNumberDebugTree
import com.canteen.di.DaggerAppComponent
import com.canteen.tasks.di.CanteenWorkerFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/19/2019.
 */
class CanteenApplication : DaggerApplication() {


    @Inject
    lateinit var workerFactory: CanteenWorkerFactory


    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(LineNumberDebugTree())

        val configuration = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
        WorkManager.initialize(this, configuration)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerAppComponent.builder().application(this).context(this).build()
        DataBindingUtil.setDefaultComponent(component)
        component.inject(this)
        return component
    }


}
