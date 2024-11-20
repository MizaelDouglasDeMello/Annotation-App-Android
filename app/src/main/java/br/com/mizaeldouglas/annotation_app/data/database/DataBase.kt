package br.com.mizaeldouglas.annotation_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mizaeldouglas.annotation_app.data.dao.IAnnotationDAO
import br.com.mizaeldouglas.annotation_app.data.dao.ICategoryDAO
import br.com.mizaeldouglas.annotation_app.data.entity.AnnotationEntity
import br.com.mizaeldouglas.annotation_app.data.entity.CategoryEntity
import br.com.mizaeldouglas.annotation_app.helper.Constantes.DATABASE_NAME

@Database(entities = [CategoryEntity::class, AnnotationEntity::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract val categoryDao: ICategoryDAO
    abstract val annotationDao: IAnnotationDAO

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
