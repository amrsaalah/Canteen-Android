package com.canteen.product

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canteen.base.BaseActivity
import com.canteen.product.databinding.ActivityProductBinding

/**
 * Created by Amr Salah on 3/17/2020.
 */
class ProductActivity : BaseActivity() {


    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)

    }

}