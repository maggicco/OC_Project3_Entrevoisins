package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.ItemClicked;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.greenrobot.eventbus.EventBus.TAG;

public class MyNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;
    ItemClicked activity;

    public MyNeighbourRecyclerViewAdapter( List<Neighbour> items) {
        this.mNeighbours = items;

    }
    public MyNeighbourRecyclerViewAdapter(Context context, List<Neighbour> items) {
        this.mNeighbours = items;
        activity = (ItemClicked) context;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_neighbour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());

        Glide.with(holder.mNeighbourAvatar.getContext()).load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext()
                        , NeighbourProfileDetailsActivity.class);

                intent.putExtra("TONEIGHBOURPROFILE", (Serializable) neighbour);
                v.getContext().startActivity(intent);

            }
        });

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }



}
