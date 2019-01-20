package com.bookstore.listview;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BookDetailActivity extends AppCompatActivity {

    // Activity launches onCreate() method is called first.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // Create intent to pass data into view
        Intent intent = getIntent();
        int book_id = intent.getIntExtra(BookDetailFragment.EXTRA_BOOK_ID, -1);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.book_details_one_pane, BookDetailFragment.newInstance(book_id));
        ft.commit();

        // Set actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Book Details");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);

        return true;
    }

    // Method to be run when item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                // Start shopping art activity
                Intent intent = new Intent(this, ShoppingCartActivity.class);
                startActivity(intent);
//                Toast.makeText(this, "Cart selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
