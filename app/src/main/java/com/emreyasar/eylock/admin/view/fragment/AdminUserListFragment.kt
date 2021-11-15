package com.emreyasar.eylock.admin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.emreyasar.eylock.R
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.admin.view.adapter.AdminUserListRecyclerViewAdapter
import com.emreyasar.eylock.databinding.FragmentAdminUserListBinding

class AdminUserListFragment(val presenter: AdminContract.Presenter<AdminContract.View>): Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: AdminUserListRecyclerViewAdapter

    private var _binding: FragmentAdminUserListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminUserListBinding.inflate(inflater, container, false)

        linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = AdminUserListRecyclerViewAdapter(presenter)
        binding.fragmentAdminHomeUserList.layoutManager = linearLayoutManager
        binding.fragmentAdminHomeUserList.adapter = adapter

        binding.fragmentAdminHomeNewUser.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_adminHomeFragment_to_addNewUserFragment)
        }

        return binding.root
    }

}