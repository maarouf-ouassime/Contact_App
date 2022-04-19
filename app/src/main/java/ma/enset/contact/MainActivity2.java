package ma.enset.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import contact.R;
import androidx.appcompat.app.AppCompatActivity;

import contact.databinding.ActivityMain2Binding;
import ma.enset.contact.dao.Contact;
import ma.enset.contact.dao.RoomDB;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    RoomDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbarV2);

        binding.fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInent=new Intent(view.getContext(), ma.enset.contact.MainActivity.class);
                startActivity(myInent);
            }
        });
        database=RoomDB.getInstance(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        MenuItem save = menu.findItem(R.id.save);
        MenuItem reload = menu.findItem(R.id.reload);
        EditText fname = findViewById(R.id.editTextTextPersonName);
        EditText lname = findViewById(R.id.editTextTextPersonName2);
        EditText job = findViewById(R.id.editTextTextPersonName3);
        EditText email = findViewById(R.id.editTextTextPersonName5);
        EditText phone = findViewById(R.id.editTextTextPersonName4);
        save.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                    Contact contact = new Contact(database.contactDao().getAll().size()+1,fname.getText().toString(),lname.getText().toString(),job.getText().toString(),email.getText().toString(),phone.getText().toString());
                    database.contactDao().insert(contact);
                return false;
            }
        });
        reload.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                fname.setText("");
                lname.setText("");
                job.setText("");
                email.setText("");
                phone.setText("");
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


}