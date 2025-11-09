package model;

public class Nivel_Estudio implements ObtenerID {
  private int nivel_ID;
  private String nivel_estudio_nombre;

  public Nivel_Estudio(int nivel_ID, String nivel_estudio_nombre) {
    this.nivel_ID = nivel_ID;
    this.nivel_estudio_nombre = nivel_estudio_nombre;
  }

  public Nivel_Estudio() {
  }

  public int getNivel_ID() {
    return nivel_ID;
  }

  public void setNivel_ID(int nivel_ID) {
    this.nivel_ID = nivel_ID;
  }

  public String getNivel_estudio_nombre() {
    return nivel_estudio_nombre;
  }

  public void setNivel_estudio_nombre(String nivel_estudio_nombre) {
    this.nivel_estudio_nombre = nivel_estudio_nombre;
  }

  @Override
  public String toString() {
    return nivel_estudio_nombre;
  }

  @Override
  public int getId() {
    return nivel_ID;
  }
}
