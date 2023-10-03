package com.jay_puzon.adamsoncolleges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CollegeDetail extends AppCompatActivity {

                                                                        ImageView BG;
    TextView Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_detail);

        BG = findViewById(R.id.bg);
        Title = findViewById(R.id.title);

        Intent intent = getIntent();
        int IMAGE = intent.getIntExtra("IMAGE", 0);
        String TITLE = intent.getStringExtra("TITLE");
        int ICON = intent.getIntExtra("ICON", 0);
        MediaPlayer MP = MediaPlayer.create(this, intent.getIntExtra("AUDIO", 0));
        MP.start();

        BG.setImageResource(IMAGE);
        Title.setText(TITLE);
    }
}