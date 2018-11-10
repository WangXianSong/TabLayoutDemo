package com.songsong.tablayoutdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.songsong.tablayoutdemo.Fragment.Fragment1;
import com.songsong.tablayoutdemo.Fragment.Fragment2;
import com.songsong.tablayoutdemo.Fragment.Fragment3;

/**
 * Created by SongSong on 2018/11/9
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"Tab 1", "Tab 2", "Tab 3"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1)
            return new Fragment2();
        else if (position == 2)
            return new Fragment3();
        return new Fragment1();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}