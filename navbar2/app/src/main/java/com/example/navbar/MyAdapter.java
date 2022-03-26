package com.example.navbar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// import org.jetbrains.annotations.NotNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable{
    ArrayList<listLoad> list;
    Context context;
    ArrayList<listLoad> listforsearch;

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1, t2, t3, t4, t5, t6;
        ImageView img;

        public MyViewHolder(View v) {
            super(v);
            t1=v.findViewById(R.id.name);
            t2=v.findViewById(R.id.des);
            img=v.findViewById(R.id.img);
            t3=v.findViewById(R.id.accessibility_custom_action_1);
            t4=v.findViewById(R.id.accessibility_custom_action_2);
            t5=v.findViewById(R.id.accessibility_custom_action_3);
            t6=v.findViewById(R.id.accessibility_custom_action_4);
            v.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         int pos=getAdapterPosition();
                                         listLoad itemselected=list.get(pos);
                                         Intent intent = new Intent (context, load_all_data.class);

                                         intent.putExtra("key2", itemselected.getName());
                                         intent.putExtra("key3", itemselected.getComp());
                                         intent.putExtra("key4", itemselected.getDead());
                                         intent.putExtra("key6", itemselected.getFees());
                                         intent.putExtra("key8", itemselected.getDate());
                                         intent.putExtra("key9", itemselected.getTym());
                                         intent.putExtra("key10", itemselected.getImg());
                                         context.startActivity(intent);


                                     }
                                 }
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
        listLoad obj=list.get(position);
        holder.t1.setText(obj.getName());
        holder.t2.setText(obj.getComp());
        holder.img.setImageResource(obj.getImg());
    }

    public MyAdapter(ArrayList<listLoad> list, Context context) {
        this.list=list;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_frag_recycler, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        listLoad obj=list.get(position);
        holder.t1.setText(obj.getName());
        holder.t2.setText(obj.getComp());
        holder.img.setImageResource(obj.getImg());
    }


    /* @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        listLoad obh = list.get(position);
        holder.t1.setText(obh.getName());
        holder.t2.setText(obh.getComp());
        holder.img.setImageResource(obh.getImg());
        holder.t3.setText(obh.getDead());
        holder.t4.setText(obh.getDead_tym());
        holder.t5.setText(obh.getFees());
        holder.t6.setText(obh.getNumber());
        holder.t7.setText(obh.getDate());
        holder.t8.setText(obh.getTym());
        holder.t9.setText(obh.getComp());
        holder.t10.setText(obh.getComp());
    } */

    /* @Override
    protected void onBindViewHolder(@android.support.annotation.NonNull  MyAdapter.MyViewHolder holder, int position, listLoad model) {
        listLoad obj=list.get(position);
        holder.t1.setText(obj.getName());
        holder.t2.setText(obj.getComp());
        holder.img.setImageResource(obj.getImg());
    } */

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<listLoad> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listforsearch);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (listLoad item : listforsearch) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
   /* @Override
     public Filter getFilter() {
        return ex;
    }
    Filter ex = new Filter() {
        @org.jetbrains.annotations.NotNull
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<listLoad> listfilter = new ArrayList<>();
            if (constraint==null||constraint.length()==0)
                listfilter.addAll(listforsearch);
            else
            {
                String pattern = constraint.toString().toLowerCase().trim();
                for (listLoad contact: listforsearch)
                    if (contact.getStr1().toLowerCase().contains(pattern))
                        listfilter.add(contact);
            }
            FilterResults result_list=new FilterResults();
            result_list.values=listfilter;
            return result_list;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List)results.values);
            notifyDataSetChanged();
        }
    }; */
}