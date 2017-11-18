package com.ghawadedilip.listviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dilip on 18-Nov-17.
 */

public class Fragment_Result extends Fragment {
  TextView textView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_result,container,false);

    Bundle bundle = getArguments();
    String value = bundle.getString("fruitsName");

    textView = (TextView)view.findViewById(R.id.text);
    textView.setText(value);


    return view;
  }

}
