package com.aminprojects.search_room_fts4.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aminprojects.search_room_fts4.data.Repository
import com.aminprojects.search_room_fts4.data.room.entity.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    val loadNewsLiveData = MutableLiveData<List<News>>()

    fun loadNews() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.fetchLocalNewsData()
                repository.loadLimitedNews().collect {
                    loadNewsLiveData.postValue(it)
                }
            }
        }
    }

    fun searchNews(text: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.searchNews(text).collect {
                    loadNewsLiveData.postValue(it)
                }
            }
        }
    }
}