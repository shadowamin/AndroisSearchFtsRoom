package com.aminprojects.search_room_fts4.data.room.entity

import androidx.room.Entity
import androidx.room.Fts4

@Fts4(contentEntity = News::class)
@Entity
class NewsFts(val id: String, val title: String)