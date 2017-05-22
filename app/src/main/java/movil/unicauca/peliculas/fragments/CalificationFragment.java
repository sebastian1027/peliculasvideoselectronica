package movil.unicauca.peliculas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import movil.unicauca.peliculas.MainActivity;
import movil.unicauca.peliculas.R;


public class CalificationFragment extends Fragment { //implements AdapterView.OnItemSelectedListener {

    private Button btnenviar;

    public CalificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calification, container, false);
        btnenviar = (Button) view.findViewById(R.id.btnenviar);
        btnenviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.yourcommentaresends, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
