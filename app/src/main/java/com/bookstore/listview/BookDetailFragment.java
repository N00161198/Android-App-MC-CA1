package com.bookstore.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailFragment extends Fragment {
    public static final String EXTRA_BOOK_ID = "book_id";

    public static BookDetailFragment newInstance(int book_id) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_BOOK_ID, book_id);
        fragment.setArguments(args);
        return fragment;
    }

    private Book mBook;

    public BookDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            int book_id = args.getInt(EXTRA_BOOK_ID, -1);
            if (book_id != -1) {
                mBook = Model.getInstance(this.getActivity()).findBookById(book_id);
            }
        }
    }

    // What should be on the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_detail, container, false);
    }

    // Customise view & set event handlers
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView mTitleTextView = view.findViewById(R.id.book_title);
        TextView mAuthorTextView = view.findViewById(R.id.book_author);
        TextView mIsbnTextView = view.findViewById(R.id.book_isbn);
        TextView mYearTextView = view.findViewById(R.id.book_year);
        TextView mPriceTextView = view.findViewById(R.id.book_price);
        Button cart_add_btn = (Button) view.findViewById(R.id.cart_add);

        if (mBook != null) {
            mTitleTextView.setText(mBook.getTitle());
            mAuthorTextView.setText(mBook.getAuthor());
            mIsbnTextView.setText(mBook.getIsbn());
            mYearTextView.setText("" + mBook.getYear());
            mPriceTextView.setText("" + mBook.getPrice());

            cart_add_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Model.getInstance(v.getContext()).getShoppingCart().add(mBook, 1);

                    Toast.makeText(getActivity(),
                            "Book " + mBook.getTitle() + " was added to your cart!", Toast.LENGTH_SHORT).show();
                }
            });

            new DownloadImageTask((ImageView) view.findViewById(R.id.book_cover_image))
                    .execute(mBook.getCoverUrl());
        }
    }
}
