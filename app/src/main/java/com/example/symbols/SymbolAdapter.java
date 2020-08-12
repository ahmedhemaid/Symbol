package com.example.symbols;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class SymbolAdapter extends RecyclerView.Adapter<SymbolAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Symbol> data;
    private OnItemClickListener mListener;
    public SymbolAdapter(ArrayList<Symbol> data, Context context){
        this.data = data;
        this.context = context;

    }
    //onItemClick
    public interface OnItemClickListener{
        void onItemClick(int position);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_symbol, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.symbol.setText(data.get(position).symbol);
        holder.meaning.setText(data.get(position).meaning);

    }
    public void filterList(ArrayList<Symbol> filteredList) {
        data = filteredList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView symbol,meaning;
        public ViewHolder(View itemView) {
            super(itemView);
            symbol=itemView.findViewById(R.id.symbol_in_card);
            meaning=itemView.findViewById(R.id.meaning_in_card);

        }
    }


}
