package com.example.tabwithonefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tabwithonefragment.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): MyFragment {
            val fragment = MyFragment()
            val args = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category = arguments?.getString(ARG_CATEGORY)
        binding.categoryText.text = category
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}