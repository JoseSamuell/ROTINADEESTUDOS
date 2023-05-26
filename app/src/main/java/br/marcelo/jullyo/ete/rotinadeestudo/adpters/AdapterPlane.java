package br.marcelo.jullyo.ete.rotinadeestudo.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import br.marcelo.jullyo.ete.rotinadeestudo.R;
import br.marcelo.jullyo.ete.rotinadeestudo.model.Planejamento;

public class AdapterPlane extends BaseAdapter implements Filterable {

    private LayoutInflater mInflater;
    private ArrayList<Planejamento> planejamentos;
    ArrayList<Planejamento> pessoasFiltrados;



    public AdapterPlane(Context context, ArrayList<Planejamento> planejamentos) {
        //Itens que preencheram o listview
        this.planejamentos = planejamentos;
        pessoasFiltrados = planejamentos;

        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount() {
        return planejamentos.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Planejamento getItem(int position) {
        return planejamentos.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        //Pega o item de acordo com a posição.
        Planejamento planejamento = planejamentos.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_lista, null);



        ((TextView) view.findViewById(R.id.textViewDestaque)).setText(planejamento.getDisciplina().toUpperCase().substring(0,1));
        ((TextView) view.findViewById(R.id.textViewDisciplina)).setText(planejamento.getDisciplina());
        ((TextView) view.findViewById(R.id.textViewAssunto)).setText(planejamento.getAssunto());
        ((TextView) view.findViewById(R.id.textViewHora)).setText(planejamento.getData_hora());



        return view;
    }


    public static String formato(double x) {
        return String.format("%.2f", x);
    }

    public static String formatokG(double x) {
        return String.format("%.3f", x);
    }


    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<Planejamento> filterList = new ArrayList<Planejamento>();
                for (int i = 0; i < pessoasFiltrados.size(); i++) {
                    if ((pessoasFiltrados.get(i).getDisciplina().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {

                        Planejamento planejamento = new Planejamento();
                        filterList.add(planejamento);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = pessoasFiltrados.size();
                results.values = pessoasFiltrados;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            planejamentos = (ArrayList<Planejamento>) results.values;
            notifyDataSetChanged();
        }
    };
}