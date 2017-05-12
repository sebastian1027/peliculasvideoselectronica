package movil.unicauca.peliculas.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import movil.unicauca.peliculas.R;
import movil.unicauca.peliculas.databinding.TemplateEstrenosBinding;
import movil.unicauca.peliculas.util.Data;

/**
 * Created by Sebastianl on 10/05/2017.
 */
//entre <> va el viewholder
public class EstrenosAdapter extends RecyclerView.Adapter<EstrenosAdapter.EstrenosViewHolder>{

    public interface OnEstrenosListener{
        void onEstreno(View v);
    }
    LayoutInflater inflater;
    OnEstrenosListener onEstrenosListener;

    public EstrenosAdapter(LayoutInflater inflater, OnEstrenosListener onEstrenosListener) {
        this.onEstrenosListener = onEstrenosListener; //tengo que mandarle un objeto variable en esta interfaz
        this.inflater = inflater; //constructor para asignar la variable
    }

    @Override
    //metodo 1: Crear el view holder
    public EstrenosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_estrenos, parent, false); //el false para que no este anidado
        EstrenosViewHolder holder = new EstrenosViewHolder(v);
        return holder;
    }

    @Override
    //metodo 2: coloca la informacion en el view holder, se llama por cada posision de un objeto de la lista
    public void onBindViewHolder(EstrenosViewHolder holder, int position) {
        holder.binding.setEstrenos(Data.data.get(position));
        holder.binding.setHandler(this);
    }

    @Override
    //metodo 3: Me da el Tamaño de la lista de los datos
    public int getItemCount() {
        return Data.data.size();
    }

    public void onClicke(View v){ //al pulsar sobre el cardView hace la navegacion hacia donde queremos que sea la pelicula
        onEstrenosListener.onEstreno(v);
    }

    public static class EstrenosViewHolder extends RecyclerView.ViewHolder{ //view holder es clase que me
                                                                            // da acceso a los views del template
        TemplateEstrenosBinding binding;
        public EstrenosViewHolder(View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView); //el bind lo enlaza con el tipo view
        }
    }
}
