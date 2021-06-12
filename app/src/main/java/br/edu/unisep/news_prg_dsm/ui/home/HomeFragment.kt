package br.edu.unisep.news_prg_dsm.ui.home

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupView()
        setupListeners()


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
        binding.srlArticle.visibility = View.VISIBLE

    }


}