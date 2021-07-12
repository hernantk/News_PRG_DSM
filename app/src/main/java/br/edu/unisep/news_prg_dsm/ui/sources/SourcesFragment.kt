package br.edu.unisep.news_prg_dsm.ui.sources

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.FragmentSourcesBinding
import br.edu.unisep.news_prg_dsm.domain.dto.news.SourcesDto
import br.edu.unisep.timesbooks.utils.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SourcesFragment : Fragment() {

    private val binding: FragmentSourcesBinding by lazy {
        FragmentSourcesBinding.inflate(layoutInflater)
    }

    private val viewModel: SourcesViewModel by viewModel()

    private val adapter: SourcesAdapter by inject()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setupView()
        setupListeners()


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_home,menu)
    }


    private fun setupView() {
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.science -> {
                viewModel.getSourcesCategory(NEWS_SCIENCE)
            }
            R.id.business -> {
                viewModel.getSourcesCategory(NEWS_BUSINESS)
            }
            R.id.health -> {
                viewModel.getSourcesCategory(NEWS_HEALTH)
            }
            R.id.sports -> {
                viewModel.getSourcesCategory(NEWS_SPORTS)
            }
            R.id.technology -> {
                viewModel.getSourcesCategory(NEWS_TECHNOLOGY)

            }
        }
        return true
    }


}