package com.huihong.hongzhengjiang.refreshlayout;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.tt.refreshlayout.pullrefresh.views.PullToRefreshBase;
import com.tt.refreshlayout.pullrefresh.views.PullToRefreshGridView;
import com.tt.refreshlayout.pullrefresh.views.PullToRefreshListView;

/**
 * Created by Administrator on 2016/11/23.
 */
public class GridViewFragment extends SingleBaseFragment implements PullToRefreshListView.OnRefreshListener, PullToRefreshListView.OnLastItemVisibleListener {

    private GridView mGridView;
    private PullToRefreshGridView mPullToRefreshGridView;
    private SimulatedData mSimulatedData;
    private Runnable mRunnable;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_grid_view;
    }

    @Override
    protected void onCreate_operate() {
        mSimulatedData = new SimulatedData();
    }

    @Override
    protected void onCreateView_operate(View view) {
        mPullToRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.grid_view_fragment);
        mPullToRefreshGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshGridView.setOnRefreshListener(this);
        mPullToRefreshGridView.setOnLastItemVisibleListener(this);
        mGridView = mPullToRefreshGridView.getRefreshableView();
        mGridView.setVerticalSpacing(20);
        mGridView.setAdapter(
                new ArrayAdapter<>(
                        getActivity(),
                        R.layout.item_text_view,
                        mSimulatedData.getStrings()
                )
        );
    }

    @Override
    public void onRefresh(final PullToRefreshBase refreshView) {
        finishRefresh(refreshView);
        if (mPullToRefreshGridView.isHeaderShown()) {
            mPullToRefreshGridView.postDelayed(mRunnable, 6000);
        } else {
            mPullToRefreshGridView.postDelayed(mRunnable, 3000);
        }
    }

    /**
     * 结束刷新
     *
     * @param refreshView
     */
    private void finishRefresh(final PullToRefreshBase refreshView) {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                refreshView.onRefreshComplete();
            }
        };
    }

    @Override
    public void onLastItemVisible() {

    }
}
