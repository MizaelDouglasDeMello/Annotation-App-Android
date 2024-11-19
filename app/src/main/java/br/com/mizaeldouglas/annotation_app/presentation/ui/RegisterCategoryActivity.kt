package br.com.mizaeldouglas.annotation_app.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mizaeldouglas.annotation_app.databinding.ActivityRegisterCategoryBinding

class RegisterCategoryActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRegisterCategoryBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}