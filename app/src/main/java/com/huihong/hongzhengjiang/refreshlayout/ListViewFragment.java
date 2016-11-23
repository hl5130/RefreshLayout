package com.huihong.hongzhengjiang.refreshlayout;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tt.refreshlayout.pullrefresh.views.PullToRefreshBase;
import com.tt.refreshlayout.pullrefresh.views.PullToRefreshListView;

/**
 * Created by Administrator on 2016/11/23.
 */
public class ListViewFragment extends SingleBaseFragment implements PullToRefreshListView.OnRefreshListener, PullToRefreshListView.OnLastItemVisibleListener {

    private ListView mListView;
    private PullToRefreshListView mPullToRefreshListView;
    private SimulatedData mSimulatedData;
    private Runnable mRunnable;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_list_view;
    }

    @Override
    protected void onCreate_operate() {
        mSimulatedData = new SimulatedData();
    }

    @Override
    protected void onCreateView_operate(View view) {
        mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.list_view_fragment);
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshListView.setOnRefreshListener(this);
        mPullToRefreshListView.setOnLastItemVisibleListener(this);
        mListView = mPullToRefreshListView.getRefreshableView();
        mListView.setAdapter(
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
        if (mPullToRefreshListView.isHeaderShown()) {
            mPullToRefreshListView.postDelayed(mRunnable, 6000);
        } else{
            mPullToRefreshListView.postDelayed(mRunnable, 3000);
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
