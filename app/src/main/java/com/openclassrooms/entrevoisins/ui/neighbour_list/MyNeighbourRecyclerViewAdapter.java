package com.openclassrooms.entrevoisins.ui.neighbour_list;

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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.greenrobot.eventbus.EventBus.TAG;

public class MyNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;
    private Context context;
    ItemClicked activity;
    private ListView listView;
    TextView name;
    TextView nameCardView;
    //private boolean favoritesButton;

    //ListProfileSelected selectedProfile;


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
    public void onBindViewHolder(final ViewHolder holder, int position) {
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
                String avatarUrl = mNeighbours.get(position).getAvatarUrl();
                String profileNameOnImage = mNeighbours.get(position).getName();
                String nameCardView = mNeighbours.get(position).getName();
                String addressCardView = mNeighbours.get(position).getAddress();
                String numberCardView = mNeighbours.get(position).getPhoneNumber();
                String internetCardView = mNeighbours.get(position).getName();
                String aboutMeCardView = mNeighbours.get(position).getAboutMe();
                Log.d(TAG, "onClick: "+ profileNameOnImage + " - " + addressCardView);
                intent.putExtra("avatar", avatarUrl);
                intent.putExtra("profileNameOnImage", profileNameOnImage);
                intent.putExtra("profileName", nameCardView);
                intent.putExtra("profileAddress", addressCardView);
                intent.putExtra("profileNumber", numberCardView);
                intent.putExtra("profileInternet", internetCardView);
                intent.putExtra("profileAboutMe", aboutMeCardView);
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
