package com.example.a1123;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class DiscoverActivity extends AppCompatActivity {

    private ViewPager2 imageSlider;
    private Handler sliderHandler = new Handler();
    private int currentPage = 0;

    private final List<Integer> sliderImages = Arrays.asList(
            R.drawable.ic_discover1, R.drawable.ic_discover2, R.drawable.ic_discover3
    );

    private final List<Integer> gridImages = Arrays.asList(
            R.drawable.ic_discover1, R.drawable.ic_discover2,
            R.drawable.ic_discover3, R.drawable.ic_dicover4
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        imageSlider = findViewById(R.id.imageSlider);
        RecyclerView imageGrid = findViewById(R.id.imageGrid);
        Button btnSeeMore = findViewById(R.id.btnSeeMore);

        // Set up slider
        imageSlider.setAdapter(new ImageSliderAdapter(sliderImages));
        autoScrollSlider();

        // Set up grid
        imageGrid.setLayoutManager(new GridLayoutManager(this, 2));
        imageGrid.setAdapter(new ImageGridAdapter(gridImages));

        // See More
        btnSeeMore.setOnClickListener(v -> {
            // Optional: Load more items
        });

        // ✅ Set up bottom nav (INSIDE onCreate)
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_search) {
                startActivity(new Intent(DiscoverActivity.this, SearchActivity.class));
                return true;
            } else if (itemId == R.id.nav_discover) {
                // Stay here
                return true;
            } else if (itemId == R.id.nav_profile) {
                // TODO: Add ProfileActivity
                return true;
            }

            return false;
        });


    }

    private void autoScrollSlider() {
        sliderHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentPage = (currentPage + 1) % sliderImages.size();
                imageSlider.setCurrentItem(currentPage, true);
                sliderHandler.postDelayed(this, 3000);
            }
        }, 3000);
    }
}
