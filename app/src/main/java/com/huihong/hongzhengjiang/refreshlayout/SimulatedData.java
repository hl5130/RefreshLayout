package com.huihong.hongzhengjiang.refreshlayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 * 模拟数据
 */
public class SimulatedData {
    private String mString;
    private List<String> mStrings;

    public SimulatedData() {
        mStrings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mString = "模拟数据"+i;
            mStrings.add(mString);
        }
    }

    public List<String> getStrings() {
        return mStrings;
    }

}
