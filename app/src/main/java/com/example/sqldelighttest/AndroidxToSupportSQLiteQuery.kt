package com.example.sqldelighttest


import androidx.sqlite.db.SupportSQLiteQuery

/**
 * In Sqldelight 0.9.0 we introduced androidx dependencies to all our db related classes.
 * However, Sqlbrite 3.0 is still using the legacy android db api. Before migrating to sqldelight 1.0 and remove our
 * usage of Sqlbrite, we will need this wrapper class to resolve dependency issue.
 */
class AndroidxToSupportSQLiteQuery constructor(val query: SupportSQLiteQuery)
    : android.arch.persistence.db.SupportSQLiteQuery {

    override fun bindTo(statement: android.arch.persistence.db.SupportSQLiteProgram) {
        query.bindTo(SupportSQLiteToAndroidxProgram(statement))
    }

    override fun getArgCount(): Int {
        return query.argCount
    }

    override fun getSql(): String {
        return query.sql
    }
}