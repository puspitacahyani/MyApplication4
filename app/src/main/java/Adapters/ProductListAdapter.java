package Adapters;


import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import entities.*;
import android.content.*;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.myapplication.R;

import java.util.*;

public class ProductListAdapter extends ArrayAdapter<Product>{

    private Context context;
    private List<Product> products;

    public ProductListAdapter(Context context, List<Product> products){
        super(context, R.layout.product_list_layout, products);
        this.context=context;
        this.products=products;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView , ViewGroup parent){
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.product_list_layout, parent ,false);

        Product product = products.get(position);
        ImageView imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
        imageViewPhoto.setImageResource(product.getPhoto());
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        textViewName.setText(product.getName());

        return view;

    }



}
