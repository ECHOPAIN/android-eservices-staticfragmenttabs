package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment implements View.OnClickListener{


    @Override
    public void onClick(View view) {
        TextView counter_textview = (TextView)  view.findViewById(R.id.counter_textview);
        //do something
    }

    public static final String TAB_NAME = "ADD TO COUNTER";

    public FragmentOne() {
        //Constructeur forcement vide (pas d'argument pas de comportement
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        //com.google.android.material.tabs.TabLayout t = (com.google.android.material.tabs.TabLayout) view.findViewById(R.id.tablayout);
        Button button = (Button) view.findViewById(R.id.button_increment);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way


}
