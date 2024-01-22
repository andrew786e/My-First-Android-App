package com.example.myfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    TextView showCountTextView ;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View firstFragmentLayout = inflater.inflate(R.layout.fragment_first, container, false);
        showCountTextView = firstFragmentLayout.findViewById(R.id.first_fragment);
        return firstFragmentLayout ;
    }

    @Override
    public  void onViewCreated(@NonNull View view, Bundle savedInstanceState){
//        Inflate the layout for this fragment
        super.onViewCreated(view , savedInstanceState);

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Hello Toast!", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("On Click Test" ,"Button Clicked") ;
                countMe();
            }
        });

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(showCountTextView.getText().toString()) ;
                FirstFragmentDirections.ActionFirstFragment2ToSecondFragment4 action = FirstFragmentDirections.actionFirstFragment2ToSecondFragment4(currentCount) ;
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }
        });
    }

    private void countMe(){
        String countString = showCountTextView.getText().toString() ;
        Integer count = Integer.parseInt(countString) ;
        count++ ;
        showCountTextView.setText(count.toString());
    }

}