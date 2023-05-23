package br.marcelo.jullyo.ete.rotinadeestudo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPlane {

    private LayoutInflater mInflater;
    private ArrayList<String> pessoas;
    ArrayList<String> pessoasFiltrados;



    public AdapterPlane(Context context, ArrayList<String> pessoas) {
        //Itens que preencheram o listview
        this.pessoas = pessoas;
        pessoasFiltrados = pessoas;

        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount() {
        return pessoas.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Pessoa getItem(int position) {
        return pessoas.get(position);
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
        Pessoa pessoa = pessoas.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_lista, null);



        ((TextView) view.findViewById(R.id.textViewDestaque)).setText(pessoa.getNome().toUpperCase().substring(0,1));
        ((TextView) view.findViewById(R.id.textViewTitulo)).setText(pessoa.getNome());
        ((TextView) view.findViewById(R.id.textViewSubtitulo)).setText(pessoa.getCpf());



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
                ArrayList<String> filterList = new ArrayList<String>();
                for (int i = 0; i < pessoasFiltrados.size(); i++) {
                    if ((pessoasFiltrados.get(i).getNome().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {

                        Pessoa cliente = new Pessoa();
                        filterList.add(cliente);
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
            pessoas = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }
    };
}
