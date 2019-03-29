package com.example.sqldelighttest

import com.example.MyDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DatabaseTest {

    @Test
    fun testDatabase() {
        val driver = AndroidSqliteDriver(MyDatabase.Schema, RuntimeEnvironment.application, "test.db")
        val database = MyDatabase(driver)

        val a = database.hockeyPlayerQueries.select_changes().executeAsOne()
//        assertEquals(0L, a)

        database.hockeyPlayerQueries.insertTeam("name1", "coach1", false)
        database.hockeyPlayerQueries.insertTeam("name1", "coach1", false)
        database.hockeyPlayerQueries.insertTeam("name1", "coach1", false)
        val b = database.hockeyPlayerQueries.select_lastInsertRow().executeAsOne()
        assertEquals(1L, b)

    }
}