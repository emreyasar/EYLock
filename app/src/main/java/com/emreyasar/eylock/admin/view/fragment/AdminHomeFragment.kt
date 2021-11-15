package com.emreyasar.eylock.admin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emreyasar.eylock.admin.AdminContract
import com.emreyasar.eylock.admin.presenter.AdminPresenter
import com.emreyasar.eylock.admin.view.adapter.AdminHomeViewPagerAdapter
import com.emreyasar.eylock.databinding.FragmentAdminHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AdminHomeFragment: Fragment(), AdminContract.View {

    private var _binding: FragmentAdminHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    internal lateinit var presenter: AdminContract.Presenter<AdminContract.View>

    private val pagerAdapter: AdminHomeViewPagerAdapter by lazy {
        val adapter = AdminHomeViewPagerAdapter(childFragmentManager, presenter)
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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