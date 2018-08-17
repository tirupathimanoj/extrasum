package com.avium.extrasum.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avium.extrasum.Creation_of_group;
import com.avium.extrasum.R;
import com.avium.extrasum.adapters.Adapter_for_gamm_accounts;
import com.avium.extrasum.modelclasses.Gammaccountsmodelclass;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {


    @BindView(R.id.gammaccounts)
    RecyclerView gammaccounts;
    Unbinder unbinder;
    List<Gammaccountsmodelclass> gammaccountsmodelclasses = new ArrayList<>();
    Adapter_for_gamm_accounts mAdapter;
    @BindView(R.id.nested)
    NestedScrollView nested;
    @BindView(R.id.viewall)
    TextView viewall;
    @BindView(R.id.create_group)
    CardView createGroup;

    private int flag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        mAdapter = new Adapter_for_gamm_accounts(gammaccountsmodelclasses, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        gammaccounts.setLayoutManager(mLayoutManager);
        gammaccounts.setFocusable(false);
        nested.requestFocus();
//        gammaccounts.setItemAnimator(new DefaultItemAnimator());
        gammaccounts.setHasFixedSize(false);
        gammaccounts.setNestedScrollingEnabled(false);
        gammaccounts.setAdapter(mAdapter);
        mAdapter.setDisplayCount(3);

        preparedata();
    }

    private void preparedata() {
        Gammaccountsmodelclass
                gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[50], R.drawable.dummy_one, "Rank #1", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummytwo, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummy_one, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummytwo, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummy_one, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummytwo, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummy_one, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummytwo, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);
        gammaccountsmodelclasss = new Gammaccountsmodelclass(new float[100], R.drawable.dummy_one, "Rank #134", "CDK Trading group", "Since 2 yrs 6m", "17", "134%", "gain last 1 week", "$5400", "$5650", "$500");
        gammaccountsmodelclasses.add(gammaccountsmodelclasss);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.create_group, R.id.viewall})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create_group:
                startActivity(new Intent(getActivity(), Creation_of_group.class));
                break;
            case R.id.viewall:

                if (flag == 0) {
                    flag = 1;
                    viewall.setText("show some");
                    mAdapter.setDisplayCount(gammaccountsmodelclasses.size());
                } else {
                    flag = 0;
                    viewall.setText("view all");

                    mAdapter.setDisplayCount(3);
                }
                break;
        }
    }

//    @OnClick(R.id.viewall)
//    public void onViewClicked() {
//        if (flag == 0) {
//            flag = 1;
//            viewall.setText("show some");
//            mAdapter.setDisplayCount(gammaccountsmodelclasses.size());
//        } else {
//            flag = 0;
//            viewall.setText("view all");
//
//            mAdapter.setDisplayCount(3);
//        }
//
//    }
//
//    @OnClick(R.id.create_group)
//    public void onViewClicked() {
//    }
}
