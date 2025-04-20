package com.devndiplomacy.spendwise.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.*
import com.devndiplomacy.spendwise.db.dao.ExpenseDao
import com.devndiplomacy.spendwise.db.models.ExpenseEntity

@Database(
    entities = [ExpenseEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ],
    exportSchema = true
)
@ConstructedBy(SpendWiseDatabaseConstructor::class)
abstract class SpendWiseDb: RoomDatabase() {

    abstract fun getExpenseDao(): ExpenseDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SpendWiseDatabaseConstructor : RoomDatabaseConstructor<SpendWiseDb> {
    override fun initialize(): SpendWiseDb
}