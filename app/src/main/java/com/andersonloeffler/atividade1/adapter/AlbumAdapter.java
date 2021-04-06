package com.andersonloeffler.atividade1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andersonloeffler.atividade1.R;
import com.andersonloeffler.atividade1.models.Album;
import com.andersonloeffler.atividade1.models.Todo;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> listaAlbums;

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        public View viewAlbum;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewAlbum = itemView;
        }
    }

    public AlbumAdapter(List<Album> albums){
        this.listaAlbums = albums;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_album, parent, false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Album album = this.listaAlbums.get(position);

        TextView tv = holder.viewAlbum.findViewById(R.id.tvAlbumUserId);
        tv.setText(album.getUserId()+"");
        tv = holder.viewAlbum.findViewById(R.id.tvAlbumId);
        tv.setText(album.getId()+"");
        tv = holder.viewAlbum.findViewById(R.id.tvAlbumTitle);
        tv.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.listaAlbums.size();
    }


}
