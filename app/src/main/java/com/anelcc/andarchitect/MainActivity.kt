package com.anelcc.andarchitect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/*
- Understanding the activity life cycle is critical for Android developers.
Each time an activity changes its state the framework calls a function of the activity class.
And you can react to these events by overriding those functions.
I'll set on start, on resume, on pause, on stop, and on destroy.
As the application starts up I see on create, on start, and on resume.

I'll press the back button and I'll see on pause, on stop, and on destroy.

I'll reopen the application and press the home button.
I see on pause and on stop but I don't see on destroy.
And when I restart the application I see on start and resume but I don't see on create.
And this tells you that when the user presses the home button you aren't completely destroying the activity as an object.

And now I'll show what happens when you change a device's orientation.
I'll turn it sideways and that creates an entire life cycle,
including pausing, stopping, and destroying, and then creating, starting, and resuming.
*/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        Log.i(LOG_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "onDestroy")
    }
}