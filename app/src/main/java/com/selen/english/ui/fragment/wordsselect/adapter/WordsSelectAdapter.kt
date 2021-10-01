package com.selen.english.ui.fragment.wordsselect.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selen.english.databinding.ItemWordsSelectBinding
import com.selen.english.model.WordModel

/**
 * @author Pyaterko Aleksey
 */
class WordsSelectAdapter : RecyclerView.Adapter<WordsSelectAdapter.WordsSelectViewHolder>() {

    private var items = mutableListOf<WordModel>()

    fun getData() = items

    fun setData(list: List<WordModel>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    var itemCheckClick: ((WordModel) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordsSelectAdapter.WordsSelectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWordsSelectBinding.inflate(inflater, parent, false)
        return WordsSelectViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WordsSelectViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class WordsSelectViewHolder(private val binding: ItemWordsSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WordModel) {
            binding.apply {
                wordSelect.setOnCheckedChangeListener { _, isChecked ->
                    item.check = isChecked
                    itemCheckClick?.invoke(item)
                }
                wordSelect.isChecked = item.check
                enWord.text = item.en
                ruWord.text = item.ru
            }
        }
    }
}
