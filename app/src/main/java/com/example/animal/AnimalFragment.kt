package com.example.animal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimalFragment : Fragment() {

    lateinit var rView : RecyclerView
    lateinit var animalAdapter: AnimalAdapter
    val animalList = mutableListOf<Animal>()

    var filteredList = listOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rView = view.findViewById(R.id.animalRV)

        populateList()
        val dataBundle = arguments
        dataBundle?.let {
            val type = it.getString("Type",null)
            when(type) {
                "Domestic" -> filteredList = animalList.filter {
                    it.type == "Domestic"
                }
                "Wild" -> filteredList = animalList.filter {
                    it.type == "Wild"
                }
                "Birds" -> filteredList = animalList.filter {
                    it.type == "Birds"
                }
            }
        }

//        populateList()

        setUpRecyclerView()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpRecyclerView(){
        animalAdapter = AnimalAdapter(filteredList, ::onAnimalSelected)
        rView.layoutManager = GridLayoutManager(activity,2)
        rView.adapter = animalAdapter
    }

    private fun onAnimalSelected(selectedAnimal: Animal){
        Toast.makeText(activity, "Selected : $selectedAnimal", Toast.LENGTH_SHORT).show()
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