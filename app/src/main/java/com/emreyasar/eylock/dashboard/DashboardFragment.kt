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

class DashboardFragment: Fragment(), DashboardContract.View {

    private lateinit var presenter: DashboardContract.Presenter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: LockListRecyclerViewAdapter

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(DashboardPresenter(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter.onViewCreated()
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

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun setPresenter(presenter: DashboardContract.Presenter) {
        this.presenter = presenter
    }


}