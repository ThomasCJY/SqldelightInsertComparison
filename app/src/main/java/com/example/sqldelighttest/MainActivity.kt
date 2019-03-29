package com.example.sqldelighttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.MyDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val driver = AndroidSqliteDriver(MyDatabase.Schema, applicationContext, "test.db")
        val database = MyDatabase(driver)

        val shouldBeZero = database.hockeyPlayerQueries.select_changes().executeAsOne()

        database.hockeyPlayerQueries.insertTeam("name1", "coach1", false)

        val shouldBeOne = database.hockeyPlayerQueries.select_changes().executeAsOne()

        Log.d("ThomasTest", "shouldBeZero: $shouldBeZero; shouldBeOne: $shouldBeOne")

        setContentView(R.layout.activity_main)
    }
}
