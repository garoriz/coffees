package com.garif.coffees.di

import com.garif.coffees.presentation.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    @MainActivityScope
    fun provideViewModel(): MainViewModel = MainViewModel()
}