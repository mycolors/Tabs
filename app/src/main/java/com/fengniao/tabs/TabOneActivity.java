package com.fengniao.tabs;

import android.renderscript.Matrix2f;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fengniao.tabs.fragment.FourFragment;
import com.fengniao.tabs.fragment.OneFragment;
import com.fengniao.tabs.fragment.ThreeFragment;
import com.fengniao.tabs.fragment.TwoFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * viewPager+fragment实现tab
 */
public class TabOneActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.text_tab_one)
    TextView textTabOne;
    @BindView(R.id.text_tab_two)
    TextView textTabTwo;
    @BindView(R.id.text_tab_three)
    TextView textTabThree;
    @BindView(R.id.text_tab_four)
    TextView textTabFour;
    List<Fragment> mFragments;

    //当前选中的位置
    int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_one);
        ButterKnife.bind(this);
        initData();
        initTabs();
        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(myViewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectTab(position);
                Log.i("mycolors", position + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.linear_tab_one)
    public void selectOne(View view) {
        viewPager.setCurrentItem(0);
    }

    @OnClick(R.id.linear_tab_two)
    public void selectTwo(View view) {
        viewPager.setCurrentItem(1);
    }

    @OnClick(R.id.linear_tab_three)
    public void selectThree(View view) {
        viewPager.setCurrentItem(2);
    }

    @OnClick(R.id.linear_tab_three)
    public void selectFour(View view) {
        viewPager.setCurrentItem(3);
    }

    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new OneFragment());
        mFragments.add(new TwoFragment());
        mFragments.add(new ThreeFragment());
        mFragments.add(new FourFragment());
    }

    //初始化tabs
    public void initTabs() {
        textTabOne.setSelected(false);
        textTabTwo.setSelected(false);
        textTabThree.setSelected(false);
        textTabFour.setSelected(false);
        currentItem = 0;
        textTabOne.setSelected(true);
    }


    public void selectTab(int position) {
        if (currentItem == position) return;
        switch (currentItem) {
            case 0:
                textTabOne.setSelected(false);
                break;
            case 1:
                textTabTwo.setSelected(false);
                break;
            case 2:
                textTabThree.setSelected(false);
                break;
            case 3:
                textTabFour.setSelected(false);
                break;
        }
        currentItem = position;
        switch (position) {
            case 0:
                textTabOne.setSelected(true);
                break;
            case 1:
                textTabTwo.setSelected(true);
                break;
            case 2:
                textTabThree.setSelected(true);
                break;
            case 3:
                textTabFour.setSelected(true);
                break;
        }
    }

    class MyViewPager extends FragmentPagerAdapter {
        List<Fragment> list;

        public MyViewPager(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }


        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
