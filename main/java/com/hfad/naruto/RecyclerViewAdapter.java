package com.hfad.naruto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * RecycleViewAdapter.java - Adapter that handles the data from a character that is passed arounnd
 *                          via bluetooth activity. A helpter to BluetoothConnection_Activity.java
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<Character> mData;

    public RecyclerViewAdapter(Context mContext, List<Character> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_character,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

        holder.tv_charater_name.setText(mData.get(position).getName());
        holder.img_character_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Character_Activity.class);

                //passing data to the Character activity
                intent.putExtra("Id",mData.get(position).getId());
                intent.putExtra("Name",mData.get(position).getName());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Country",mData.get(position).getCountry());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                intent.putExtra("Health",mData.get(position).getHealth());
                intent.putExtra("Attack",mData.get(position).getAttack());
                intent.putExtra("Speed",mData.get(position).getSpeed());
                intent.putExtra("Defense",mData.get(position).getDefense());


                //start the activity
                mContext.startActivity(intent);
            }
        });
        //set click listener

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_charater_name;
        ImageView img_character_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            tv_charater_name = (TextView)itemView.findViewById(R.id.character_name_id);
            img_character_thumbnail=(ImageView)itemView.findViewById(R.id.character_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }


}
