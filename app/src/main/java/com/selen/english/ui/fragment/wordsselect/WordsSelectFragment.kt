package com.selen.english.ui.fragment.wordsselect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.selen.english.databinding.FragmentWordsSelectBinding
import com.selen.english.model.WordModel
import com.selen.english.type.WordsSelectType
import com.selen.english.ui.base.BaseFragment
import com.selen.english.ui.fragment.wordsselect.adapter.WordsSelectAdapter
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class WordsSelectFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<WordsSelectViewModel> { viewModelFactory }

    private var _binding: FragmentWordsSelectBinding? = null
    private val binding: FragmentWordsSelectBinding
        get() = _binding!!

    private lateinit var wordsAdapter: WordsSelectAdapter

    private var wordsSelectType: WordsSelectType = WordsSelectType.WORDS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.wordsSelectComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordsSelectBinding.inflate(inflater, container, false)

        viewModel.apply {
            start()
            wordsLiveData.observe({ viewLifecycleOwner.lifecycle }, ::setWords)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordsAdapter = WordsSelectAdapter()

        binding.apply {
            selectTabs.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
                override fun onTabReselected(p0: TabLayout.Tab?) {}
                override fun onTabUnselected(p0: TabLayout.Tab?) {}
                override fun onTabSelected(tab: TabLayout.Tab) {
                    wordsSelectType = WordsSelectType.valueOf(tab.position)
                    viewModel.getWordsList(wordsSelectType)
                }
            })

            wordsList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = wordsAdapter
            }

            selectTabs.getTabAt(wordsSelectType.position)?.select()
            viewModel.getWordsList(wordsSelectType)
        }
    }


    private fun setWords(list: List<WordModel>) {
        binding.emptyListMessage.visibility = if (list.isNotEmpty()) View.GONE else View.VISIBLE

        checkAllSelectedCheckBox(list)

        wordsAdapter.setData(list)

        when (wordsSelectType) {
            WordsSelectType.WORDS -> {
                wordsAdapter.itemCheckClick = {
                    checkAllSelectedCheckBox(list)
                    viewModel.updateWordCheck(it)
                }
            }
            WordsSelectType.VERBS -> {
                wordsAdapter.itemCheckClick = {
                    checkAllSelectedCheckBox(list)
                    viewModel.updateVerbCheck(it)
                }
            }
        }
    }

    private fun checkAllSelectedCheckBox(list: List<WordModel>) {
        binding.apply {
            selectAll.setOnCheckedChangeListener(null)

            selectAll.isChecked = list.size == list.filter { it.check }.size

            selectAll.setOnCheckedChangeListener { _, isChecked ->
                when (wordsSelectType) {
                    WordsSelectType.WORDS -> {
                        viewModel.updateAllWordsCheck(isChecked)
                    }
                    WordsSelectType.VERBS -> {
                        viewModel.updateAllVerbsCheck(isChecked)
                    }
                }

                wordsAdapter.getData().forEach { it.check = isChecked }
                wordsAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}