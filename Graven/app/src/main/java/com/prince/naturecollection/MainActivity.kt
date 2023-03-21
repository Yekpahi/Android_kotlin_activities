package com.prince.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prince.naturecollection.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Charger notre repository
        val repo = PlantRepository()

        // Mettre jour la liste des plantes

        repo.updateData {
            //Injecter le fragment dans notre boite (fragment_ container)

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}