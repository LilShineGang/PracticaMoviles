package ies.sequeros.dam.pmdp.di

import ies.sequeros.dam.pmdp.vista.ProductosViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val moduloPresentacion = module {
    viewModel {  ProductosViewModel(get(), get(), get()) }
}

