package br.edu.unisep.news_prg_dsm.ui.sources.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.ItemSourcesBinding
import br.edu.unisep.news_prg_dsm.domain.dto.SourcesDto

class SourcesAdapter : RecyclerView.Adapter<SourcesAdapter.SourcesViewHolder>() {

    lateinit var onNameClick: (SourcesDto) -> Unit


    var sources: List<SourcesDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_sources, parent, false)
        return SourcesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        holder.bind(sources[position],onNameClick)
    }

    override fun getItemCount() = sources.size

    inner class SourcesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val bindingItem = ItemSourcesBinding.bind(itemView)



        fun bind(sources: SourcesDto, onTitleClick: (SourcesDto) -> Unit) {
            bindingItem.tvName.text = sources.name
            bindingItem.tvDescription.text = sources.description

            bindingItem.tvName.setOnClickListener { onTitleClick(sources) }


        }

    }

}