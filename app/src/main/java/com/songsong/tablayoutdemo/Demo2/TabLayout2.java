package com.songsong.tablayoutdemo.Demo2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.songsong.tablayoutdemo.R;
import com.songsong.tablayoutdemo.adapter.MyFragmentPagerAdapter;

public class TabLayout2 extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout2);
        //toolbar
        mToolbar = findViewById(R.id.toorbar2_id);
        setSupportActionBar(mToolbar);
        //滑动菜单
        mDrawerLayout = findViewById(R.id.dra_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_home);
        }
        getSupportActionBar().setHomeButtonEnabled(true);

        //菜单栏页面
        NavigationView navView = findViewById(R.id.nav_view);
        //默认指定
//        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_call:
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_task:
                        Toast.makeText(getApplicationContext(), "测试nav", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


        mTabLayout = findViewById(R.id.tab2_id);
        mViewPager = findViewById(R.id.vp2_id);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager.setAdapter(myFragmentPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，相互影响，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
