package br.com.mizaeldouglas.annotation_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mizaeldouglas.annotation_app.data.entity.CategoryEntity

@Dao
interface ICategoryDAO {

    @Insert
    fun insertCategory(categoryEntity: CategoryEntity): Long

    @Query("SELECT * FROM category")
    fun getAllCategories(): List<CategoryEntity>
}