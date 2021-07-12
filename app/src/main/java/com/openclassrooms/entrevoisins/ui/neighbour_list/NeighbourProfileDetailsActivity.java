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
import com.openclassrooms.entrevoisins.model.FavoriteNeighbour;

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

    List<FavoriteNeighbour> favList;

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

        long idNieghbour = intent.getLongExtra("id", 0);


        String profileImage = intent.getStringExtra("avatar");
        Glide.with(this).asBitmap().load(profileImage).into(profileAvatar);

        String profileNameOnImage = intent.getStringExtra("profileNameOnImage");
        imageViewName.setText(profileNameOnImage);

        String profileName = intent.getStringExtra("profileName");
        cardViewProfileName.setText(profileName);

        String profileAddress = intent.getStringExtra("profileAddress");
        cardViewProfileAddress.setText(profileAddress);

        String profileNumber = intent.getStringExtra("profileNumber");
        cardViewProfileNumber.setText(profileNumber);

        String profileMail = "www.facebook.fr/" + intent.getStringExtra("profileInternet");
        cardViewProfileMail.setText(profileMail);

        String profileAboutMe = intent.getStringExtra("profileAboutMe");
        cardViewProfileAboutMe.setText(profileAboutMe);

        //Favorites Button
        fab = findViewById(R.id.floatingActionButton);

        //ArrayAdapter<FavoriteNeighbour> adapter = new ArrayAdapter<FavoriteNeighbour>(getApplicationContext(), android.R.layout.simple_spinner_item, favList);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag) {

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_star_yellow_empty_24dp));

                    flag = false;


                }
                else if(!flag) {

                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            R.drawable.ic_star_yellow_full_24dp));

                    flag = true;

                    favList = new ArrayList<>();
                    favList.add(new FavoriteNeighbour(idNieghbour, profileName, profileImage));
                    //favList.add(new FavoriteNeighbour(v);
                    favList.add(new FavoriteNeighbour(1, "Julia", profileImage));

                    //notifyDataSetChanged();

                }
            }
        });

    }
}