package com.example.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimalActivity : AppCompatActivity() {

    lateinit var rView : RecyclerView
    lateinit var animalAdapter: AnimalAdapter
    val animalList = mutableListOf<Animal>()

    var filteredList = listOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        rView = findViewById(R.id.recyclerView)

        populateList()

        val type = intent.getIntExtra("Animal type", 1)

        when(type) {
            1 -> filteredList = animalList.filter {
                it.type == "Domestic"
            }
            2 -> filteredList = animalList.filter {
                it.type == "Wild"
            }
            3 -> filteredList = animalList.filter {
                it.type == "Birds"
            }
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        animalAdapter = AnimalAdapter(filteredList, ::onAnimalSelected)
        rView.layoutManager = GridLayoutManager(this,2)
        rView.adapter = animalAdapter
    }

    private fun onAnimalSelected(selectedAnimal: Animal){
        Toast.makeText(this, "Selected : $selectedAnimal", Toast.LENGTH_SHORT).show()
    }

    private fun populateList() {
        animalList.add(Animal("Dog","Domestic",R.drawable.dog))
        animalList.add(Animal("Cat","Domestic",R.drawable.cat))
        animalList.add(Animal("Lion","Wild",R.drawable.lion))
        animalList.add(Animal("Parrot","Birds",R.drawable.parrot))
        animalList.add(Animal("Tiger","Wild",R.drawable.tiger))
        animalList.add(Animal("Cow","Domestic",R.drawable.cow))
    }


}