package com.aminprojects.search_room_fts4.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aminprojects.search_room_fts4.data.room.dao.NewsDao
import com.aminprojects.search_room_fts4.data.room.entity.News
import com.aminprojects.search_room_fts4.data.room.entity.NewsFts


@Database(entities = [NewsFts::class, News::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}