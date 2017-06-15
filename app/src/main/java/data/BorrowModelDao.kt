package data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.TypeConverters

import android.arch.persistence.room.OnConflictStrategy.REPLACE

//Data Access Object class
@Dao
@TypeConverters(DateConverter::class)
interface BorrowModelDao {

    @get:Query("select * from BorrowModel")
    val allBorrowedItems: LiveData<List<BorrowModel>>

    @Query("select * from BorrowModel where id = :id")
    fun getItembyId(id: String): BorrowModel

    @Insert(onConflict = REPLACE)
    fun addBorrow(borrowModel: BorrowModel)

    @Delete
    fun deleteBorrow(borrowModel: BorrowModel)

}