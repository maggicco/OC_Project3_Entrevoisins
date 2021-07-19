package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NeighbourProfileDetailsActivity extends AppCompatActivity {

    ImageView profileAvatar;
    TextView imageViewName;
    TextView cardViewProfileName;
    TextView cardViewProfileAddress;
    TextView cardViewProfileNumber;
    TextView cardViewProfileMail;
    TextView cardViewProfileAboutMe;
    FloatingActionButton fab;
    private boolean flag = true;
    NeighbourApiService mApiService = DI.getNeighbourApiService();
    private Neighbour mNeighbour;
    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    Neighbour currentNeighbour;

    List<Neighbour> favList =  new ArrayList<>();
    private boolean favListStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile_details);
        //Back Home arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        profileAvatar = findViewById(R.id.imageViewProfileAvatar);
        imageViewName = findViewById(R.id.textViewNeighbourName);
        cardViewProfileName = findViewById(R.id.cardViewProfileName);
        cardViewProfileAddress = findViewById(R.id.cardViewProfileAddress);
        cardViewProfileNumber = findViewById(R.id.cardViewProfileNumber);
        cardViewProfileMail = findViewById(R.id.cardViewProfileMail);
        cardViewProfileAboutMe = findViewById(R.id.cardViewProfileAboutMe);

        Intent intent = getIntent();
        currentNeighbour = (Neighbour) intent.getSerializableExtra("TONEIGHBOURPROFILE");

        //for (int i = 0; i< mApiService.getNeighbours().size(); i++) {
            // Get current neighbour // Comparer les ids
        //}

        // setting data from intent
        Glide.with(this).asBitmap().load(currentNeighbour.getAvatarUrl()).into(profileAvatar);
        imageViewName.setText(currentNeighbour.getName());
        cardViewProfileName.setText(currentNeighbour.getName());
        cardViewProfileAddress.setText(currentNeighbour.getAddress());
        cardViewProfileNumber.setText(currentNeighbour.getPhoneNumber());
        String profileMail = "www.facebook.fr/" + intent.getStringExtra("profileInternet");
        cardViewProfileMail.setText("www.facebook.fr/" + currentNeighbour.getName());
        cardViewProfileAboutMe.setText(currentNeighbour.getAboutMe());

//        //Favorites Button
        fab = findViewById(R.id.floatingActionButton);
        if (mNeighbour.isFavoriteNeighbour())
            fab.setImageResource(R.drawable.ic_star_yellow_full_24dp);
        else
            fab.setImageResource(R.drawable.ic_star_yellow_empty_24dp);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DummyNeighbourApiService().favoriteStatus(mNeighbour.getId());
                mNeighbour.setFavoriteNeighbour(!mNeighbour.isFavoriteNeighbour());
                // set neighbour favorite
                //currentNeighbour.setFavoriteNeighbour(currentNeighbour.isFavoriteNeighbour());
                //mApiService.set(currentNeighbour);

                if(!flag) {
                    //                // test si currentNeighbour est déja dans la list
                    //trying to add fav neighbour
//                    for (int i = 0; i < neighbours.size(); i++) {
//                        if(neighbours.get(i).isFavoriteNeighbour()) {
//                            favList.add(neighbours.get(i));
//                        }
//                    }
                    mApiService.addFavorite(currentNeighbour);
                    //favList.add(currentNeighbour);
                    //favListStatus = true;
                    //this.notifyDataSetChanged();
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_star_yellow_full_24dp));

                    flag = true;
                }
                else if (flag) {
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_star_yellow_empty_24dp));

                    flag = false;
                    favListStatus = false;
                }
            }
        });

    }
}