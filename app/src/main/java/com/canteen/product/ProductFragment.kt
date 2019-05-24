package com.canteen.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canteen.base.BaseFragment
import com.canteen.databinding.FragmentProductBinding

/**
 * Created by Amr Salah on 5/24/2019.
 */

class ProductFragment : BaseFragment() {

    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }
}