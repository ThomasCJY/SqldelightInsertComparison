package com.example.sqldelighttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import com.example.MyDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

class MainActivity : AppCompatActivity() {
    lateinit var database: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = SupportSQLiteOpenHelper.Configuration.builder(applicationContext)
                .callback(AndroidSqliteDriver.Callback(MyDatabase.Schema))
                .name("test.db")
                .build()
        val helper = FrameworkSQLiteOpenHelperFactory().create(config)
        helper.setWriteAheadLoggingEnabled(true)
        val driver = AndroidSqliteDriver(helper)
        database = MyDatabase(driver)

        val shouldBeZero = database.hockeyPlayerQueries.select_changes().executeAsOne()

        val start = System.currentTimeMillis()
        for (i in 1..1000) {
            insertItem()
        }
        Log.d("ThomasTest", "time: ${System.currentTimeMillis() - start}")

        val shouldBeOne = database.hockeyPlayerQueries.select_changes().executeAsOne()

        Log.d("ThomasTest", "shouldBeZero: $shouldBeZero; shouldBeOne: $shouldBeOne")

        setContentView(R.layout.activity_main)
    }

    fun insertItem() {
        database.hockeyPlayerQueries.insertTeam("name1", "coach1", false)
        database.hockeyPlayerQueries.select_lastInsertRow().executeAsOne()
    }
}
