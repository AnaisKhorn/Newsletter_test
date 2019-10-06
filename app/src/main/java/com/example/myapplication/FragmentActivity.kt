package com.example.myapplication

import ArticlesFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_articles)

        val fragment = ArticlesFragment ()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()

    }
}
