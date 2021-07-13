    package br.edu.unisep.news_prg_dsm.ui.home

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.FragmentHomeBinding
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import br.edu.unisep.timesbooks.utils.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }



    private val viewModel: HomeViewModel by viewModel()

    private val adapter: HomeAdapter by inject()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = binding.root



    override fun onCreateOptionsMenu(menu: Menu,inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_home,menu)
        val manager = requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.actionSearch).actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(requireActivity().componentName))

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.setQuery("",false)
                viewModel.getNewsBySearch(query.toString())
                searchView.hideKeyboard()
                binding.rvArticle.scrollToPosition(0)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setupView()
        setupListeners()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.science -> {
                viewModel.getNewsByCategory(NEWS_SCIENCE)
            }
            R.id.business -> {
                viewModel.getNewsByCategory(NEWS_BUSINESS)
            }
            R.id.health -> {
                viewModel.getNewsByCategory(NEWS_HEALTH)
            }
            R.id.sports -> {
                viewModel.getNewsByCategory(NEWS_SPORTS)
            }
            R.id.technology -> {
                viewModel.getNewsByCategory(NEWS_TECHNOLOGY)
            }
        }
        binding.rvArticle.scrollToPosition(0)
        return true
    }

    private fun setupView() {
        adapter.onTitleClick = ::onOpenInBrowserClick

        viewModel.getNews()
        binding.rvArticle.adapter = adapter
        binding.rvArticle.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupListeners() {
        viewModel.newsResult.observe(viewLifecycleOwner,::onArticleResult)

        binding.srlArticle.setOnRefreshListener { viewModel.getNews() }

    }



    private fun onOpenInBrowserClick(article : ArticleDto){
        val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(article.url)
        )
        startActivity(intent)

    }

    private fun onArticleResult(article: List<ArticleDto>){
        adapter.article = article
        binding.srlArticle.isRefreshing = false

    }



}