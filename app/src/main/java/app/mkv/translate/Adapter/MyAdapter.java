package app.mkv.translate.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.mkv.translate.DataBaseHelper.MyDataBase;
import app.mkv.translate.DataModel.DictionaryModel;
import app.mkv.translate.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    Context context;
    List<DictionaryModel> models ;
    MyDataBase db;

    public MyAdapter(Context context, List<DictionaryModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.txt_english.setText(models.get(position).getEnglishWord());
        holder.txt_persian.setText(models.get(position).getPersianWord());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView txt_persian , txt_english ;
        ImageView img_pronunciation, img_favorite;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_persian = itemView.findViewById(R.id.txt_persian);
            txt_english = itemView.findViewById(R.id.txt_english);
            img_pronunciation = itemView.findViewById(R.id.img_pronunciation);
            img_favorite = itemView.findViewById(R.id.img_favorite);

            img_favorite.setOnClickListener(view -> {
                if(models.get(getAdapterPosition()).getFavorite() == 0){
                    img_favorite.setImageResource(R.drawable.favorite_icon);



                }else {
                    img_favorite.setImageResource(R.drawable.favorite_off_icon);
                }

            });


        }
    }
}
