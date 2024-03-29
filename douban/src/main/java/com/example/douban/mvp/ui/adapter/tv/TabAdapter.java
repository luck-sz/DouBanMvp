package com.example.douban.mvp.ui.adapter.tv;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.douban.mvp.ui.fragment.tv.TvChildFragment;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {

    List<TvChildFragment> mList = new ArrayList<>();
    List<String> name = new ArrayList<>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(TvChildFragment fragment, String title) {
        mList.add(fragment);
        name.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return name.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
