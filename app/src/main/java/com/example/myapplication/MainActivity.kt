package com.example.myapplication

import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<AnimalData>()

        val imgPathCarpincho: String = "app/src/main/res/images/carpincho.jpg"
        val imgPathLemur: String = "app/src/main/res/images/lemur.jpg"
        val imgPathLion: String = "app/src/main/res/images/lion.jpg"

        data.add(AnimalData("Капібара", "carpincho", R.drawable.carpincho, Color.WHITE, this.resources.getString(R.string.carpincho_description)))
        data.add(AnimalData("Лемур", "lemur", R.drawable.lemur, Color.BLACK, this.resources.getString(R.string.lemur_description)))
        data.add(AnimalData("Лев", "lion", R.drawable.lion, Color.BLACK, this.resources.getString(R.string.lion_description)))

        recyclerView.adapter = AnimalsRecyclerAdapter(data, this)
    }

    public fun startActivity(longDesc: String)
    {
        startActivity(Intent(this, SecondActivity::class.java).apply
        {
            putExtra("text", longDesc)
        })
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }
}