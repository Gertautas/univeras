package com.example.gertautasm.lab5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AntrasFragment extends Fragment {


    public AntrasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_antras, container, false);
        // Inflate the layout for this fragment
        String info2 = this.getArguments().getString("meniu");
        TextView textView = (TextView) view2.findViewById(R.id.tekstas);
        textView.setText(info2);



        return view2;
    }

}
