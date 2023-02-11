package com.example.mysidebar

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.mysidebar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Store the binding
  private lateinit var  binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navView.bringToFront()

         setSupportActionBar(toolbar)

            toggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout,
                R.string.nav_open,
                R.string.nav_close
            )
            drawerLayout.addDrawerListener(toggle)

            navView.setNavigationItemSelectedListener {
                when(it.itemId){

                    R.id.home -> {
                        Toast.makeText(this@MainActivity,"Home is selected", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    }

                    R.id.hotel -> {
                        Toast.makeText(this@MainActivity,"Hotel is selected", Toast.LENGTH_SHORT).show()}
                    R.id.login -> {
                        Toast.makeText(this@MainActivity, "Login is selected", Toast.LENGTH_SHORT).show()}
                    R.id.instagram -> {
                        Toast.makeText(this@MainActivity, "Instagram is selected", Toast.LENGTH_SHORT).show()}
                }
                true
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else {
            return super.onOptionsItemSelected(item)
        }

    }
}