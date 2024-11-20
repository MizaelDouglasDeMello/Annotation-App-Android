package br.com.mizaeldouglas.annotation_app.di

import android.content.Context
import br.com.mizaeldouglas.annotation_app.data.dao.ICategoryDAO
import br.com.mizaeldouglas.annotation_app.data.database.DataBase
import br.com.mizaeldouglas.annotation_app.data.repository.category.CategoryRepository
import br.com.mizaeldouglas.annotation_app.data.repository.category.CategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : DataBase {
        return DataBase.getInstance(context)
    }

    @Provides
    fun provideCategoryDAO(dataBase: DataBase) : ICategoryDAO {
        return dataBase.categoryDao
    }

    @Provides
    fun provideCategoryRepository(categoryDAO: ICategoryDAO) : CategoryRepository {
        return CategoryRepositoryImpl(categoryDAO)
    }
}