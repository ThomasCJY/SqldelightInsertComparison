package com.example.sqldelighttest


import android.arch.persistence.db.SupportSQLiteStatement

/**
 * In Sqldelight 0.9.0 we introduced androidx dependencies to all our db related classes.
 * However, Sqlbrite 3.0 is still using the legacy android db api. Before migrating to sqldelight 1.0 and remove our
 * usage of Sqlbrite, we will need this wrapper class to resolve dependency issue.
 */
class AndroidxToSupportSqliteStatement constructor(private val statement: androidx.sqlite.db.SupportSQLiteStatement)
    : SupportSQLiteStatement {
    override fun bindLong(index: Int, value: Long) {
        statement.bindLong(index, value)
    }

    override fun simpleQueryForLong(): Long {
        return statement.simpleQueryForLong()
    }

    override fun bindString(index: Int, value: String?) {
        statement.bindString(index, value)
    }

    override fun bindDouble(index: Int, value: Double) {
        statement.bindDouble(index, value)
    }

    override fun simpleQueryForString(): String {
        return statement.simpleQueryForString()
    }

    override fun clearBindings() {
        statement.clearBindings()
    }

    override fun execute() {
        statement.execute()
    }

    override fun executeInsert(): Long {
        return statement.executeInsert()
    }

    override fun bindBlob(index: Int, value: ByteArray?) {
        statement.bindBlob(index, value)
    }

    override fun executeUpdateDelete(): Int {
        return statement.executeUpdateDelete()
    }

    override fun close() {
        statement.close()
    }

    override fun bindNull(index: Int) {
        statement.bindNull(index)
    }
}