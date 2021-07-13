package br.edu.unisep.news_prg_dsm.ui.football

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.FragmentFootballBinding
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import br.edu.unisep.timesbooks.utils.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MatchHomeFragment : Fragment() {

    private val binding: FragmentFootballBinding by lazy {
        FragmentFootballBinding.inflate(layoutInflater)
    }

    private val viewModel: MatchHomeViewModel by viewModel()

    private val adapter: MatchHomeAdapter by inject()

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
        inflater.inflate(R.menu.menu_football,menu)
    }

    private fun setupView() {
        binding.rvMatches.adapter = adapter
        binding.rvMatches.layoutManager = LinearLayoutManager(requireContext())
        binding.srlMatches.setOnRefreshListener { viewModel.getMatches() }

    }

    private fun setupListeners() {
        viewModel.matches.observe(viewLifecycleOwner,::onMatchesResult)

        viewModel.getMatches()
    }

    private fun onMatchesResult(article: List<MatchDto>){
        adapter.matches = article
        binding.srlMatches.isRefreshing = false

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.actionRound -> {
                viewModel.getMatches()
            }
        }
        return true
    }


}