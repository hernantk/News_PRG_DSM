package br.edu.unisep.news_prg_dsm.ui.football

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.ItemMatchBinding
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto
import java.time.format.DateTimeFormatter

class MatchHomeAdapter : RecyclerView.Adapter<MatchHomeAdapter.MatchViewHolder>(){

    var matches: List<MatchDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount() = matches.size


    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemMatchBinding.bind(itemView)

        fun bind(match: MatchDto) {
            binding.tvTeamOne.text = match.homeTeam.name
            binding.tvTeamTwo.text = match.awayTeam.name
            binding.tvScoreOne.text = match.score.fullTimeScore.homeTeamScore.toString()
            binding.tvScoreTwo.text = match.score.fullTimeScore.awayTeamScore.toString()
            setTextHourGame(match)


        }





        private fun setTextHourGame(match: MatchDto){
            when (match.status) {
                "SCHEDULED" -> {scheduled(match)}
                "FINISHED" -> {finished()}
                "ONGOING" ->{onGoing()}
                else -> {scheduled(match)} } }


        private fun finished(){
                binding.tvHourGame.text = "Finalizado"
                binding.tvScoreOne.visibility=View.VISIBLE
                binding.tvScoreTwo.visibility=View.VISIBLE
        }
        private fun onGoing(){
            binding.tvHourGame.text = "Em Andamento"
            binding.tvScoreOne.visibility=View.VISIBLE
            binding.tvScoreTwo.visibility=View.VISIBLE
        }
        private fun scheduled(match: MatchDto){
            val context = binding.root.context
            val dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            binding.tvHourGame.text = context.getString(R.string.label_day_football,
                match.date.format(dateFormater).toString(),
                match.time.toString())
            binding.tvScoreOne.visibility=View.GONE
            binding.tvScoreTwo.visibility=View.GONE
        }



}
}