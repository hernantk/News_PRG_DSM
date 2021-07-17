package br.edu.unisep.news_prg_dsm.ui.football

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.news_prg_dsm.MainActivity
import br.edu.unisep.news_prg_dsm.R
import br.edu.unisep.news_prg_dsm.databinding.ItemMatchBinding
import br.edu.unisep.news_prg_dsm.domain.dto.football.MatchDto
import br.edu.unisep.news_prg_dsm.domain.dto.news.ArticleDto
import br.edu.unisep.timesbooks.utils.getImage
import com.bumptech.glide.Glide
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import java.time.format.DateTimeFormatter

class MatchHomeAdapter : RecyclerView.Adapter<MatchHomeAdapter.MatchViewHolder>(){

    var round: Int = 1

    var mMatches: List<MatchDto> = listOf()
    private var matches: List<MatchDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount() = matches.size

    fun setNewData(){
        matches = mMatches.filter { matchDto -> matchDto.round == round }
        notifyDataSetChanged()
    }


    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemMatchBinding.bind(itemView)

        fun bind(match: MatchDto) {
            binding.tvTeamHome.text = match.homeTeam.name
            binding.tvScoreHome.text = match.score.fullTimeScore.homeTeamScore.toString()

            binding.tvTeamAway.text = match.awayTeam.name
            binding.tvScoreAway.text = match.score.fullTimeScore.awayTeamScore.toString()

            setTextHourGame(match)


            Glide.with(itemView.context)
                .load(getImage(match.homeTeam.id))
                .into(binding.tvImageTeamHome)

            Glide.with(itemView.context)
                .load(getImage(match.awayTeam.id))
                .into(binding.tvImageTeamAway)


        }


        private fun setTextHourGame(match: MatchDto){
            when (match.status) {
                "FINISHED" -> {
                    binding.tvHourGame.text = "Finalizado"
                    setScoreVisible()
                }
                "IN_PLAY" ->{
                    binding.tvHourGame.text = "Em Andamento"
                    setScoreVisible()
                }
                "POSTPONED" ->{
                    binding.tvHourGame.text = "Jogo Adiado Sem Data Definida"
                    setScoreGone()
                }
                else -> {
                    val context = binding.root.context
                    val dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    binding.tvHourGame.text = context.getString(R.string.label_day_football,
                        match.date.format(dateFormater).toString(),
                        match.time.toString())
                    setScoreGone()
                } } }



        private fun setScoreVisible(){
            binding.tvScoreHome.visibility=View.VISIBLE
            binding.tvScoreAway.visibility=View.VISIBLE
        }
        private fun setScoreGone(){
            binding.tvScoreHome.visibility=View.GONE
            binding.tvScoreAway.visibility=View.GONE

        }




}
}