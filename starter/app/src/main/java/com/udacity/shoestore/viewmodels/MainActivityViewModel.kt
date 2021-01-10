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

        _shoeList.value = shoes
    }
}