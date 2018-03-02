package id.baperan.baper.Fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.baperan.baper.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    Button btnPass;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        btnPass = (Button) v.findViewById(R.id.btnPass);
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(btnPass, "Succes!", Snackbar.LENGTH_SHORT).show();
            }
        });

        return v;
    }



}
