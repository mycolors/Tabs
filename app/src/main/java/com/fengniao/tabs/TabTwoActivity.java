package com.fengniao.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fengniao.tabs.fragment.FourFragment;
import com.fengniao.tabs.fragment.OneFragment;
import com.fengniao.tabs.fragment.ThreeFragment;
import com.fengniao.tabs.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabTwoActivity extends AppCompatActivity {
    List<Fragment> mFragments;

    //当前选中的fragment
    Fragment currentFragment;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    FourFragment fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_two);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.linear_tab_one)
    public void selectOne(View view) {
        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(),
                oneFragment);

    }

    @OnClick(R.id.linear_tab_two)
    public void selectTwo(View view) {
        if (twoFragment == null) {
            twoFragment = new TwoFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(),
                twoFragment);
    }

    @OnClick(R.id.linear_tab_three)
    public void selectThree(View view) {
        if (threeFragment == null) {
            threeFragment = new ThreeFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(),
                threeFragment);
    }

    @OnClick(R.id.linear_tab_fout)
    public void selectFour(View view) {
        if (fourFragment == null) {
            fourFragment = new FourFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(),
                fourFragment);
    }

    //初始化fragment
    public void initData() {
        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }

        if (!oneFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, oneFragment).show(oneFragment)
                    .commit();
            currentFragment = oneFragment;
        }
    }


    //添加或显示fragment
    public void addOrShowFragment(FragmentTransaction transaction, Fragment fragment) {
        if (currentFragment == fragment) return;
        if (fragment.isAdded())
            //如果fragment已经添加到fragment管理器中就显示出来
            transaction.hide(currentFragment).show(fragment).commit();
        else
            //如果未添加，就添加到fragment管理器中
            transaction.hide(currentFragment).add(R.id.content, fragment).show(fragment).commit();
        //设置视图不可见
        //这里通过调用uservisiblehint可以进行懒加载，当然在onHiddenChange()回调中也可以进行懒加载
        currentFragment.setUserVisibleHint(false);
        currentFragment = fragment;
        //设置视图可见
        currentFragment.setUserVisibleHint(true);
    }
}
