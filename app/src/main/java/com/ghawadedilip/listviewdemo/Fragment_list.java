package com.ghawadedilip.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Dilip on 18-Nov-17.
 */

public class Fragment_list extends Fragment  {
  ListView listView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_list,container,false);

    listView = (ListView)v.findViewById(R.id.list_item);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
      android.R.layout.simple_list_item_1,
      getResources().getStringArray(R.array.fruits));

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /*Intent intent = new Intent(getActivity(),
        Fragment_list.class);
        intent.putExtra("FruitsName",
        listView.getItemAtPosition(i).toString());
        startActivity(intent);*/
        Bundle bundle  = new Bundle();
        bundle.putString("fruitsName",listView.getItemAtPosition(i).toString());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment_Result fragment_result = new Fragment_Result();
        fragment_result.setArguments(bundle);
        fragmentTransaction.replace(R.id.main_container,fragment_result);
        fragmentTransaction.commit();
      }
    });
    listView.setAdapter(adapter);


    return v;
  }
  public void replacementFragment(Fragment fragment,boolean addToBack)
  {
    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.main_container,fragment,fragment.getClass().getName());
    if (addToBack)
      ft.commit();
  }
}
