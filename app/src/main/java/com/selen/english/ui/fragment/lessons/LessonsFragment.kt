package com.selen.english.ui.fragment.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.selen.english.databinding.FragmentLessonsBinding
import com.selen.english.type.LessonType
import com.selen.english.ui.base.BaseFragment
import javax.inject.Inject

/**
 * @author Pyaterko Aleksey
 */
class LessonsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<LessonsViewModel> { viewModelFactory }

    private var _binding: FragmentLessonsBinding? = null
    private val binding: FragmentLessonsBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.lessonsComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonsBinding.inflate(inflater, container, false)

        viewModel.apply {
            start()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListenersInit()
    }

    private fun onClickListenersInit() {
        binding.apply {
            allWordsEnRu.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.ALL_WORDS_EN_TO_RU)
                Navigation.findNavController(requireView()).navigate(action)
            }
            allWordsRuEn.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.ALL_WORDS_RU_TO_EN)
                Navigation.findNavController(requireView()).navigate(action)
            }
            allVerbsEnRu.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.ALL_VERBS_EN_TO_RU)
                Navigation.findNavController(requireView()).navigate(action)
            }
            allVerbsRuEn.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.ALL_VERBS_RU_TO_EN)
                Navigation.findNavController(requireView()).navigate(action)
            }
            selectedWordsEnRu.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.SELECTED_WORDS_EN_TO_RU)
                Navigation.findNavController(requireView()).navigate(action)
            }
            selectedWordsRuEn.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.SELECTED_WORDS_RU_TO_EN)
                Navigation.findNavController(requireView()).navigate(action)
            }
            selectedVerbsEnRu.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.SELECTED_VERBS_EN_TO_RU)
                Navigation.findNavController(requireView()).navigate(action)
            }
            selectedVerbsRuEn.setOnClickListener {
                val action =
                    LessonsFragmentDirections.actionLessonsFragmentToWordsCheckFragment(LessonType.SELECTED_VERBS_RU_TO_EN)
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}