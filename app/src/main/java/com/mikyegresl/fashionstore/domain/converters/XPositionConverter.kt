package com.mikyegresl.fashionstore.domain.converters

import androidx.compose.ui.Alignment
import androidx.room.TypeConverter
import com.mikyegresl.fashionstore.data.remote.landing.HorizontalPosition

object XPositionConverter {

    @TypeConverter
    fun horizontalPositionToAlignment(from: HorizontalPosition?): Alignment.Horizontal =
        from?.let {
            when (it) {
                HorizontalPosition.START -> Alignment.Start
                HorizontalPosition.CENTER -> Alignment.CenterHorizontally
                HorizontalPosition.END -> Alignment.End
            }
        } ?: Alignment.CenterHorizontally

    @TypeConverter
    fun alignmentToHorizontalPosition(from: Alignment.Horizontal?): HorizontalPosition =
        from?.let {
            when (it) {
                Alignment.Start -> HorizontalPosition.START
                Alignment.CenterHorizontally -> HorizontalPosition.CENTER
                Alignment.End -> HorizontalPosition.END
                else -> HorizontalPosition.CENTER
            }
        } ?: HorizontalPosition.CENTER
}