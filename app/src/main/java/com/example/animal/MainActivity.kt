package com.example.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast

data class Animal(val name : String, val type : String, val imageId : Int)

class MainActivity : AppCompatActivity() {

    lateinit var typeRG : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        typeRG = findViewById(R.id.radioG)

        supportActionBar?.hide()

        typeRG.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.domeB -> Toast.makeText(this, "Domestic Animal Selected", Toast.LENGTH_SHORT).show()
                R.id.wildB -> Toast.makeText(this, "Wild Animal Selected", Toast.LENGTH_SHORT).show()
                R.id.birdB -> Toast.makeText(this, "Bird Selected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun nextClick(view: View) {

        var type = ""

        when(typeRG.checkedRadioButtonId){
            R.id.domeB -> { type = "Domestic" }
            R.id.wildB -> { type = "Wild" }
            R.id.birdB -> { type = "Birds" }
        }

        /** for activity */
//        val i = Intent(this, AnimalActivity::class.java)
//        i.putExtra("Animal type", type)
//        startActivity(i)

        /** for fragment */
        val b = Bundle()
        b.putString("Type",type)
        val transaction = supportFragmentManager.beginTransaction()
        val frag = AnimalFragment()
        frag.arguments = b
        transaction.replace(R.id.parentFL,frag)
        transaction.commit()


    }

//    fun animalType(Type : String, flag : Int){
//        val transaction =  supportFragmentManager.beginTransaction()
//        val frag = AnimalFragment()
//
//        val b = Bundle()
//        b.putString("type",Type)
//        b.putString(1,flag)
//
//        frag.arguments = b
//
//        transaction.replace(R.id.parentFL,frag)
//        transaction.commit()
//    }
}