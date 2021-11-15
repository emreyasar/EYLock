package com.emreyasar.eylock.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.emreyasar.eylock.R
import com.emreyasar.eylock.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: Fragment(), LoginContract.View {

    @Inject
    internal lateinit var presenter: LoginContract.Presenter<LoginContract.View>

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewCreated(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.fragmentLoginButton.setOnClickListener { view: View ->
            if (binding.fragmentLoginEmailInput.text.toString().isEmpty() || binding.fragmentLoginPasswordInput.text.toString().isEmpty()) {
                Toast.makeText(context, "Please fill the all required fields" , Toast.LENGTH_SHORT).show()
            } else {
                view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            }
        }

        binding.fragmentAdminLoginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_adminHomeFragment)
        }

        return binding.root
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }


}