package app.mkv.translate.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import app.mkv.translate.Adapter.MyAdapter;
import app.mkv.translate.DataBaseHelper.MyDataBase;
import app.mkv.translate.R;


public class HomeFragment extends Fragment {


    RecyclerView rv_item;
    MyAdapter adapter;
    MyDataBase db;


    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_item = view.findViewById(R.id.rv_item);

        initViews();

        return view;

    }


    private void initViews(){

        rv_item.setHasFixedSize(true);
        rv_item.setLayoutManager(new LinearLayoutManager(getContext()));
        db = new MyDataBase(getContext());
        adapter = new MyAdapter(getContext(), db.getAllData());
        rv_item.setAdapter(adapter);



    }

}