package data

import android.arch.persistence.room.TypeConverter

import java.util.Date

internal object DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}

/**
 * 4 visibility modifiers in Kotlin
 *
 * private: within itself
 * protected: not available for top-level declarations
 * internal: within current module
 * public: default invisible
 *
 */


/**
 * Open class: can have subclass
 * Sealed class: subclass in the same file
 * Final class: by default
 * object: singleton
 */