package com.aminprojects.search_room_fts4.data

import android.content.res.AssetManager
import com.aminprojects.search_room_fts4.data.room.dao.NewsDao
import com.aminprojects.search_room_fts4.data.room.entity.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import javax.inject.Inject

interface Repository {

    suspend fun fetchLocalNewsData()

    suspend fun loadLimitedNews(limit: Int = 5): Flow<List<News>>

    suspend fun searchNews(text: String): Flow<List<News>>
}

class RepositoryImpl @Inject constructor(val dao: NewsDao, val assets: AssetManager, val moshi: Moshi) : Repository {

    override suspend fun fetchLocalNewsData() {
        val countNews = dao.countNews()
        if (countNews > 0) return
        val newsString = assets.open("news.json").bufferedReader().use { it.readText() }
        val listData = Types.newParameterizedType(MutableList::class.java, News::class.java)
        val adapter = moshi.adapter<List<News>>(listData)
        try {
            val news = adapter.fromJson(newsString)
            news?.let { dao.insertAllNews(it) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override suspend fun loadLimitedNews(limit: Int): Flow<List<News>> {
        return dao.getAll()
    }

    override suspend fun searchNews(text: String): Flow<List<News>> {
        val wildcardQuery = String.format("*%s*", text)
        return dao.searchNews(wildcardQuery)
    }

}