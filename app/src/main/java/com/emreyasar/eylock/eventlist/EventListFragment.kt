package com.emreyasar.eylock.eventlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.emreyasar.eylock.R
import com.emreyasar.eylock.dashboard.LockListRecyclerViewAdapter
import com.emreyasar.eylock.databinding.FragmentEventListBinding
import com.emreyasar.eylock.databinding.FragmentLockDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EventListFragment: Fragment(), EventListContract.View {

    @Inject
    internal lateinit var presenter: EventListContract.Presenter<EventListContract.View>

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: EventListRecyclerViewAdapter

    private var _binding: FragmentEventListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventListBinding.inflate(inflater, container, false)

        linearLayoutManager = LinearLayoutManager(requireContext())
        adapter = EventListRecyclerViewAdapter(presenter)
        binding.fragmentEventList.layoutManager = linearLayoutManager
        binding.fragmentEventList.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}