package com.example.administrator.myview.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class VpSimpleFragment extends Fragment {
    private String mTitle;
    public static  final  String BUNDLE_TITLE="title";


    public static VpSimpleFragment newInstance(String title){
        Bundle bundle=new Bundle();
        bundle.putString(BUNDLE_TITLE,title);

        VpSimpleFragment fragment=new VpSimpleFragment();
        fragment.setArguments(bundle);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle=getArguments();

        if(bundle!=null){
            mTitle=bundle.getString(BUNDLE_TITLE);
        }

        TextView tv=new TextView(getActivity());
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);

        return tv;
    }

}
