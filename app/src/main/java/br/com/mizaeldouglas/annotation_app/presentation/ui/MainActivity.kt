package br.com.mizaeldouglas.annotation_app.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import br.com.mizaeldouglas.annotation_app.R
import br.com.mizaeldouglas.annotation_app.data.database.DataBase
import br.com.mizaeldouglas.annotation_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var database: DataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        initializeBarMenu()
        initializeEventClick()

    }

    private fun initializeEventClick() {
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, RegisterAnnotationActivity::class.java))
        }
    }

    private fun initializeBarMenu() {

        addMenuProvider(object : MenuProvider {

            // Implementação do MenuProvider
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)
                val itemSearch = menu.findItem(R.id.item_search)
                val searchView = itemSearch.actionView as SearchView

                searchView.queryHint = "Digital o que deseja buscar"
                searchView.setOnCloseListener {
                    true
                }

                // Implementação do SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        return true
                    }
                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.item_search -> {
                        true
                    }

                    else -> true
                }
            }
        })
    }


}