package com.mikyegresl.fashionstore.data.local.landing

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mikyegresl.fashionstore.Constants
import com.mikyegresl.fashionstore.data.remote.landing.HorizontalPosition
import com.mikyegresl.fashionstore.data.remote.landing.VerticalPosition
import com.mikyegresl.fashionstore.domain.landing.BannerSize

@Entity(tableName = "Banner", indices = [Index(value = ["heading", "link"], unique = true)])
data class BannerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,
    @ColumnInfo(name = "heading")
    val heading: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "description")
    val description: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "videoUrl")
    val videoUrl: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "link")
    val link: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "size")
    val size: BannerSize = BannerSize.LARGE,
    @ColumnInfo(name = "backgroundColor")
    val backgroundColor: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "textColor")
    val textColor: String = Constants.EMPTY_STRING,
    @ColumnInfo(name = "xPosition")
    val xPosition: HorizontalPosition = HorizontalPosition.CENTER,
    @ColumnInfo(name = "yPosition")
    val yPosition: VerticalPosition = VerticalPosition.BOTTOM,
    @ColumnInfo(name = "isHeadingHidden")
    val isHeadingHidden: Boolean = false,
    @ColumnInfo(name = "isInverted")
    val isInverted: Boolean = false
)