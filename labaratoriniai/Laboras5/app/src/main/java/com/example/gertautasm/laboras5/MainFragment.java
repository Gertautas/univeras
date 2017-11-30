package com.example.gertautasm.laboras5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            String[] menu = {"Tekstas su A raidemis", "Be ieskomo simbolio","Cia yra ieskomas simbolis","Nieko nebus","Rasi ko ieskai"};
        // Inflate the layout for this fragment
        Bundle bundle = new Bundle();
        bundle.putString("meniu", String.valueOf(menu));
        AntrasFragment info = new AntrasFragment();
        info.setArguments(bundle);

        ListView listView =(ListView) view.findViewById(R.id.listas);
        ArrayAdapter<String> listviewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,menu);
        listView.setAdapter(listviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){

                }else if(i == 1){

                }else if(i == 2){

                }else if(i == 3){

                }else if( i == 4){

                }
            }
        });

        return view;
    }

}
