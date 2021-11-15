package com.emreyasar.eylock.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.emreyasar.eylock.R
import com.emreyasar.eylock.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment: Fragment(), DashboardContract.View {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: LockListRecyclerViewAdapter

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    @Inject
    internal lateinit var presenter: DashboardContract.Presenter<DashboardContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = LockListRecyclerViewAdapter(presenter)
        binding.fragmentDashboardLockList.layoutManager = linearLayoutManager
        binding.fragmentDashboardLockList.adapter = adapter

        return binding.root
    }

    override fun onLockItemClicked() {
        view?.findNavController()?.navigate(R.id.action_dashboardFragment_to_lockDetailFragment)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }


}