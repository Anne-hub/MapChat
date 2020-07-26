package com.example.mapchat.ui.activity;

import android.view.MenuItem;

import com.example.basic.BaseActivity;
import com.example.mapchat.R;
import com.example.mapchat.ui.fragment.MapFragment;
import com.example.mapchat.ui.adapter.FragmentAdapter;
import com.example.mapchat.ui.fragment.ChatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;

/**
 * 匿名内部类
 */
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.viewPager)
    ViewPager2 viewPager2;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;


    private FragmentAdapter adapter;

    private List<Fragment> fragmentList = new ArrayList<>(4);

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWork() {
        fragmentList.add(new MapFragment());
        fragmentList.add(new ChatFragment());

        fragmentList.add(new MapFragment());
        fragmentList.add(new ChatFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager(), lifecycle, fragmentList);

        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setAdapter(adapter);
        //设置不可滑动
        viewPager2.setUserInputEnabled(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private Lifecycle lifecycle = new Lifecycle() {
        @Override
        public void addObserver(@NonNull LifecycleObserver observer) {

        }

        @Override
        public void removeObserver(@NonNull LifecycleObserver observer) {

        }

        @NonNull
        @Override
        public State getCurrentState() {
            return null;
        }
    };


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_map:
                viewPager2.setCurrentItem(0, false);
                break;
            case R.id.tab_chat:
                viewPager2.setCurrentItem(1, false);
                break;
            case R.id.tab_circle:
                viewPager2.setCurrentItem(2, false);
                break;
            case R.id.tab_mine:
                viewPager2.setCurrentItem(3, false);
                break;
        }
        return true;
    }
}
