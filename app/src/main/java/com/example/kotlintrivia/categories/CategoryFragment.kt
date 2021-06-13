package com.example.kotlintrivia.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.kotlintrivia.databinding.FragmentCategoryBinding
import kotlin.collections.toTypedArray as toTypedArray1


class CategoryFragment : Fragment() {



    private val viewModel: CategoryViewModel by lazy {
        ViewModelProvider(this).get(CategoryViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater)

        //var categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        fragmentCategoryBinding.lifecycleOwner = this

        fragmentCategoryBinding.categoryViewModel = viewModel

        //fragmentCategoryBinding.categoryViewModel = categoryViewModel






        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if (it != null){
                this.findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToAssessmentFragment(it.toTypedArray1()))
                viewModel.displayQuestionsComplete()
            }
        })
        //FragmentCategoryBinding
        // Inflate the layout for this fragment
        return fragmentCategoryBinding.root
    }




}