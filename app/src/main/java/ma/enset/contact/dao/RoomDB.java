package ma.enset.contact.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Add database entities
@Database(entities={Contact.class},version=1,exportSchema = false)

public abstract class RoomDB extends RoomDatabase {

    // create database instance
    private static RoomDB db;

    // Define database name
        private static String DATABASE_NAME="Contacts";

    public synchronized static RoomDB getInstance(Context context)
    {
        // check condition
        if(db==null)
        {
             // when database is null
            // Initialize database
            db= Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DATABASE_NAME)
            .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        // Return database
        return db;
    }

    //Create DAO
    public abstract ContactDao contactDao();
}
