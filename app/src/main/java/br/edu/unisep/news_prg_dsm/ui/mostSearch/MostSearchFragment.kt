package br.edu.unisep.news_prg_dsm.ui.mostSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.unisep.news_prg_dsm.R

class MostSearchFragment : Fragment() {

    private lateinit var mostSearchViewModel: MostSearchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mostSearchViewModel =
                ViewModelProvider(this).get(MostSearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mostsearch, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        mostSearchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}