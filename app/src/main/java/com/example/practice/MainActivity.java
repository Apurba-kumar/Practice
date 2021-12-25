package com.example.practice;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String []movieName = {"Bangladesh","India","Argentina","Brazil","Japan"};
    int []img = {R.mipmap.bd,R.mipmap.ind,R.mipmap.arg,R.mipmap.bra,R.mipmap.jap};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.movie_list_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());

    }
    class MyAdapter extends RecyclerView.Adapter<MovieViewHolder>{

        @NonNull
        @Override
        public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.list_item, viewGroup, false);
            return new MovieViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
           movieViewHolder.textView.setText(movieName[i]);
           movieViewHolder.flagImg.setImageResource(img[i]);
        }

        @Override
        public int getItemCount() {
            return movieName.length;
        }
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
         TextView textView;
         ImageView flagImg;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            flagImg = itemView.findViewById(R.id.flag);
        }
    }
}