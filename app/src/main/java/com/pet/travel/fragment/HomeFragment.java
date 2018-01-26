package com.pet.travel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pet.travel.R;
import com.pet.travel.adapter.CircleAdapter;
import com.pet.travel.bean.CircleBean;
import com.pet.travel.view.home.HomeAiMeiZhiXinView;
import com.pet.travel.view.home.HomeAiXianGuangView;
import com.pet.travel.view.home.HomeBuTiaoShiView;
import com.pet.travel.view.home.HomeHeaderPagerView;
import com.pet.travel.view.home.HomeJiongWangTuiJianView;
import com.pet.travel.view.home.HomeTabView;
import com.pet.travel.view.home.HomeYiQiWanView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private CircleAdapter adapter;

    private HomeHeaderPagerView homeHeaderPagerView;
    private HomeTabView homeTabView;
    private HomeAiXianGuangView homeAiXianGuangView;
    private HomeBuTiaoShiView homeBuTiaoShiView;
    private HomeYiQiWanView homeYiQiWanView;
    private HomeAiMeiZhiXinView homeAiMeiZhiXinView;
    private HomeJiongWangTuiJianView homeJiongWangTuiJianView;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.i("HomeFragment", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        Log.i("HomeFragment", "onCreateView");
        return view;
    }


    private void initView(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        // 设置颜色属性的时候一定要注意是引用了资源文件还是直接设置16进制的颜色，因为都是int值容易搞混
        // 设置下拉进度的背景颜色，默认就是白色的
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_purple, android.R.color.holo_green_light, R.color.colorAccent, android.R.color.holo_blue_light);
        // 下拉时触发SwipeRefreshLayout的下拉动画，动画完毕之后就会回调这个方法
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(1, 2000);
            }
        });
        listView = (ListView) view.findViewById(R.id.listview);
        listView.addHeaderView(homeHeaderPagerView = new HomeHeaderPagerView(getActivity()));
        listView.addHeaderView(homeTabView = new HomeTabView(getActivity()));

        listView.addHeaderView(homeAiXianGuangView = new HomeAiXianGuangView(getActivity()));
        listView.addHeaderView(homeBuTiaoShiView = new HomeBuTiaoShiView(getActivity()));
        listView.addHeaderView(homeYiQiWanView = new HomeYiQiWanView(getActivity()));
        listView.addHeaderView(homeAiMeiZhiXinView = new HomeAiMeiZhiXinView(getActivity()));
        listView.addHeaderView(homeJiongWangTuiJianView = new HomeJiongWangTuiJianView(getActivity()));

        adapter = new CircleAdapter(getActivity());
        listView.setAdapter(adapter);
    }

    public void loadData() {
        List<CircleBean> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add(null);
        }
        adapter.setData(datas);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    swipeRefreshLayout.setRefreshing(false);
                    break;
            }
        }
    };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("HomeFragment", "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("HomeFragment", "onDetach");
    }
}
