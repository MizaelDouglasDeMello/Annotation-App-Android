package br.com.mizaeldouglas.annotation_app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "annotation",
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id_category"],
        childColumns = ["id_category"],
        onDelete = CASCADE
    )],
    indices = [Index(value = ["id_category"])]
)
data class AnnotationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_annotation")
    val idAnnotation: Long = 0, // Valor padrão para evitar problemas de inicialização
    @ColumnInfo(name = "id_category")
    val idCategory: Long,
    val title: String,
    val description: String
)
