package movil.unicauca.peliculas.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import movil.unicauca.peliculas.R;


public class CalificationFragment extends Fragment{ //implements AdapterView.OnItemSelectedListener {

    public CalificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calification, container, false);
    }
}
