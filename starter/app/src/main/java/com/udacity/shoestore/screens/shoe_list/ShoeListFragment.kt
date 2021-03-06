package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding
import com.udacity.shoestore.viewmodels.MainActivityViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val mViewModel by activityViewModels<MainActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        // Set up Options Menu
        setHasOptionsMenu(true)

        // Set up FAB
        binding.buttonAdd.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_shoeListFragment_to_shoeDetailFragment
            )
        )

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Set up observers
        mViewModel.shoeList.observe(viewLifecycleOwner, {
            displayShoeList()
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun displayShoeList() {
        val layoutShoeList = binding.shoeList

        for (shoe in mViewModel.shoeList.value!!) {
            val shoeBinding = DataBindingUtil.inflate<ShoeLayoutBinding>(
                layoutInflater,
                R.layout.shoe_layout,
                layoutShoeList,
                false
            )
            shoeBinding.shoe = shoe

            layoutShoeList.addView(shoeBinding.root)
        }
    }
}