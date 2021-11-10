package com.emreyasar.eylock.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emreyasar.eylock.databinding.FragmentAdminUserListBinding

class AdminUserListFragment: Fragment() {

    private var _binding: FragmentAdminUserListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminUserListBinding.inflate(inflater, container, false)

        return binding.root
    }

}