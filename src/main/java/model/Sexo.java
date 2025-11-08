package model;

public class Sexo implements ObtenerID {
  private int sexo_ID;
  private String sexo;

  public Sexo() {
  }

  public Sexo(int sexo_ID, String sexo) {
    this.sexo_ID = sexo_ID;
    this.sexo = sexo;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public int getSexo_ID() {
    return sexo_ID;
  }

  public void setSexo_ID(int sexo_ID) {
    this.sexo_ID = sexo_ID;
  }

  @Override
  public String toString(){
    return sexo;
  }

  @Override
  public int getId() {
    return sexo_ID;
  }
}
