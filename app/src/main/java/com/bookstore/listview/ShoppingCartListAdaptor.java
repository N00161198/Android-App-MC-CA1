package com.bookstore.listview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ShoppingCartListAdaptor extends RecyclerView.Adapter<ShoppingCartListAdaptor.ViewHolder> {
    private List<ShoppingCartItem> mShoppingCart;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mBookItem;
        public TextView mTitleTextView;
        public TextView mAuthorTextView;
        public TextView mQuantityTextView;
        public TextView mPriceTextView;
        public Button mAddButton;
        public Button mSubtractButton;

        // Create a reference to view holder objects that need to be customised
        public ViewHolder(View v) {
            super(v);
            mBookItem = v.findViewById(R.id.book_list_item);
            mTitleTextView = v.findViewById(R.id.cart_title);
            mAuthorTextView = v.findViewById(R.id.cart_author);
            mQuantityTextView = v.findViewById(R.id.cart_quantity);
            mPriceTextView = v.findViewById(R.id.cart_price);
            mAddButton = v.findViewById(R.id.cart_single_add);
            mSubtractButton = v.findViewById(R.id.cart_single_subtract);
        }
    }

    private ShoppingCartActivity mActivity;

    public ShoppingCartListAdaptor(ShoppingCartActivity activity, List<ShoppingCartItem> cartItems) {
        mActivity = activity;
        mShoppingCart = cartItems;
    }

    // Created view object
    @Override
    public ShoppingCartListAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cart, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Takes view object and customises
    // Adds data and sets event handlers
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ShoppingCartItem item = mShoppingCart.get(position);
        holder.mTitleTextView.setText(item.getBook().getTitle());
        holder.mAuthorTextView.setText(item.getBook().getAuthor());
        holder.mQuantityTextView.setText("" + item.getQuantity());
        holder.mPriceTextView.setText("" + item.getBook().getPrice());

        holder.mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newQuantity = item.getQuantity() + 1;
                item.setQuantity(newQuantity);
                holder.mQuantityTextView.setText("" + newQuantity);
            }
        });

        holder.mSubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item.getQuantity() != 0) {
                    int newQuantity = item.getQuantity() - 1;
                    item.setQuantity(newQuantity);
                    holder.mQuantityTextView.setText("" + newQuantity);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mShoppingCart.size();
    }
}