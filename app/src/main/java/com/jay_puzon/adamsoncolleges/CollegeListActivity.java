package com.jay_puzon.adamsoncolleges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CollegeListActivity extends AppCompatActivity {

    Integer[] ICONS = {
        R.drawable.logo_architecture,
            R.drawable.logo_businessadmin,
            R.drawable.logo_liberalarts,
            R.drawable.logo_engineering,
            R.drawable.logo_law,
            R.drawable.logo_nursing,
            R.drawable.logo_pharmacy,
            R.drawable.logo_sciences,
            R.drawable.logo_gradschool,
            R.drawable.logo_svst
    };
    Integer[] IMAGES = {
            R.drawable.image_archi,
            R.drawable.image_ba,
            R.drawable.image_la,
            R.drawable.image_engineering,
            R.drawable.image_law,
            R.drawable.image_nursing,
            R.drawable.image_pharmacy,
            R.drawable.image_science,
            R.drawable.image_grad,
            R.drawable.image_svst
    };
    String[] TITLES = {
            "College of Architecture",
            "College of Business Administration",
            "College of Education & Liberal Arts",
            "College of Engineering",
            "College of Law",
            "College of Nursing",
            "College of Pharmacy",
            "College of Science",
            "Graduate School",
            "St. Vincent School of Theology"
    };

    Integer[] AUDIOS = {
            R.raw.architecture,
            R.raw.business_administration,
            R.raw.educ_and_liberal_arts,
            R.raw.engineering,
            R.raw.law,
            R.raw.nursing,
            R.raw.pharmacy,
            R.raw.science,
            R.raw.grad_school,
            R.raw.theology
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
                CallDetail.putExtra("AUDIO", AUDIOS[i]);
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