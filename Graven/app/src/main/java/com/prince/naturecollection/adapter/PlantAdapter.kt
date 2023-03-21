package com.prince.naturecollection.adapter

import android.net.Uri
import android.text.Layout
import android.util.EventLogTags.Description
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prince.naturecollection.MainActivity
import com.prince.naturecollection.PlantModel
import com.prince.naturecollection.R

//layoutId pour générer un adapter générique tous les recyclerView du fragment
class PlantAdapter  (
    private val context : MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int
        ): RecyclerView.Adapter<PlantAdapter.ViewHolder>(){
    //Boite pour ranger tous les composants à controler
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val plantDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //ici on joint l'item contenant la plante : le layout item_horizontal_plant
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Recuperer les information de la plante
        val currentPlant = plantList[position]

        // Utiliser glide pour recuperer l'image à partir de son lien -> composant
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

        // Mettre à jour le nom de la plante
        holder.plantName?.text = currentPlant.name

        //Mettre à jour la description de la plante
        holder.plantDescription?.text = currentPlant.description
        if (currentPlant.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_like)
        }
        else {
            holder.starIcon.setImageResource(R.drawable.ic_unlike)
        }
    }

    // Le nombre d'item à afficher
    override fun getItemCount(): Int = plantList.size
}