package model;

public class Formacion {
  private int formacion_ID;
  private String universidad;
  private String titulo;
  private int nivel_estudio;
  private int funcionario_ID;

  public Formacion(int formacion_ID, String universidad, String titulo, int nivel_estudio, int funcionario_ID) {
    this.formacion_ID = formacion_ID;
    this.universidad = universidad;
    this.titulo = titulo;
    this.nivel_estudio = nivel_estudio;
    this.funcionario_ID = funcionario_ID;
  }

  public Formacion() {
  }

  public int getFormacion_ID() {
    return formacion_ID;
  }

  public void setFormacion_ID(int formacion_ID) {
    this.formacion_ID = formacion_ID;
  }

  public String getUniversidad() {
    return universidad;
  }

  public void setUniversidad(String universidad) {
    this.universidad = universidad;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getNivel_estudio() {
    return nivel_estudio;
  }

  public void setNivel_estudio(int nivel_estudio) {
    this.nivel_estudio = nivel_estudio;
  }

  public int getFuncionario_ID() {
    return funcionario_ID;
  }

  public void setFuncionario_ID(int funcionario_ID) {
    this.funcionario_ID = funcionario_ID;
  }
}
