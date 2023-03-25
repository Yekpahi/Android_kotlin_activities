package com.prince.naturecollection

import android.annotation.SuppressLint
import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.prince.naturecollection.adapter.PlantAdapter

class PlantPopup (
    private val adapter: PlantAdapter,
    private val currentPlant : PlantModel

        ) : Dialog(adapter.context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Ne pas afficher le titre de la fenêtre
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.pop_plants_details)
        setupComponents()
        setupCloseButton()
        setupDeleteButton()

    }
    private fun setupDeleteButton() {
        findViewById<ImageView>(R.id.delete_button).setOnClickListener {
            // supprimer la plante de la base
            val repo = PlantRepository()
            repo.deletePlant(currentPlant)
            dismiss()
        }
    }
    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.close_button).setOnClickListener {
            // Fermer la fenetre
            dismiss()
        }
    }

    @SuppressLint("WrongViewCast")
    private fun setupComponents() {
        // actualiser l'image de la plante
        val plantImage = findViewById<ImageView>(R.id.image_item)
        Glide.with(adapter.context).load(Uri.parse(currentPlant.imageUrl)).into(plantImage)

        // Actualiser la description de la plante
        findViewById<TextView>(R.id.popup_plant_name).text = currentPlant.name

        // Actualiser la description de la plante
        findViewById<TextView>(R.id.popup_plant_description_subtitle).text = currentPlant.description

        // Actualiser la description de la plante
        findViewById<TextView>(R.id.popup_plant_grow_subtitle).text = currentPlant.grow

        // Actualiser la description de la plante
        findViewById<TextView>(R.id.popup_plant_water_subtitle).text = currentPlant.water


    }
}