package com.example.modernapp.data.local.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.modernapp.data.local.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteUser(userId: Int)
}

