package com.example.kotlintrivia.categories

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.kotlintrivia.R

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


        setHasOptionsMenu(true)
        //FragmentCategoryBinding
        // Inflate the layout for this fragment
        return fragmentCategoryBinding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }




}