package com.mikyegresl.fashionstore.domain.converters

import androidx.compose.foundation.layout.Arrangement
import androidx.room.TypeConverter
import com.mikyegresl.fashionstore.data.remote.landing.VerticalPosition

object YPositionConverter {
    @TypeConverter
    fun verticalPositionToArrangement(from: VerticalPosition?): Arrangement.Vertical =
        from?.let {
            when (it) {
                VerticalPosition.TOP -> Arrangement.Top
                VerticalPosition.BOTTOM -> Arrangement.Bottom
            }
        } ?: Arrangement.Center

    @TypeConverter
    fun arrangementToVerticalPosition(from: Arrangement.Vertical?): VerticalPosition =
        from?.let {
            when (it) {
                Arrangement.Top -> VerticalPosition.TOP
                Arrangement.Bottom -> VerticalPosition.BOTTOM
                else -> VerticalPosition.BOTTOM
            }
        } ?: VerticalPosition.BOTTOM
}