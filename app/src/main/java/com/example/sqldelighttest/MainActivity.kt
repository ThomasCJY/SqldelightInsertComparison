package com.example.sqldelighttest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import com.example.MyDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.runtime.rx.asObservable
import com.squareup.sqldelight.runtime.rx.mapToList

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

        insertItem()

        setContentView(R.layout.activity_main)
    }

    fun insertItem() {
        database.hockeyPlayerQueries.insertTeam("name1", "coach1", false)
    }
}
