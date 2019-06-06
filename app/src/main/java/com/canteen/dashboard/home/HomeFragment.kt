package com.canteen.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.canteen.base.BaseFragment
import com.canteen.base.extensions.getViewModel
import com.canteen.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class HomeFragment : BaseFragment() {

    companion object {
        private const val TAG = "HomeFragment"
    }

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val viewModel by lazy {
        getViewModel<HomeViewModel>(requireActivity(), viewModelFactory)
    }

    private val categoryAdapter by lazy {
        CategoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCategories.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategories.adapter = categoryAdapter

        viewModel.categories.observe(this, Observer {
            Timber.d(it.toString())
            categoryAdapter.submitList(it)
        })
    }
}