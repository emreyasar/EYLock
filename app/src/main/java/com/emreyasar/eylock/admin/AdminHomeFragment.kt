package com.emreyasar.eylock.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emreyasar.eylock.databinding.FragmentAdminHomeBinding

class AdminHomeFragment: Fragment() {

    private var _binding: FragmentAdminHomeBinding? = null
    private val binding get() = _binding!!

    private val pagerAdapter: AdminHomeViewPagerAdapter by lazy {
        val adapter = AdminHomeViewPagerAdapter(childFragmentManager)
        adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminHomeBinding.inflate(inflater, container, false)

        binding.fragmentAdminHomeViewPager.adapter = pagerAdapter
        binding.fragmentAdminHomeTabLayout.setupWithViewPager(binding.fragmentAdminHomeViewPager)

        return binding.root
    }

}