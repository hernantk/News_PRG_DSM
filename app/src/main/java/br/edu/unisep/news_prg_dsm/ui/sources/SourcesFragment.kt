package br.edu.unisep.news_prg_dsm.ui.sources

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.news_prg_dsm.databinding.FragmentSourcesBinding
import br.edu.unisep.news_prg_dsm.domain.dto.SourcesDto
import br.edu.unisep.news_prg_dsm.ui.sources.SourcesViewModel
import br.edu.unisep.news_prg_dsm.ui.sources.adapter.SourcesAdapter

class SourcesFragment : Fragment() {

    private val binding: FragmentSourcesBinding by lazy {
        FragmentSourcesBinding.inflate(layoutInflater)
    }

    private val viewModel: SourcesViewModel by viewModels()

    private lateinit var adapter: SourcesAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupView()
        setupListeners()


    }


    private fun setupView() {
        adapter = SourcesAdapter()
        adapter.onNameClick = ::onNameClick

        viewModel.getSources()
        binding.rvSources.adapter = adapter
        binding.rvSources.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun setupListeners() {
        viewModel.resultSources.observe(viewLifecycleOwner,::onSourcesResult)

        binding.srlSources.setOnRefreshListener { viewModel.getSources() }

    }


    private fun onNameClick(sources : SourcesDto){
        val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(sources.url)
        )
        startActivity(intent)

    }

    private fun onSourcesResult(sources: List<SourcesDto>){
        adapter.sources = sources
        binding.srlSources.isRefreshing = false
        binding.srlSources.visibility = View.VISIBLE

    }


}