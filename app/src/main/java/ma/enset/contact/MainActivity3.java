package ma.enset.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import contact.R;
import contact.databinding.ActivityMain3Binding;
import ma.enset.contact.dao.Contact;
import ma.enset.contact.dao.RoomDB;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    RoomDB db;
    Contact contact;
    EditText firstName;
    EditText lastName;
    EditText job;
    EditText email;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        contact = (Contact) getIntent().getSerializableExtra("Contact");

        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbarV2);
        firstName = findViewById(R.id.editTextTextPersonName);
        lastName = findViewById(R.id.editTextTextPersonName2);
        job = findViewById(R.id.editTextTextPersonName3);
        email = findViewById(R.id.editTextTextPersonName5);
        phone = findViewById(R.id.editTextTextPersonName4);
        firstName.setText(contact.getfirstName());
        lastName.setText(contact.getlastName());
        job.setText(contact.getJob());
        email.setText(contact.getEmail());
        phone.setText(contact.gettel());

        binding.fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInent=new Intent(view.getContext(), ma.enset.contact.MainActivity.class);
                startActivity(myInent);
            }
        });
        db= RoomDB.getInstance(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.update_menu, menu);
        MenuItem save = menu.findItem(R.id.save);

        save.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                    Contact contact1 = new Contact(contact.getId(),firstName.getText().toString(),lastName.getText().toString(),job.getText().toString(),email.getText().toString(),phone.getText().toString());
                    db.contactDao().update(contact1);
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