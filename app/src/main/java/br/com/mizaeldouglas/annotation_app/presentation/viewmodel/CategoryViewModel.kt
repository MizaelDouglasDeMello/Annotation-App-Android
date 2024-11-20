package br.com.mizaeldouglas.annotation_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.mizaeldouglas.annotation_app.data.entity.CategoryEntity
import br.com.mizaeldouglas.annotation_app.data.repository.category.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
     private val categoryRepository: CategoryRepository
) : ViewModel() {

    fun insertCategory(categoryEntity: CategoryEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.insertCategory(categoryEntity)
        }

    }
}