package com.example.mapchat.ui.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * @author chenhong
 * @Date 2020/7/2615:39
 * @package com.example.mapchat.ui.adapter
 * @Desciption
 */
public class FragmentAdapter extends FragmentStateAdapter {

    private List<Fragment> data;

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, Lifecycle lifecycle,
                           List<Fragment> data) {
        super(fragmentManager, lifecycle);

        this.data = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return data.get(position);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
