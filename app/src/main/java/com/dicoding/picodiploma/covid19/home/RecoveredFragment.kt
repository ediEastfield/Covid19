package com.dicoding.picodiploma.covid19.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.covid19.R
import com.dicoding.picodiploma.core.data.Resource
import com.dicoding.picodiploma.core.ui.CovidRecoveredAdapter
import com.dicoding.picodiploma.covid19.databinding.FragmentRecoveredBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecoveredFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentRecoveredBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecoveredBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val recoveredAdapter = CovidRecoveredAdapter()

            homeViewModel.country.observe(viewLifecycleOwner, { country ->
                if (country != null) {
                    when (country) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            recoveredAdapter.setData(country.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = country.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvCountry) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = recoveredAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}