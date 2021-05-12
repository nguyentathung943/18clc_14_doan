package com.example.image_management;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SlideShow extends AppCompatActivity {
    SliderView sliderView;
    ImageView back;
    SliderAdapter slideAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_show);
        ArrayList<String> list = SlideShowData.list;
        List<SlideShowItem> items = new ArrayList<>();
        for(int i = 0;i < list.size();i++){
            try{
                items.add(new SlideShowItem(Drawable.createFromPath(list.get(i)), new File(list.get(i)).getName(), (i + 1) +"/"+ list.size()));
            }
            catch (Exception e){
                System.out.println("DRAW ERROR" + e);
            }
        }
        System.out.println("Slideshow size:"  + list.size());
        sliderView = findViewById(R.id.slide_show);
        back = findViewById(R.id.btn_back_slide_show);
        slideAdapter = new SliderAdapter(getApplicationContext(),items);
        sliderView.setSliderAdapter(slideAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }
    public void backSlideShow(View view){
        finish();
    }

}