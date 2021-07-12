package br.edu.unisep.news_prg_dsm.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.ItemNewsBinding
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import com.bumptech.glide.Glide
import java.time.format.DateTimeFormatter

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    lateinit var onTitleClick: (ArticleDto) -> Unit


    var article: List<ArticleDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(article[position],onTitleClick)

    }

    override fun getItemCount() = article.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val bindingItem = ItemNewsBinding.bind(itemView)




        fun bind(article: ArticleDto, onOpenInBrowserClick: (ArticleDto) -> Unit) {

            bindingItem.tvTitle.text = article.title
            bindingItem.tvAuthor.text = article.author
            bindingItem.tvNews.text = article.description

            val context = bindingItem.root.context
            val dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            bindingItem.tvPublishedDate.text = context.getString(R.string.label_published,article.date?.format(dateFormater).toString())

            bindingItem.tvOpenInBrowser.setOnClickListener { onOpenInBrowserClick(article) }


            Glide.with(itemView.context)
                    .load(article.image)
                    .into(bindingItem.idImage)
        }

    }

}