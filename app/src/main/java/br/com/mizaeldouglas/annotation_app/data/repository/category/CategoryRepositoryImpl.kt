package br.com.mizaeldouglas.annotation_app.data.repository.category

import br.com.mizaeldouglas.annotation_app.data.dao.ICategoryDAO
import br.com.mizaeldouglas.annotation_app.data.entity.CategoryEntity
import br.com.mizaeldouglas.annotation_app.data.repository.ResultOperation
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDAO: ICategoryDAO
) : CategoryRepository {


    override suspend fun insertCategory(category: CategoryEntity) : ResultOperation {
        val idCategory = categoryDAO.insertCategory(category)

        if (idCategory > 0) {
            return ResultOperation(true, "Category inserted with success")
        }

        return ResultOperation(true, "Error to insert category")
    }

}