package com.bookstore.listview;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BookListFragment.ItemListener {

    private boolean mTwoPane;

    // Activity launches onCreate() method is called first.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTwoPane = (findViewById(R.id.book_details_two_pane) != null);
        if (mTwoPane) {
            List<Book> books = Model.getInstance(this).getBooks();
            if (!books.isEmpty()) {
                Book book = Model.getInstance(this).getBooks().get(0);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.book_details_two_pane, BookDetailFragment.newInstance(book.getId()));
                ft.commit();
            }
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Book Store");
    }

    // Set action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);

        return true;
    }

    // Event handling code for actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
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

    // Method run when item is selected in fragment
    @Override
    public void itemSelected(Book b) {
        if (mTwoPane) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.book_details_two_pane, BookDetailFragment.newInstance(b.getId()));
            ft.commit();
        }
        else {
            Intent intent = new Intent(this, BookDetailActivity.class);
            intent.putExtra(BookDetailFragment.EXTRA_BOOK_ID, b.getId());

            startActivity(intent);
        }
    }
}
