package com.anelcc.andarchitect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val imageViews by lazy {
        arrayOf<ImageView>(
            findViewById(R.id.die1),
            findViewById(R.id.die2),
            findViewById(R.id.die3),
            findViewById(R.id.die4),
            findViewById(R.id.die5)
        )
    }

    private val headline by lazy {
        findViewById<TextView>(R.id.headline)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MyLifecycleObserver())

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { fabClickHandler() }

        headline.text = getString(R.string.welcome)

        for (imageView in imageViews) {
            imageView.setImageResource(R.drawable.die_6)
        }
    }

    private fun fabClickHandler() {
        Toast.makeText(
            this, "Replace with your own action",
            Toast.LENGTH_LONG
        ).show()
    }
}