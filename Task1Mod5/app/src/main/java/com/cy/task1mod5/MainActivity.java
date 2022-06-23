package com.cy.task1mod5;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cy.task1mod5.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.math.BigDecimal;
import java.util.List;
import com.google.gson.*;

public class MainActivity extends AppCompatActivity {
    class Staff {
        public String name;
        public int age;
        public String position;
        public BigDecimal salary;
        public List<String> skills;
    }
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//
        String jsonString="{\"name\":\"Anton\",\"age\":15,\"position\":\"Junior\",\"salary\":100,\"skills\":[\"java\",\"xml\",\"python\",\"Android\"]}";
Log.i("llll",Integer.toString(countSkills(jsonString)));
        //
  }
    int countSkills(String staffJson){
        // YOUR CODE will be paced HERE
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Staff murzik = gson.fromJson(staffJson, Staff.class);
        Log.i("GSON", "sk"+murzik.skills.size());
        return murzik.skills.size();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}