package com.canteen.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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


    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        getViewModel<HomeViewModel>(requireActivity(), viewModelFactory)
    }

    private val categoryAdapter by lazy { CategoryAdapter() }
    private val productAdapter by lazy { ProductAdapter(viewModel) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCategories.adapter = categoryAdapter
        recyclerViewTopRatedProducts.adapter = productAdapter

        viewModel.categories.observe(this, Observer {
            Timber.d(it.toString())
            categoryAdapter.submitList(it)
        })

        viewModel.topRatedProducts.observe(this, Observer {
            Timber.d(it.toString())
            productAdapter.submitList(it)
        })

        viewModel.notifyFavChange.observe(this, Observer {
            productAdapter.notifyItemChanged(it)
        })
    }
}