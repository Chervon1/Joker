package com.example.joker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class JokerAdapter extends RecyclerView.Adapter<JokerAdapter.ViewHolder> {

    Context context;
    List<Joker> jokes;

    public JokerAdapter(Context context, List<Joker> jokes) {
        this.context = context;
        this.jokes = jokes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("JokesAdapter", "onCreateViewHolder");
        View jokeView = LayoutInflater.from(context).inflate(R.layout.jokes_layout, parent, false);
        return new ViewHolder(jokeView);
    }

    @Override
    public void onBindViewHolder(@NonNull JokerAdapter.ViewHolder holder, int position) {
        Log.d("JokerAdapter", "onBindViewHolder" + position);
        // Get the movie at the position
        Joker joker = jokes.get(position);
        holder.bind(joker);
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvType;
        TextView tvSetup;
        TextView tvPunchline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tvType);
            tvSetup = itemView.findViewById(R.id.tvSetup);
            tvPunchline = itemView.findViewById(R.id.tvPunchline);
        }

        public void bind(Joker joker) {
            tvType.setText(joker.getType());
            tvSetup.setText(joker.getSetup());
            tvPunchline.setText(joker.getPunchline());
        }
    }
}
