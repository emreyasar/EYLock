package com.emreyasar.eylock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emreyasar.eylock.database.AppDatabase

class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
