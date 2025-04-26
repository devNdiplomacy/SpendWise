package com.devndiplomacy.spendwise.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devndiplomacy.spendwise.db.tables.Category

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM category where id = :id")
    suspend fun getCategory(id: Long): Category

    @Query("SELECT * FROM category")
    suspend fun getAllCategory(): List<Category>

    @Query("SELECT * FROM category where name = :name")
    suspend fun getCategoryByName(name: String): Category?
}