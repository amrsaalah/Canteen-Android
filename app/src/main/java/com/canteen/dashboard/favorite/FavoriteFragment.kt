package com.canteen.dashboard.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canteen.base.BaseFragment
import com.canteen.databinding.FragmentFavoriteBinding

/**
 * Created by Amr Salah on 5/24/2019.
 */
class FavoriteFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

}