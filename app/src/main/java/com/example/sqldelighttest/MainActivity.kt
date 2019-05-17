package com.example.sqldelighttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.SupportSQLiteStatement
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import com.squareup.sqldelight.android.AndroidSqliteDriver

class MainActivity : AppCompatActivity() {
    lateinit var database: BenchmarkDatabase
    lateinit var compiledStatement: SupportSQLiteStatement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = SupportSQLiteOpenHelper.Configuration.builder(applicationContext)
                .callback(AndroidSqliteDriver.Callback(BenchmarkDatabase.Schema))
                .name("test.db")
                .build()
        val helper = FrameworkSQLiteOpenHelperFactory().create(config)
        helper.setWriteAheadLoggingEnabled(true)

        val driver = BenchmarkSqliteDriver(helper)

        database = BenchmarkDatabase(driver)

        compiledStatement = helper.writableDatabase.compileStatement("""
        INSERT INTO team(name, coach, won_cup)
        VALUES (?1, ?2, ?3)
        """)

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
        database.hockeyPlayerQueries.insertTeam(compiledStatement,"name1", "coach1", false)
    }
}
