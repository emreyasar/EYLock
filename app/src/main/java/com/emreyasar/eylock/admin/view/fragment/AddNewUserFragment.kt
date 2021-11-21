package com.emreyasar.eylock.admin.view.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.databinding.FragmentAddNewUserBinding
import com.emreyasar.eylock.extensions.isEmailValid
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddNewUserFragment: Fragment(), AdminContract.View {

    private var _binding: FragmentAddNewUserBinding? = null
    private val binding get() = _binding!!

    @Inject
    internal lateinit var presenter: AdminContract.NewUserPresenter<AdminContract.View>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onViewCreated(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewUserBinding.inflate(inflater, container, false)

        binding.fragmentNewUserButton.setOnClickListener {
            if (binding.fragmentNewUserEmailInput.text.toString().isEmpty() ||
                binding.fragmentNewUserNameInput.text.toString().isEmpty() ||
                !binding.fragmentNewUserEmailInput.text.toString().isEmailValid()) {
                Toast.makeText(context, "Please check the fields" , Toast.LENGTH_SHORT).show()
            } else {
                presenter.addNewUser(binding.fragmentNewUserNameInput.text.toString(), binding.fragmentNewUserEmailInput.text.toString())
            }
        }

        return binding.root
    }

    override fun newUserAdded(result: Boolean) {
        val alertDialogBuilder = AlertDialog.Builder(requireActivity())
        if (result) {
            alertDialogBuilder.setMessage("New user added successfully")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    findNavController().popBackStack()
                })
        } else {
            alertDialogBuilder.setMessage("An error occured")
                .setCancelable(false)
                .setNegativeButton("OK", DialogInterface.OnClickListener { dialog, _ ->
                    dialog.cancel()
                })
        }
        val dialog = alertDialogBuilder.create()
        dialog.show()
    }

    override fun onDestroyView() {
        presenter.onDestroy()
        super.onDestroyView()
    }

}