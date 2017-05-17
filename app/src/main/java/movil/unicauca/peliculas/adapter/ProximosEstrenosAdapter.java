package movil.unicauca.peliculas.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import movil.unicauca.peliculas.R;
import movil.unicauca.peliculas.databinding.TemplateProximosEstrenosBinding;
import movil.unicauca.peliculas.util.Data;

/**
 * Created by Sebastianl on 11/05/2017.
 */
//entre <> va el viewholder
public class ProximosEstrenosAdapter extends RecyclerView.Adapter<ProximosEstrenosAdapter.ProximosEstrenosViewHolder> {


    public interface OnProximosEstrenosListener{
        void onProximosEstrenos(View v);
    }

    LayoutInflater inflater;
    OnProximosEstrenosListener onProximosEstrenosListener;


    public ProximosEstrenosAdapter(LayoutInflater inflater, OnProximosEstrenosListener onProximosEstrenosListener) {
        this.onProximosEstrenosListener = onProximosEstrenosListener; //tengo que mandarle un objeto variable en esta interfaz
        this.inflater = inflater;
    }

    @Override
    //metodo 1: Crear el view holder
    public ProximosEstrenosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_proximos_estrenos, parent, false); //el false para que no este anidado
        ProximosEstrenosViewHolder holder = new ProximosEstrenosViewHolder(v);
        return holder;
    }

    @Override
    //metodo 2: coloca la informacion en el view holder, se llama por cada posision de un objeto de la lista
    public void onBindViewHolder(ProximosEstrenosViewHolder holder, int position) {
        holder.binding.setProximosestrenos(Data.datape.get(position));
        holder.binding.setHandler(this);
    }

    @Override
    //metodo 3: Me da el Tamaño de la lista de los datos
    public int getItemCount() {
        return Data.datape.size();
    }

    public void onClickpe(View v){ //al pulsar sobre el cardView hace la navegacion hacia donde queremos que sea la pelicula
        onProximosEstrenosListener.onProximosEstrenos(v);
    }

    public static class ProximosEstrenosViewHolder extends RecyclerView.ViewHolder{

        TemplateProximosEstrenosBinding binding;

        public ProximosEstrenosViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }


}

