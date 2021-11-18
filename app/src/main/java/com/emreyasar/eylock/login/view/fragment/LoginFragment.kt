package com.emreyasar.eylock.login.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.emreyasar.eylock.EYLockContext
import com.emreyasar.eylock.R
import com.emreyasar.eylock.databinding.FragmentLoginBinding
import com.emreyasar.eylock.extensions.isEmailValid
import com.emreyasar.eylock.login.LoginContract
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
            if (binding.fragmentLoginEmailInput.text.toString().isEmpty() ||
                binding.fragmentLoginPasswordInput.text.toString().isEmpty() ||
                !binding.fragmentLoginEmailInput.text.toString().isEmailValid()) {
                Toast.makeText(context, "Please check the fields" , Toast.LENGTH_SHORT).show()
            } else {
                presenter.login(binding.fragmentLoginEmailInput.text.toString(), binding.fragmentLoginPasswordInput.text.toString())
            }
        }

        binding.fragmentAdminLoginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_adminHomeFragment)
        }

        return binding.root
    }

    override fun loginCompleted(result: Boolean, userId: Long?) {
        if (result) {
            EYLockContext.loginUserId = userId
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_dashboardFragment)
        } else {
            Toast.makeText(context, "Incorrect username/password" , Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }


}