package com.example.emart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gridview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataRVAdapter extends RecyclerView.Adapter<DataRVAdapter.ViewHolder>{
    private ArrayList<DataModal> dataModalArrayList_RV;
    private Context context;

    // constructor class for our Adapter
    public DataRVAdapter(ArrayList<DataModal> dataModalArrayList, Context context) {
        this.dataModalArrayList_RV= dataModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new DataRVAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataRVAdapter.ViewHolder holder, int position) {
        // setting data to our views in Recycler view items.
        DataModal modal = dataModalArrayList_RV.get(position);
        holder.courseNameTV.setText(modal.getName());

        // we are using Picasso to load images
        // from URL inside our image view.
        Picasso.get().load(modal.getImgUrl()).into(holder.courseIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
//                we can show the toast or pass to another activity using this
                //Toast.makeText(getContext(), "Item clicked is : " + dataModal.getName(), Toast.LENGTH_SHORT).show();
                //This can be used to start Activity
                Intent i = new Intent(context, ProductActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return dataModalArrayList_RV.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our
        // views of recycler items.
        private TextView courseNameTV;
        private ImageView courseIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing the views of recycler views.
            courseNameTV = itemView.findViewById(R.id.idTVtext);
            courseIV = itemView.findViewById(R.id.idIVimage);
        }
    }
}

