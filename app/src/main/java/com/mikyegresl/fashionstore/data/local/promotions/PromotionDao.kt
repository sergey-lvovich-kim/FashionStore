package com.mikyegresl.fashionstore.data.local.promotions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PromotionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPromotions(promotions: List<PromotionEntity>)

    @Query("SELECT * FROM Promotion ORDER BY id DESC")
    suspend fun getPromotions(): List<PromotionEntity>
}