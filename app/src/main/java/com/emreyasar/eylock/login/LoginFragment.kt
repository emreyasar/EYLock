package com.emreyasar.eylock.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.emreyasar.eylock.R
import com.emreyasar.eylock.databinding.FragmentLoginBinding

class LoginFragment: Fragment(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(LoginPresenter(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter.onViewCreated()
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.fragmentLoginButton.setOnClickListener { view: View ->
            if (binding.fragmentLoginEmailInput.text.toString() == "admin") {
                view.findNavController().navigate(R.id.action_loginFragment_to_adminHomeFragment)
            } else {
                view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        this.presenter = presenter
    }


}