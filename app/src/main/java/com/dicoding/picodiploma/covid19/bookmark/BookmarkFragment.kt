package com.dicoding.picodiploma.covid19.bookmark

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.core.ui.NewsAdapter
import com.dicoding.picodiploma.covid19.databinding.FragmentBookmarkBinding
import com.dicoding.picodiploma.covid19.detailNews.DetailNewsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : Fragment() {

    private val bookmarkViewModel: BookmarkViewModel by viewModels()
    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val newsAdapter = NewsAdapter()
            newsAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailNewsActivity::class.java)
                intent.putExtra(DetailNewsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            bookmarkViewModel.bookmarkNews.observe(viewLifecycleOwner, { dataNews ->
                newsAdapter.setData(dataNews)
                binding.viewEmpty.root.visibility = if (dataNews.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvNews) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = newsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}