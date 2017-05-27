package movil.unicauca.peliculas.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import movil.unicauca.peliculas.R;
import movil.unicauca.peliculas.databinding.ActivityRememberBinding;
import movil.unicauca.peliculas.databinding.TemplateRememberBinding;
import movil.unicauca.peliculas.models.Recordar;

/**
 * Created by sebastianl on 26/05/2017.
 */

public class RecordarAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<Recordar> data;

    public RecordarAdapter(LayoutInflater inflater, List<Recordar> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v== null){
            v = inflater.inflate(R.layout.template_remember, parent, false); }

        TemplateRememberBinding binding = DataBindingUtil.bind(v);
        binding.setRecuerdo(data.get(position));

        return binding.getRoot();
    }

    public void setData(List<Recordar> data){
        this.data = data;
        notifyDataSetChanged();
    }


}
