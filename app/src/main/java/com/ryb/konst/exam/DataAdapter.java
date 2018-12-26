package com.ryb.konst.exam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Theme> themes;

    DataAdapter(Context context, List<Theme> themes) {
        this.themes = themes;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_display_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Theme phone = themes.get(position);
        holder.nameTheme.setText(phone.getName());
    }

    @Override
    public int getItemCount() {
        return themes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameTheme;
        ViewHolder(View view){
            super(view);
            nameTheme = (TextView) view.findViewById(R.id.themeName);
        }
    }

}
