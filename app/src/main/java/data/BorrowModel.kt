package data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters

import java.util.Date

@Entity //defines the database table
data class BorrowModel(@PrimaryKey(autoGenerate = true) var id: Int,
                       @TypeConverters(DateConverter::class) val borrowDate: Date,
                       val itemName: String, val personName: String)

//SQL cannot store Date by default, so we need to convert it