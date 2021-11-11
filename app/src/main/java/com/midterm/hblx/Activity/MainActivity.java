package com.midterm.hblx.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.midterm.hblx.Model.Photo;
import com.midterm.hblx.ViewModel.ZoomOutPageTransformer;
import com.midterm.hblx.ViewModel.photoViewPagerAdapter;
import android.os.Bundle;
import android.os.Handler;

import me.relex.circleindicator.CircleIndicator3;

import com.midterm.hblx.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private List<Photo> mListPhoto;
    private CircleIndicator3 mCircleIndicator3;

    private Handler mHandler = new Handler();
    private Runnable mRunable = new Runnable() {
        @Override
        public void run() {
            if(mViewPager2.getCurrentItem() == mListPhoto.size() -1){
                mViewPager2.setCurrentItem(0);
            }
            else{
                mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() + 1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager2 = findViewById(R.id.view_pager_2);
        mCircleIndicator3 = findViewById(R.id.cicrle_indicator);

        mListPhoto = getListPhoto();
        photoViewPagerAdapter adapter = new photoViewPagerAdapter(mListPhoto);
        mViewPager2.setAdapter(adapter);

        mCircleIndicator3.setViewPager(mViewPager2);

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunable);
                mHandler.postDelayed(mRunable, 3000);
            }
        });

        mViewPager2.setPageTransformer(new ZoomOutPageTransformer());

    }



    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.image1));
        list.add(new Photo(R.drawable.image2));
        list.add(new Photo(R.drawable.image3));
        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunable, 3000);
    }
}


