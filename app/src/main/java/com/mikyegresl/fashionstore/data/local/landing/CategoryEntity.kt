package com.mikyegresl.fashionstore.data.local.landing

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "Category", indices = [Index(value = ["title", "link"], unique = true)])
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(name = "backgroundColor")
    val backgroundColor: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "isHeader")
    val isHeader: Boolean = false
)