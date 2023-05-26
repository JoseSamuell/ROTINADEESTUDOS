package br.marcelo.jullyo.ete.rotinadeestudo.model;

public class Planejamento {
   private int id;
   private String disciplina;
   private String data_hora;
   private String assunto;

    public int getId() {
       return id;
    }

   public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
