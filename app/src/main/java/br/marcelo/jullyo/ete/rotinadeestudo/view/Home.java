package br.marcelo.jullyo.ete.rotinadeestudo.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.marcelo.jullyo.ete.rotinadeestudo.controller.PlaneController;
import br.marcelo.jullyo.ete.rotinadeestudo.model.Planejamento;
import br.marcelo.jullyo.ete.rotinadeestudo.R;

public class Home extends AppCompatActivity {
    String disciplina, assunto,dataHora;
    EditText editDisciplina, editAssunto,editDataH;
    PlaneController pc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        pc = new PlaneController(getBaseContext());

        editDisciplina = findViewById(R.id.editTexDisciplina);
        editAssunto = findViewById(R.id.editTextAssunto);
        editDataH = findViewById(R.id.editTextData);


    }
    public void salvar (View v){
        if(editDisciplina.getText().toString().equals("")) {
            alerta("Preencha o Campo Disciplina");
            editDisciplina.requestFocus();
        } else if(editAssunto.getText().toString().equals("")){
            alerta("Preencha o campo Assunto");
            editAssunto.requestFocus();
        }else if(editDataH.getText().toString().equals("")){
            alerta("Preencha o campo data e hora");
            editDataH.requestFocus();
        }else {

            Planejamento planejamento = new Planejamento();
            planejamento.setDisciplina(editDisciplina.getText().toString());
            planejamento.setAssunto(editAssunto.getText().toString());
            planejamento.setData_hora(editDataH.getText().toString());
            pc.inserirDados(planejamento);

            editDisciplina.setText("");
            editAssunto.setText("");
            editDataH.setText("");
            editDisciplina.requestFocus();

            alerta("adicionado com sucesso!");

        }


    }
    public void acompanhar(View v){

        Intent i = new Intent(Home.this, Lista_dados.class);
        startActivity(i);


    }
    public void alerta(String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(Home.this);
        alert.setMessage(msg);
        alert.setTitle("Alerta");
        alert.setNeutralButton("OK",null);
        alert.show();
    }
}