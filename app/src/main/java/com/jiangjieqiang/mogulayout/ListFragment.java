package com.jiangjieqiang.mogulayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangjieqiang on 16/1/18.
 */
public class ListFragment extends Fragment{

    private static final int LIST_NUM = 20;

    private View view;
    @ViewInject(R.id.id_listview)
    private ListView listView;

    private int type;
    private List<String> stringList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            type = bundle.getInt("type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment,null);
        ViewUtils.inject(this,view);

        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null){
            parent.removeView(view);
        }
        initData();
        initListView();
        return view;
    }

    private void initData() {
        stringList.clear();
        for (int i = 0;i < LIST_NUM;i++){
            stringList.add("列表"+type+"："+i);
        }
    }

    private void initListView() {
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,stringList));
    }
}
