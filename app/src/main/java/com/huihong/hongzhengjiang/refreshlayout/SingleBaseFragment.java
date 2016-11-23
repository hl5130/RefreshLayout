package com.huihong.hongzhengjiang.refreshlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/11/23.
 */
public abstract class SingleBaseFragment extends Fragment {

    protected abstract int getLayoutResID();
    protected abstract void onCreate_operate();
    protected abstract void onCreateView_operate(View view);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreate_operate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getLayoutResID(), container, false);
        onCreateView_operate(view);
        return view;
    }
}
