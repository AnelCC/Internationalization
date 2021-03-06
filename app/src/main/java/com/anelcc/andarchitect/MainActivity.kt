package com.anelcc.andarchitect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anelcc.andarchitect.viewmodel.DiceViewModel
import kotlinx.android.synthetic.main.activity_main.*

/*
The business logic is encapsulated in its own class,
and all of the code that's affecting the display is in the activity,
this is called separations of concerns.
How to separate concerns among different kinds of classes.
*/
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : DiceViewModel

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

        viewModel = ViewModelProviders.of(this).get(DiceViewModel::class.java)
        viewModel = ViewModelProviders.of(this)
            .get(DiceViewModel::class.java)
        viewModel.headline.observe(this, Observer {
            headline.text = it
        })
        viewModel.dice.observe(this, Observer {
            updateDisplay(it)
        })

        lifecycle.addObserver(MyLifecycleObserver())

        fab.setOnClickListener { viewModel.rollDice() }

    }

    private fun updateDisplay(dice: IntArray) {
        for (i in 0 until imageViews.size) {
            val drawableId = when (dice[i]) {
                1 -> R.drawable.die_1
                2 -> R.drawable.die_2
                3 -> R.drawable.die_3
                4 -> R.drawable.die_4
                5 -> R.drawable.die_5
                6 -> R.drawable.die_6
                else -> R.drawable.die_6
            }
            imageViews[i].setImageResource(drawableId)
        }
    }

}