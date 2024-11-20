package br.com.mizaeldouglas.annotation_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.mizaeldouglas.annotation_app.data.entity.AnnotationEntity

@Dao
interface IAnnotationDAO {

    @Insert
    fun insert(annotation: AnnotationEntity): Long

    @Query("SELECT * FROM annotation")
    fun getAll(): List<AnnotationEntity>
}
