package br.com.mizaeldouglas.annotation_app.data.repository.category

import br.com.mizaeldouglas.annotation_app.data.entity.CategoryEntity
import br.com.mizaeldouglas.annotation_app.data.repository.ResultOperation

interface CategoryRepository {

   suspend fun insertCategory(category: CategoryEntity) : ResultOperation
}