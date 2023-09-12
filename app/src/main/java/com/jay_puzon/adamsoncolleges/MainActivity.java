package com.jay_puzon.adamsoncolleges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer[] ICONS = {
        R.drawable.cc,
            R.drawable.cor,
            R.drawable.jer,
            R.drawable.kal,
            R.drawable.lel,
            R.drawable.nun,
            R.drawable.ohgi,
            R.drawable.shir,
            R.drawable.suz,
            R.drawable.zel
    };
    Integer[] IMAGES = {
            R.drawable.cct,
            R.drawable.cort,
            R.drawable.jert,
            R.drawable.kalt,
            R.drawable.lelt,
            R.drawable.nunt,
            R.drawable.ohgit,
            R.drawable.shirt,
            R.drawable.suzt,
            R.drawable.zelt
    };
    String[] TITLES = {
            "C.C",
            "Cornelia li Britannia",
            "Jeremiah Gottwald",
            "Cornelia li Britannia",
            "Lelouch Lamperouge",
            "Nunnally",
            "Kaname Ohgi",
            "Shirley Fenette",
            "Suzaku Kururugi",
            "Scneizel El Britannia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView Items = findViewById(R.id.list_view);
        CustomAdapter adapter = new CustomAdapter();
        Items.setAdapter(adapter);
        Items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent CallDetail = new Intent(".CollegeDetail");
                CallDetail.putExtra("TITLE", TITLES[i]);
                CallDetail.putExtra("IMAGE", IMAGES[i]);
                CallDetail.putExtra("ICON", ICONS[i]);
                startActivity(CallDetail);
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ICONS.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.item_list_layout, null);
            TextView dispTitle = view.findViewById(R.id.DispTitle);
            ImageView dispImage = view.findViewById(R.id.DispImg);
            dispTitle.setText(TITLES[i]);
            dispImage.setImageResource(ICONS[i]);
            return view;
        }
    }
}