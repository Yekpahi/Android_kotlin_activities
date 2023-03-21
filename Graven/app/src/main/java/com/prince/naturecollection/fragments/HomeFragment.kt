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

        // Créer une liste qui va stocker ces plantes
        val plantList = arrayListOf<PlantModel>()

        // Enregistrer une premiere plante dans notre liste
        plantList.add(
            PlantModel(
            "Pissenlit",
            "Jaune soleil",
                "https://cdn-s-www.ledauphine.com/images/CC3FEAFE-AFCC-4D59-AC45-A6A80726E293/NW_raw/rare-la-tulipe-australe-est-protegee-ne-la-cueillez-pas-photo-nicolas-dupieux-1603883005.jpg",
            false
        )
        )
        plantList.add(
            PlantModel(
                "Albana",
                "la terre est ronde",
                "https://creapills.com/wp-content/uploads/2020/05/plus-grand-jardin-de-tulipes-albert-dros.jpg",
            false
            )
        )

        plantList.add(
            PlantModel(
                "Rosette",
                "Le monde évolue",
                "https://www.jardiner-malin.fr/wp-content/uploads/2019/08/Tulipe-perroquet.jpg",
            true
            )
        )

        plantList.add(
            PlantModel(
                "Romeade",
                "Les temps bouge.",
                "https://cdn-s-www.ledauphine.com/images/95fb2884-0290-4fcb-8d31-cb31959bd961/NW_raw/la-tulipe-australe-arbore-des-couleurs-flamboyantes-jaune-a-l-interieur-et-rouge-a-l-exterieur-photo-a-p-1603883005.jpg",
                true

            )
        )

        plantList.add(
            PlantModel(
                "Avoiden",
                "Bouge un peu les gars",
                "https://creapills.com/wp-content/uploads/2020/05/plus-grand-jardin-de-tulipes-albert-dros.jpg",
            false
            )
        )

        plantList.add(
            PlantModel(
                "Donomo",
                "Le monde évolue",
                "https://monjardinmamaison.maison-travaux.fr/wp-content/uploads/sites/8/2019/03/gettyimages-766449199-615x410.jpg",
            true
            )
        )

        plantList.add(
            PlantModel(
                "Bixelle",
                "Les choses de la vie.",
                "https://www.francebleu.fr/s3/cruiser-production/2018/09/8f3a9a1f-a028-4b7b-ac09-361fb1ed5d20/1200x680_gettyimages-728837807.jpg",
            false
            )
        )

        //recuperer le recyclerview
        val horizontalRecyclerView = view?.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
            horizontalRecyclerView?.adapter = PlantAdapter(context, plantList, R.layout.item_horizontal_plant)

        // Recuperer le second recyclerView

        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView?.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView?.addItemDecoration(PlantItemDecoration())
        return view
    }
}