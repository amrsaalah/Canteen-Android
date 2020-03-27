package com.canteen.di

import android.app.Application
import android.content.Context
import androidx.databinding.DataBindingComponent
import com.canteen.CanteenApplication
import com.canteen.base.bindingAdapters.ImageViewBindingAdapter
import com.canteen.base.bindingAdapters.TextViewBindingAdapter
import com.canteen.base.di.BaseModule
import com.canteen.base.di.BindingAdapterModule
import com.canteen.base.di.ViewModelModule
import com.canteen.base.di.scopes.AppScope
import com.canteen.dashboard.DashboardModule
import com.canteen.data.di.RoomModule
import com.canteen.data.preferences.PreferencesModule
import com.canteen.login.LoginModule
import com.canteen.network.di.NetworkModule
import com.canteen.presenters.di.PresenterModule
import com.canteen.product.ProductModule
import com.canteen.repositories.di.RepositoryModule
import com.canteen.tasks.di.TasksModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Amr Salah on 5/19/2019.
 */
@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        BaseModule::class,
        RoomModule::class,
        TasksModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        PreferencesModule::class,
        BindingAdapterModule::class,
        PresenterModule::class,
        DashboardModule::class,
        LoginModule::class,
        ProductModule::class

    ]
)
interface AppComponent : AndroidInjector<CanteenApplication>, DataBindingComponent {

    override fun getTextViewBindingAdapter(): TextViewBindingAdapter
    override fun getImageViewBindingAdapter(): ImageViewBindingAdapter

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}