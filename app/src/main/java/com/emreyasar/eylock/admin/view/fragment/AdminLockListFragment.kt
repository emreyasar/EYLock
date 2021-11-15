package com.emreyasar.eylock.admin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.admin.view.adapter.AdminLockListRecyclerViewAdapter
import com.emreyasar.eylock.databinding.FragmentAdminLockListBinding

class AdminLockListFragment(val presenter: AdminContract.Presenter<AdminContract.View>): Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AdminLockListRecyclerViewAdapter

    private var _binding: FragmentAdminLockListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminLockListBinding.inflate(inflater, container, false)

        linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = AdminLockListRecyclerViewAdapter(presenter)
        binding.fragmentAdminHomeLockList.layoutManager = linearLayoutManager
        binding.fragmentAdminHomeLockList.adapter = adapter

        return binding.root
    }

}