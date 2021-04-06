package com.andersonloeffler.atividade1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andersonloeffler.atividade1.R;
import com.andersonloeffler.atividade1.models.Comment;
import com.andersonloeffler.atividade1.models.Todo;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<Comment> listaComments;

    public class CommentViewHolder extends RecyclerView.ViewHolder{

        public View viewComment;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewComment = itemView;
        }
    }

    public CommentAdapter(List<Comment> comments){
        this.listaComments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_comment, parent, false);
        return new CommentAdapter.CommentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {

        Comment comment = this.listaComments.get(position);

        TextView tv = holder.viewComment.findViewById(R.id.tvCommentPostId);
        tv.setText(comment.getPostId()+"");
        tv = holder.viewComment.findViewById(R.id.tvCommentId);
        tv.setText(comment.getId()+"");
        tv = holder.viewComment.findViewById(R.id.tvCommentName);
        tv.setText(comment.getName());
        tv = holder.viewComment.findViewById(R.id.tvCommentEmail);
        tv.setText(comment.getEmail());
        tv = holder.viewComment.findViewById(R.id.tvCommentBody);
        tv.setText(comment.getBody());

    }

    @Override
    public int getItemCount() { return this.listaComments.size(); }


}
