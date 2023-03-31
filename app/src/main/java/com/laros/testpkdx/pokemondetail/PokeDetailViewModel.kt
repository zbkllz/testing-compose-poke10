package com.laros.testpkdx.pokemondetail

import androidx.lifecycle.ViewModel
import com.laros.testpkdx.data.remote.responses.Pokemon
import com.laros.testpkdx.repository.PokeRepo
import com.laros.testpkdx.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeDetailViewModel @Inject constructor(
    private val repository: PokeRepo)
    : ViewModel() {
    suspend fun getPokeInfo(pokemonName: String) : Resource<Pokemon>{
        return repository.getPokeInfo(pokemonName)
    }
}