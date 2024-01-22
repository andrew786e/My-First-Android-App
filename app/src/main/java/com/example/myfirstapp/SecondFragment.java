package com.example.myfirstapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    public SecondFragment() {
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
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public  void onViewCreated(@NonNull View view, Bundle savedInstanceState){
//        Inflate the layout for this fragment
        super.onViewCreated(view , savedInstanceState);
        if(getArguments() != null){
            Integer count = SecondFragmentArgs.fromBundle(getArguments()).getMyArg() ;
            String countText = getString(R.string.SecondFragmentInformation , count) ;
            TextView headerView = view.getRootView().findViewById(R.id.textview_header);
            headerView.setText(countText);
            Random random = new java.util.Random() ;
            Integer randomNumber = 0 ;
            if(count > 0){
                randomNumber = random.nextInt(count + 1) ;
            }
            TextView randomView = view.getRootView().findViewById(R.id.textview_random) ;
            randomView.setText(randomNumber.toString());
        }

        view.findViewById(R.id.previous_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = SecondFragmentDirections.actionSecondFragment4ToFirstFragment2() ;
                NavHostFragment.findNavController(SecondFragment.this).navigate(action);
            }
        });
    }
}