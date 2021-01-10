package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        // Build a sample list of shoes
        val shoes: ArrayList<Shoe> = ArrayList()

        // Attribution note: name, company, and description strings below are copied from Zappos web site
        shoes.add(
            Shoe(
                "Air Zoom Pegasus 37",
                10.0,
                "Nike",
                "From the indoor track to the treadmill, these running shoes will take your running routine further than ever before"
            )
        )
        shoes.add(
            Shoe(
                "Fresh Foam Tempo",
                11.0,
                "New Balance",
                "These running shoes offer a colorful and supportive ride for your runs around the track"
            )
        )
        shoes.add(
            Shoe(
                "GT-2000 8",
                10.5,
                "Asics",
                "Get ready to run your best run yet with these running shoes"
            )
        )

        _shoeList.value = shoes
    }
}