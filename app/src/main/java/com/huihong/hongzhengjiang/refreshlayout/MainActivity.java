package com.huihong.hongzhengjiang.refreshlayout;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/11/23.
 */
public class MainActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ListViewFragment();
//        return new GridViewFragment();

    }
}
