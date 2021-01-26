package com.aminprojects.search_room_fts4.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aminprojects.search_room_fts4.data.room.entity.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM News")
    fun getAll(): Flow<List<News>>

    @Query("SELECT count(*) FROM News ")
    fun countNews(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNews(news: List<News>)

    @Query("DELETE  FROM News")
    fun deleteAllNews()

    @Query("SELECT * FROM News JOIN NewsFts ON News.id == NewsFts.id WHERE NewsFts.title MATCH :text GROUP BY News.id")
    fun searchNews(text: String): Flow<List<News>>

}