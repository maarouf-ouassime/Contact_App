package ma.enset.contact;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import contact.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import contact.databinding.ActivityMainBinding;
import ma.enset.contact.dao.Contact;
import ma.enset.contact.dao.RoomDB;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RecyclerView recyclerView;

    List<Contact> dataList=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB db;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{
                        Manifest.permission.CALL_PHONE
                },
                1);
        setSupportActionBar(binding.toolbar);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myInent=new Intent(view.getContext(),MainActivity2.class);
                startActivity(myInent);
            }
        });
        recyclerView=findViewById(R.id.recyclerV);

        db= RoomDB.getInstance(this);
        db.contactDao().insert(new Contact("Ouassime","Maarouf","ingenieur","maarouf@gmail.com","0673450057"));
        db.contactDao().insert(new Contact("Saad","Moustakim","ui/ux","Moustakim@gmail.com","0611451257"));
        db.contactDao().insert(new Contact("Rihab","Ziani","ingenieur","Ziani@gmail.com","0673422257"));
        db.contactDao().insert(new Contact("Hajar ","Zarguan","ingenieur","Zarguan@gmail.com","0633451257"));
        db.contactDao().insert(new Contact("yasin","Kabboura","ingenieur","yasin@gmail.com","0673451244"));

        db.contactDao().insert(new Contact("Ouassime-1","Maarouf-1","ingenieur","maarouf@gmail.com","0673450057"));
        db.contactDao().insert(new Contact("Saad-1","Moustakim-1","ui/ux","Moustakim@gmail.com","0611451257"));
        db.contactDao().insert(new Contact("Rihab-1","Ziani-1","ingenieur","Ziani@gmail.com","0673422257"));
        db.contactDao().insert(new Contact("Hajar-1 ","Zarguan-1","ingenieur","Zarguan@gmail.com","0633451257"));
        db.contactDao().insert(new Contact("yasin-1","Kabboura-1","ingenieur","yasin@gmail.com","0673451244"));

        dataList=db.contactDao().getAll();

        linearLayoutManager=new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);


        adapter=new ContactAdapter(MainActivity.this,dataList);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setQueryHint("entrez le nom du contact");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.searching(s);
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