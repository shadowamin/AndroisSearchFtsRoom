package com.aminprojects.search_room_fts4.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class News(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String = "",
    val description: String = "",
    val link: String = "",
    val image: String = "",
    val pubDate: String = ""
)