package com.devndiplomacy.spendwise.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.*
import com.devndiplomacy.spendwise.db.dao.ExpenseDao
import com.devndiplomacy.spendwise.db.tables.Category
import com.devndiplomacy.spendwise.db.tables.Expense

@Database(
    entities = [Expense::class, Category::class],
    version = 1,
)
@ConstructedBy(SpendWiseDatabaseConstructor::class)
abstract class SpendWiseDb: RoomDatabase() {

    abstract fun getExpenseDao(): ExpenseDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SpendWiseDatabaseConstructor : RoomDatabaseConstructor<SpendWiseDb> {
    override fun initialize(): SpendWiseDb
}