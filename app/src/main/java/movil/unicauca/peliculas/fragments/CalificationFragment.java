package movil.unicauca.peliculas.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import movil.unicauca.peliculas.MainActivity;
import movil.unicauca.peliculas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalificationFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner moviesestrenos;
    String moviesestrenosData[];
    RatingBar ratingBar;
    Button button;


    public CalificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        moviesestrenos = (Spinner) getView().findViewById(R.id.moviesestrenos);
        ratingBar = (RatingBar) getView().findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getActivity(), "Start" + rating, Toast.LENGTH_SHORT).show();
            }
        });

        button = (Button) getView().findViewById(R.id.btnenviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Tus Comentarios fueron Enviados", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        moviesestrenos.setOnItemSelectedListener(this);
        moviesestrenosData=getResources().getStringArray(R.array.moviesestrenos);

        return inflater.inflate(R.layout.fragment_calification, container, false);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
