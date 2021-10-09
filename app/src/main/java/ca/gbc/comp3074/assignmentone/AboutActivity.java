package ca.gbc.comp3074.assignmentone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_hamburger || item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem hamburgerItem = menu.findItem(R.id.item_hamburger);
        MenuItem aboutItem = menu.findItem(R.id.item_about);
        hamburgerItem.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        aboutItem.setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }*/



}