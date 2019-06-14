package com.canteen.login.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.canteen.R
import com.canteen.base.BaseFragment
import com.canteen.base.extensions.getViewModel
import com.canteen.base.extensions.showToast
import com.canteen.databinding.FragmentLoginBinding
import com.canteen.presenters.user.ValidationError.EMPTY_EMAIL
import com.canteen.presenters.user.ValidationError.EMPTY_PASSWORD
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Created by Amr Salah on 5/24/2019.
 */
class LoginFragment : BaseFragment() {


    companion object {
        private const val TAG = "LoginFragment"
    }

    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val viewModel by lazy {
        getViewModel<LoginViewModel>(requireActivity(), viewModelFactory)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.toastMessage.observe(this, Observer {
            showToast(it)
        })


        txtDontHaveAccount.setOnClickListener {
            val extras = getSharedElementTransitionExtras()
            findNavController().navigate(R.id.registerFragment, null, null, extras)
        }

        viewModel.navigateToHome.observe(this, Observer {
            if (it) {
                findNavController().navigate(R.id.dashboardActivity)
                activity?.finish()
            }
        })

        viewModel.validationError.observe(this, Observer {
            when (it) {
                EMPTY_EMAIL -> inputLayoutEmail.error = getString(R.string.empty_entry)
                EMPTY_PASSWORD -> inputLayoutPassword.error = getString(R.string.empty_entry)
                else -> {
                    // clear errors
                    inputLayoutPassword.error = null
                    inputLayoutEmail.error = null
                }
            }
        })
    }


    private fun getSharedElementTransitionExtras(): FragmentNavigator.Extras {
        return FragmentNavigatorExtras(
            imgLogo to imgLogo.transitionName,
            inputLayoutEmail to inputLayoutEmail.transitionName,
            inputLayoutPassword to inputLayoutPassword.transitionName,
            txtDontHaveAccount to txtDontHaveAccount.transitionName,
            txtForgotPassword to txtForgotPassword.transitionName,
            btnLogin to btnLogin.transitionName
        )
    }
}