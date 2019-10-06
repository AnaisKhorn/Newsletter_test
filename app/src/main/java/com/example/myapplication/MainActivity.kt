package com.example.myapplication

import adapters.Article
import adapters.ArticleAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var planetes: Array<String>
    lateinit var spinner: Spinner
    lateinit var adapter: SpinnerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var adapterRecycler: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simple_spinner_item)

        planetes = resources.getStringArray(R.array.planetes)
        spinner = findViewById(R.id.spinner)
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,planetes)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "Vous n'avez rien selectionné", Toast.LENGTH_LONG).show()    }
            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(baseContext, "Vous avez selectionné ${planetes[position]}", Toast.LENGTH_LONG).show()
            }
        }

        recyclerView = findViewById(R.id.recycler_view)
        val articles = listOf<Article>(Article("coucou" ,"c'est moi"), Article("test", "testezifdjujferjfi_edzsçjfzefoij_rueijfezjiofds"),
            Article("cc", "cc"), Article("ff", "ff")
        )
        adapterRecycler = ArticleAdapter(articles)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = adapterRecycler
        }
    }
