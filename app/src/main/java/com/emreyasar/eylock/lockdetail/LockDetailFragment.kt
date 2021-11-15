package com.emreyasar.eylock.lockdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.emreyasar.eylock.R
import com.emreyasar.eylock.databinding.FragmentLockDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LockDetailFragment: Fragment(), LockDetailContract.View {

    @Inject
    internal lateinit var presenter: LockDetailContract.Presenter<LockDetailContract.View>

    private var _binding: FragmentLockDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLockDetailBinding.inflate(inflater, container, false)

        binding.lockDetailShowEventListButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_lockDetailFragment_to_eventListFragment)
        }

        return binding.root
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}