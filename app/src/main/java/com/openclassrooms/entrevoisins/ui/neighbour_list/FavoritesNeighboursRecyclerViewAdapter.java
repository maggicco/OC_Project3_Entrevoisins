package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.ItemClicked;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class FavoritesNeighboursRecyclerViewAdapter extends RecyclerView.Adapter<FavoritesNeighboursRecyclerViewAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Neighbour> mData;

    public FavoritesNeighboursRecyclerViewAdapter(ArrayList<Neighbour> mData) {
    }

    public FavoritesNeighboursRecyclerViewAdapter(Context mContext, ArrayList<Neighbour> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public FavoritesNeighboursRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_neighbour, viewGroup, false);
       ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(FavoritesNeighboursRecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Neighbour favNeighbour = mData.get(position);
        Glide.with(holder.nImg.getContext()).load(favNeighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.nImg);
        holder.nName.setText(mData.get(position).getName());


        holder.nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mData.remove(position);
//                notifyDataSetChanged();
                //EventBus.getDefault().post(new DeleteFavoriteNeighbourEvent(favNeighbour));
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView nImg;
        private TextView nName;
        private ImageButton nButton;

        public ViewHolder(View itemView) {
            super(itemView);

            nImg = (ImageView) itemView.findViewById(R.id.item_list_avatar);
            nName = (TextView) itemView.findViewById(R.id.item_list_name);
            nButton = (ImageButton) itemView.findViewById(R.id.item_list_delete_button);

        }
    }

//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
}
