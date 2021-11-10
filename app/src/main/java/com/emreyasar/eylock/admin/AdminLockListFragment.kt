package com.emreyasar.eylock.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emreyasar.eylock.databinding.FragmentAdminLockListBinding

class AdminLockListFragment: Fragment() {

    private var _binding: FragmentAdminLockListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminLockListBinding.inflate(inflater, container, false)

        return binding.root
    }

}