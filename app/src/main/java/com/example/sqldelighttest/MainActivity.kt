package com.example.sqldelighttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val result = allPlayers()
        Log.d("ThomasTest", "result: $result")

        setContentView(R.layout.activity_main)
    }

    private fun insertItem() {
        insertTeam.bind("name1", "coach1", false)
        insertTeam.executeInsert()
        insertTeam.bind("name2", "coach2", false)
        insertTeam.executeInsert()
    }

    fun allPlayers(): List<HockeyPlayer> {
        val result = mutableListOf<HockeyPlayer>()
        val query = HockeyPlayer.FACTORY.query1()
        database.query(query).use { cursor ->
            while (cursor.moveToNext()) {
                result.add(HockeyPlayer.QUERY1_MAPPER.map(cursor))
            }
        }
        return result
    }
}
