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

class EventListFragment: Fragment(), EventListContract.View {

    private lateinit var presenter: EventListContract.Presenter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: EventListRecyclerViewAdapter

    private var _binding: FragmentEventListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(EventListPresenter(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter.onViewCreated()
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

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun setPresenter(presenter: EventListContract.Presenter) {
        this.presenter = presenter
    }


}