package com.canteen.login.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.canteen.R
import com.canteen.base.BaseFragment
import com.canteen.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * Created by Amr Salah on 5/24/2019.
 */
class RegisterFragment : BaseFragment() {


    private lateinit var binding: FragmentRegisterBinding

    companion object {
        private const val TAG = "RegisterFragment"
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