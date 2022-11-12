package mx.ipn.cic.databaseexample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.ipn.cic.databaseexample.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProductDAO(): ProductDAO

}