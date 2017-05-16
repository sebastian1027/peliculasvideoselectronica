package movil.unicauca.peliculas.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import movil.unicauca.peliculas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RememberFragment extends Fragment {

    Button btnrecordar;



    public RememberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        btnrecordar = (Button) getView().findViewById(R.id.btnrecordar);

        return inflater.inflate(R.layout.fragment_remember, container, false);
    }

}
