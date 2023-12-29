package com.example.emart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridview.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivityGI extends AppCompatActivity {
    // Urls of our images.
    String url1 = "https://i.pinimg.com/736x/55/2b/96/552b968447629c84a05566bcd7da2815.jpg";
    String url2 = "https://marketplace.canva.com/EAFDx95Zoz8/1/0/1600w/canva-blue-navy-summer-sale-promotional-poster-hg0GMsxeGx8.jpg";
    String url3 = "https://assets.visme.co/templates/banners/thumbnails/i_Fashion-Sale-Poster_full.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smain);

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slidergre);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }
}
