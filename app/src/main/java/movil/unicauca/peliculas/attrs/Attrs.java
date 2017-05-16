package movil.unicauca.peliculas.attrs;

import android.content.Context;
import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindingAdapter("app:fontTtf")
    public static void loadFonts(TextView txt, String font){
        AssetManager assetManager = txt.getContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/"+font+".TTF");
        txt.setTypeface(typeface);

    }
}
