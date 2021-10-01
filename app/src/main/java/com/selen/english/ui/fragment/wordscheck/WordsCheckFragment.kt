package com.selen.english.ui.fragment.wordscheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.selen.english.databinding.FragmentWordsCheckBinding
import com.selen.english.model.WordForCheckModel
import com.selen.english.type.LessonType
import com.selen.english.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class WordsCheckFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<WordsCheckViewModel> { viewModelFactory }

    private var _binding: FragmentWordsCheckBinding? = null
    private val binding: FragmentWordsCheckBinding
        get() = _binding!!

    private var currentWordCount = 0
    private var words: List<WordForCheckModel> = listOf()
    private var lessonType: LessonType = LessonType.ALL_WORDS_EN_TO_RU

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.wordsCheckComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordsCheckBinding.inflate(inflater, container, false)

        viewModel.apply {
            start()
            wordsLiveData.observe({ viewLifecycleOwner.lifecycle }, ::setWords)
        }

        loadWords()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkButtonsStatus()
        onClickListenersInit()
        loadWords()
    }

    private fun loadWords() {
        lessonType = WordsCheckFragmentArgs.fromBundle(requireArguments()).lessonType
        viewModel.getWordsList(lessonType)
    }

    private fun setWords(list: List<WordForCheckModel>) {
        words = list
        binding.apply {
            emptyListMessage.visibility = View.GONE
            dataGroup.visibility = View.VISIBLE
            previous.isEnabled = currentWordCount <= 0
            next.isEnabled = currentWordCount >= words.size
            chooseWord()
            checkButtonsStatus()
        }
    }

    private fun onClickListenersInit() {
        binding.apply {
            previous.setOnClickListener {
                currentWordCount--
                checkButtonsStatus()
                chooseWord()
            }
            next.setOnClickListener {
                currentWordCount++
                checkButtonsStatus()
                chooseWord()
            }
            checkAnswer.setOnClickListener {
                answerWord.text = words[currentWordCount].answer
            }
        }
    }

    private fun checkButtonsStatus() {
        binding.apply {
            previous.isEnabled = currentWordCount > 0
            next.isEnabled = currentWordCount < words.size - 1
        }
    }

    private fun chooseWord() {
        binding.apply {
            questionWord.text = words[currentWordCount].question
            answerWord.text = ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}