package br.edu.unisep.news_prg_dsm.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.FragmentHomeBinding
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import br.edu.unisep.news_prg_dsm.ui.home.adapter.HomeAdapter
import br.edu.unisep.timesbooks.utils.hideKeyboard

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = binding.root



    override fun onCreateOptionsMenu(menu: Menu,inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_home,menu)
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
                viewModel.getNewsByCategory("science")
            }
            R.id.business -> {
                viewModel.getNewsByCategory("business")
            }
            R.id.health -> {
                viewModel.getNewsByCategory("health")
            }
            R.id.sports -> {
                viewModel.getNewsByCategory("sports")
            }
            R.id.technology -> {
                viewModel.getNewsByCategory("technology")
            }
            R.id.btnS ->{
                searchVisible()
            }
        }

        return true
    }

    private fun setupView() {
        adapter = HomeAdapter()
        adapter.onTitleClick = ::onTitleClick


        viewModel.getNews()
        binding.rvArticle.adapter = adapter
        binding.rvArticle.layoutManager = LinearLayoutManager(requireContext())
        binding.btnSearch.setOnClickListener{onSearchClick()}


    }

    private fun setupListeners() {
        viewModel.newsResult.observe(viewLifecycleOwner,::onArticleResult)

        binding.srlArticle.setOnRefreshListener { viewModel.getNews() }

    }

    private fun onSearchClick(){
        binding.tvSearch.hideKeyboard()
        viewModel.getNewsBySearch(binding.tvSearch.text.toString())



    }

    private fun onTitleClick(article : ArticleDto){
        val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(article.url)
        )
        startActivity(intent)

    }

    private fun onArticleResult(article: List<ArticleDto>){
        adapter.article = article
        binding.srlArticle.isRefreshing = false
        searchGone()

    }

    private fun searchGone(){
        binding.btnSearch.visibility = View.GONE
        binding.tvSearch.visibility = View.GONE
    }

    private fun searchVisible(){
        binding.btnSearch.visibility = View.VISIBLE
        binding.tvSearch.visibility = View.VISIBLE
    }


}