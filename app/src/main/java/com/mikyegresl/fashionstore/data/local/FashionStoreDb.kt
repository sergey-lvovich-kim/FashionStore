package com.mikyegresl.fashionstore.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mikyegresl.fashionstore.data.local.landing.BannerEntity
import com.mikyegresl.fashionstore.data.local.landing.CategoryEntity
import com.mikyegresl.fashionstore.data.local.landing.LandingDao
import com.mikyegresl.fashionstore.data.local.promotions.PromotionDao
import com.mikyegresl.fashionstore.data.local.promotions.PromotionEntity
import com.mikyegresl.fashionstore.domain.converters.XPositionConverter

@Database(
    entities = [
        BannerEntity::class,
        CategoryEntity::class,
        PromotionEntity::class
               ],
    version = 5,
    exportSchema = false
)
@TypeConverters(
    XPositionConverter::class
)
abstract class FashionStoreDb: RoomDatabase() {
    abstract fun landingDao(): LandingDao
    abstract fun promotionDao() : PromotionDao

    companion object {
        private const val DB_NAME = "fashion_store_database"

        @Volatile
        private var INSTANCE : FashionStoreDb? = null

        fun getDatabase(context: Context): FashionStoreDb {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FashionStoreDb::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}