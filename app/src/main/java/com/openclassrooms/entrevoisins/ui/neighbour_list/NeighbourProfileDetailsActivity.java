package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.Objects;

public class NeighbourProfileDetailsActivity extends AppCompatActivity {

    ImageView profileAvatar;
    private Neighbour mNeighbour;
    TextView imageViewName;
    TextView cardViewProfileName;
    TextView cardViewProfileAdress;
    TextView cardViewProfileNumber;
    TextView cardViewProfileMail;
    TextView cardViewProfileAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile_details);
        //Back Home arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        profileAvatar = findViewById(R.id.imageViewProfileAvatar);
        imageViewName = findViewById(R.id.textViewNeighbourName);
        cardViewProfileName = findViewById(R.id.cardViewProfileName);
        cardViewProfileAdress = findViewById(R.id.cardViewProfileAdress);
        cardViewProfileNumber = findViewById(R.id.cardViewProfileNumber);
        cardViewProfileMail = findViewById(R.id.cardViewProfileMail);
        cardViewProfileAboutMe = findViewById(R.id.cardViewProfileAboutMe);

        Intent intent = getIntent();

        //String profileImage = intent.getStringExtra("profileImage");
        //profileAvatar.setImageResource(profileImage);

        String profileNameOnImage = intent.getStringExtra("profileNameOnImage");
        imageViewName.setText(profileNameOnImage);

        String profileName = intent.getStringExtra("profileName");
        cardViewProfileName.setText(profileName);

        String profileAddress = intent.getStringExtra("profileAddress");
        cardViewProfileAdress.setText(profileAddress);

        String profileNumber = intent.getStringExtra("profileNumber");
        cardViewProfileNumber.setText(profileNumber);

//        String profileMail = intent.getStringExtra("profileInternet");
//        cardViewProfileMail.setText(profileMail);

        String profileAboutMe = intent.getStringExtra("profileAboutMe");
        cardViewProfileAboutMe.setText(profileAboutMe);




        //Toast.makeText(this, "Name  - " + mNeighbour.getName(), Toast.LENGTH_SHORT).show();

    }
}