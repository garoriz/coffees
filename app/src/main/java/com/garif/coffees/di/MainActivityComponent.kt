package com.garif.coffees.di

import com.garif.coffees.presentation.MainViewModel
import dagger.Component

@Component(
    modules = [MainActivityModule::class]
)
@MainActivityScope
interface MainActivityComponent {
    @Component.Builder
    interface Builder {
        fun build(): MainActivityComponent
    }

    fun getViewModel(): MainViewModel
}