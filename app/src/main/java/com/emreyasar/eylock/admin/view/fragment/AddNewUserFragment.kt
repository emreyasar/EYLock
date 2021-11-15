package com.emreyasar.eylock.admin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.admin.presenter.AdminNewUserPresenter
import com.emreyasar.eylock.database.repository.UserRepository
import com.emreyasar.eylock.databinding.FragmentAddNewUserBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddNewUserFragment: Fragment(), AdminContract.View {

    private var _binding: FragmentAddNewUserBinding? = null
    private val binding get() = _binding!!

    @Inject
    internal lateinit var presenter: AdminContract.NewUserPresenter<AdminContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewUserBinding.inflate(inflater, container, false)

        binding.fragmentNewUserButton.setOnClickListener {
            presenter.addNewUser("name", "email")
        }

        return binding.root
    }

}