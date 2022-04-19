package ma.enset.contact.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {
    // Insert query
    @Insert(onConflict =REPLACE)
    void insert(Contact contact);
    // Delete query
    @Delete
    void delete(Contact contact);

    // Update query
    @Update
    void update(Contact contact);

    // Get all data query
    @Query("SELECT * FROM Contact")
    List<Contact> getAll();
    @Query("SELECT * FROM Contact where lastName LIKE '%' || :key || '%' ")
    List<Contact> getAllByName(String key);
}
