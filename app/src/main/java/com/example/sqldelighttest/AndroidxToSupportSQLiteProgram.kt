package com.example.sqldelighttest



import android.arch.persistence.db.SupportSQLiteProgram

/**
 * In Sqldelight 0.9.0 we introduced androidx dependencies to all our db related classes.
 * However, Sqlbrite 3.0 is still using the legacy android db api. Before migrating to sqldelight 1.0 and remove our
 * usage of Sqlbrite, we will need this wrapper class to resolve dependency issue.
 */
class AndroidxToSupportSQLiteProgram constructor(val program: androidx.sqlite.db.SupportSQLiteProgram)
    : SupportSQLiteProgram {
    override fun bindBlob(index: Int, value: ByteArray?) {
        program.bindBlob(index, value)
    }

    override fun bindLong(index: Int, value: Long) {
        program.bindLong(index, value)
    }

    override fun bindString(index: Int, value: String?) {
        program.bindString(index, value)
    }

    override fun bindDouble(index: Int, value: Double) {
        program.bindDouble(index, value)
    }

    override fun close() {
        program.close()
    }

    override fun bindNull(index: Int) {
        program.bindNull(index)
    }

    override fun clearBindings() {
        program.clearBindings()
    }
}