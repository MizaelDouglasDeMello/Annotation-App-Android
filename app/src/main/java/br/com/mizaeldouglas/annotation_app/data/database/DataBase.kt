package br.com.mizaeldouglas.annotation_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mizaeldouglas.annotation_app.data.entity.Category
import br.com.mizaeldouglas.annotation_app.helper.Constantes.DATABASE_NAME

@Database(entities = [Category::class], version = 1)
abstract class DataBase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context): DataBase {

            return Room.databaseBuilder(
                context,
                DataBase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}