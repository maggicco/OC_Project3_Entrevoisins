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

import java.util.Objects;

public class NeighbourProfileDetailsActivity extends AppCompatActivity {

    ImageView profileAvatar;
    TextView imageViewName;
    TextView cardViewProfileName;
    TextView cardViewProfileAdress;
    TextView cardViewProfileNumber;
    TextView cardViewProfileMail;
    TextView cardViewProfileAboutMe;
    FloatingActionButton fab;
    private boolean fabClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile_details);
        //Back Home arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        profileAvatar = findViewById(R.id.imageViewProfileAvatar);
        imageViewName = findViewById(R.id.textViewNeighbourName);
        cardViewProfileName = findViewById(R.id.cardViewProfileName);
        cardViewProfileAdress = findViewById(R.id.cardViewProfileAddress);
        cardViewProfileNumber = findViewById(R.id.cardViewProfileNumber);
        cardViewProfileMail = findViewById(R.id.cardViewProfileMail);
        cardViewProfileAboutMe = findViewById(R.id.cardViewProfileAboutMe);

        Intent intent = getIntent();

        String profileImage = intent.getStringExtra("avatar");
        Glide.with(this).asBitmap().load(profileImage).into(profileAvatar);

        String profileNameOnImage = intent.getStringExtra("profileNameOnImage");
        imageViewName.setText(profileNameOnImage);

        String profileName = intent.getStringExtra("profileName");
        cardViewProfileName.setText(profileName);

        String profileAddress = intent.getStringExtra("profileAddress");
        cardViewProfileAdress.setText(profileAddress);

        String profileNumber = intent.getStringExtra("profileNumber");
        cardViewProfileNumber.setText(profileNumber);

        String profileMail = "www.facebook.fr/" + intent.getStringExtra("profileInternet");
        cardViewProfileMail.setText(profileMail);

        String profileAboutMe = intent.getStringExtra("profileAboutMe");
        cardViewProfileAboutMe.setText(profileAboutMe);

        //Favorites Button
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.ic_star_full_foreground));
//                fabClicked = true;
//                if (fabClicked) {
//
//                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
//                            R.drawable.ic_star_empty_foreground));
//                    fabClicked = false;
//
//                }else if (!fabClicked) {
//                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
//                            R.drawable.ic_star_full_foreground));
//                    fabClicked = true;
//                }

            }
        });

    }
}