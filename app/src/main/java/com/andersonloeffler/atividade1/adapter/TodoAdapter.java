package com.andersonloeffler.atividade1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andersonloeffler.atividade1.R;
import com.andersonloeffler.atividade1.models.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private List<Todo> listaTodos;

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        public View viewTodo;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }

    public TodoAdapter(List<Todo> todos){
        this.listaTodos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_todo, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {

        Todo todo = this.listaTodos.get(position);

        TextView tv = holder.viewTodo.findViewById(R.id.tvId);
        tv.setText(todo.getId()+"");
        tv = holder.viewTodo.findViewById(R.id.tvIdUser);
        tv.setText(todo.getUserId()+"");
        tv = holder.viewTodo.findViewById(R.id.tvTitle);
        tv.setText(todo.getTitle()+"");
        CheckBox cb = holder.viewTodo.findViewById(R.id.cbCompleted);
        cb.setChecked(todo.isCompleted());
    }

    @Override
    public int getItemCount() {
        return this.listaTodos.size();
    }
}
