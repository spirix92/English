package com.selen.english.ui.fragment.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.selen.english.databinding.FragmentLessonsBinding
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
            disconnectLiveData.observe({ viewLifecycleOwner.lifecycle }, ::navigateToLogin)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            test.setOnClickListener {
                testtest(viewModel.test())
            }
        }
    }

    private fun navigateToLogin(navigate: Boolean) {
//        val action = MoreFragmentDirections.actionMoreFragmentToLoginFragment()
//        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun testtest(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}