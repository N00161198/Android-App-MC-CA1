package com.bookstore.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ShoppingCartListFragment extends Fragment {

//    public interface ItemListener {
//        public void itemSelected(Book b);
//    }

    private ShoppingCartActivity shoppingCartActivity = null;

    public ShoppingCartListFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ShoppingCartActivity){
            this.shoppingCartActivity = (ShoppingCartActivity) context;
        }
    }

    // What should be on the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_cart_list, container, false);
    }

    // Customise view & set event handlers
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecyclerView = view.findViewById(R.id.shopping_cart_list_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(shoppingCartActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<ShoppingCartItem> shoppingCartItems = Model.getInstance(shoppingCartActivity).getShoppingCart().getItems();

        RecyclerView.Adapter adapter = new ShoppingCartListAdaptor(shoppingCartActivity, shoppingCartItems);
        mRecyclerView.setAdapter(adapter);
    }
}
