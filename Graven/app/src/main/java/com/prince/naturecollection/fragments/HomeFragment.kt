package com.prince.naturecollection.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.prince.naturecollection.MainActivity
import com.prince.naturecollection.PlantModel
import com.prince.naturecollection.PlantRepository.Singleton.plantList
import com.prince.naturecollection.R
import com.prince.naturecollection.adapter.PlantAdapter
import com.prince.naturecollection.adapter.PlantItemDecoration

class HomeFragment (
    private val context: MainActivity

        ) : Fragment() {

    //Permet d'injecter le layer fragment_home
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)


        //recuperer le recyclerview
        val horizontalRecyclerView = view?.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
            horizontalRecyclerView?.adapter = PlantAdapter(context, plantList.filter { !it.liked }, R.layout.item_horizontal_plant)

        // Recuperer le second recyclerView

        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView?.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView?.addItemDecoration(PlantItemDecoration())
        return view
    }
}