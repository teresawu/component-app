package data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters

import java.util.Date

@Entity(tableName = "borrow_db")
class BorrowModel(@ColumnInfo(name = "id") @PrimaryKey(autoGenerate = false) var id: Int = 0,
                  @ColumnInfo(name = "item_name") var itemName: String = "",
                  @ColumnInfo(name = "person_name") var personName: String = "")


//class BorrowModel(@PrimaryKey var id: Int, val itemName: String, val personName: String)

