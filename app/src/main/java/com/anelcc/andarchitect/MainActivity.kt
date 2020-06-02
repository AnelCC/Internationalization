package com.anelcc.andarchitect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

The lifecycle events can be handled in a LifecycleObserver, and your data management logic can go in a ViewModel class.
There are also some limitations to know about.
For example, the LifecycleObserver should not directly affect anything in the user interface.
The more you separate the concerns of these different kind of classes,
the more maintainable your Android app will be over time.
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

        lifecycle.addObserver(MyLifecycleObserver())
    }
}