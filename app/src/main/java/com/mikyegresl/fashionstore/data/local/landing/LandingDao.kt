package com.mikyegresl.fashionstore.data.local.landing

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LandingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBanner(banner: BannerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>)

    @Query("SELECT * FROM Banner ORDER BY id DESC LIMIT 1")
    suspend fun getBanner(): BannerEntity

    @Query("SELECT * FROM Category ORDER BY id DESC")
    suspend fun getCategories(): List<CategoryEntity>
}