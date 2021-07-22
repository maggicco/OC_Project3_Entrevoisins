package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
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
    private Neighbour mNeighbour;

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
        mNeighbour = (Neighbour) intent.getSerializableExtra("TONEIGHBOURPROFILE");

        // setting data from intent
        Glide.with(this).asBitmap().load(mNeighbour.getAvatarUrl()).into(profileAvatar);
        imageViewName.setText(mNeighbour.getName());
        cardViewProfileName.setText(mNeighbour.getName());
        cardViewProfileAddress.setText(mNeighbour.getAddress());
        cardViewProfileNumber.setText(mNeighbour.getPhoneNumber());
        cardViewProfileMail.setText("www.facebook.fr/" + mNeighbour.getName());
        cardViewProfileAboutMe.setText(mNeighbour.getAboutMe());

        //Favorites Button
        fab = findViewById(R.id.floatingActionButton);

        if(mNeighbour.isFavoriteNeighbour()) {

            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                    R.drawable.ic_star_yellow_full_24dp));
        }
        else  {

            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                    R.drawable.ic_star_yellow_empty_24dp));
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DummyNeighbourApiService().favoriteStatus(mNeighbour.getId());
                mNeighbour.setFavoriteNeighbour(!mNeighbour.isFavoriteNeighbour());

                if(mNeighbour.isFavoriteNeighbour()) {

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_star_yellow_full_24dp));
                }
                else  {
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_star_yellow_empty_24dp));
                }
            }
        });

    }
}