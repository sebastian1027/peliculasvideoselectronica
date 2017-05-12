package movil.unicauca.peliculas.attrs;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Sebastianl on 11/05/2017.
 */

public class Attrs { //atributo personalizado

    @BindingAdapter("app:imgUrl")
    public static void setImageUrl(ImageView imageView, String url){
        Context context = imageView.getContext();
        Uri uri = Uri.parse(url);
        Picasso.with(context).load(uri).into(imageView);
    }
}
