package com.canteen.login.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.canteen.R
import com.canteen.base.BaseFragment
import com.canteen.base.extensions.getViewModel
import com.canteen.databinding.FragmentRegisterBinding
import com.canteen.login.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class RegisterFragment : BaseFragment() {


    private lateinit var binding: FragmentRegisterBinding

    companion object {
        private const val TAG = "RegisterFragment"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        getViewModel<LoginViewModel>(
            requireActivity(),
            viewModelFactory
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: $this ")

        linLayoutRegister.setOnClickListener {
            val options: NavOptions =
                NavOptions.Builder().setPopUpTo(R.id.loginFragment, false).build()
            findNavController().navigate(R.id.forgotPasswordFragment, null, options)
        }
    }
}