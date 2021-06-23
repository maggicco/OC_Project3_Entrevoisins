package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.Objects;

public class NeighbourProfileDetailsActivity extends AppCompatActivity {

    ImageView avatarNeighbour;
    private Neighbour mNeighbour;
    TextView textViewName;
    TextView textViewNeighbourName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile_details);
        //Back Home arrow
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        textViewName = findViewById(R.id.textViewNeighbourName);

        Intent intent = getIntent();
        String nn = intent.getStringExtra("name");
        textViewName.setText(nn);



        //Toast.makeText(this, "Name  - " + mNeighbour.getName(), Toast.LENGTH_SHORT).show();

    }
}