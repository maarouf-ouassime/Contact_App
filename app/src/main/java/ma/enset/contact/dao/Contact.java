package ma.enset.contact.dao;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Contact implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "firstName")
    String firstName;
    @ColumnInfo(name = "lastName")
    String lastName;
    @ColumnInfo(name = "job")
    String job;
    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "tel")
    String tel;

    public Contact(String firstName, String lastName, String job, String email, String tel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.email = email;
        this.tel = tel;
    }

    public Contact() {
    }

    public Contact(int id, String firstName, String lastName, String job, String email, String tel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.email = email;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettel() {
        return tel;
    }

    public void settel(String tel) {
        this.tel = tel;
    }
}
