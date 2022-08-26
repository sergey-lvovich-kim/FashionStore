package com.mikyegresl.fashionstore.data.local.promotions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Promotion")
data class PromotionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,
    @ColumnInfo(name = "duration")
    val duration: Int,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "countdown")
    val countdown: String,
    @ColumnInfo(name = "backgroundColor")
    val backgroundColor: String,
    @ColumnInfo(name = "textColor")
    val textColor: String
)
