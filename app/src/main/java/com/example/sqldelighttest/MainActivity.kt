package com.example.sqldelighttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import com.example.HockeyPlayerModel


class MainActivity : AppCompatActivity() {

    lateinit var insertTeam: HockeyPlayerModel.InsertTeam
    lateinit var database: SupportSQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = SupportSQLiteOpenHelper.Configuration.builder(applicationContext)
                .name("test.db")
                .callback(DbOpenCallback(1))
                .build()
        val helper = FrameworkSQLiteOpenHelperFactory().create(config)
        helper.setWriteAheadLoggingEnabled(true)
        database = helper.writableDatabase
        insertTeam = HockeyPlayerModel.InsertTeam(database)

        insertItem()

        setContentView(R.layout.activity_main)
    }

    fun insertItem() {
        insertTeam.bind("name1", "coach1", false)
        val a = insertTeam.executeInsert()
        if (a <= 0) {
            throw RuntimeException("error")
        }
    }
}
