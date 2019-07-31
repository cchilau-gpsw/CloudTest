package com.gopro.automation.android.cloudtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCenter.start(
            application, "7bfbd229-c0ae-4036-bd7d-e174b3b06181",
            Analytics::class.java, Crashes::class.java
        )

        setContentView(R.layout.activity_main)

        val pressMeButton = findViewById<Button>(R.id.button)
        pressMeButton.setOnClickListener {
            val textView = findViewById<TextView>(R.id.textView)
            textView.setText(R.string.new_text)
        }
    }
}
