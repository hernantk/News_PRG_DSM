package br.edu.unisep.news_prg_dsm.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.ItemNewsBinding
import br.edu.unisep.news_prg_dsm.domain.dto.ArticleDto
import com.bumptech.glide.Glide

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.BookViewHolder>() {

    lateinit var onImageClick: (ArticleDto) -> Unit

    var article: List<ArticleDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(article[position],onImageClick)
    }

    override fun getItemCount() = article.size

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemNewsBinding.bind(itemView)

        fun bind(article: ArticleDto, onImageClick: (ArticleDto) -> Unit) {
            binding.tvTitle.text = article.title
            binding.tvAuthor.text = article.author
            binding.tvNews.text = article.description



            Glide.with(itemView.context)
                    .load(article.image)
                    .into(binding.idImage)
        }

    }

}