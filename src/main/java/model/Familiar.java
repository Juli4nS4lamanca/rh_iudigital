package model;

public class Familiar {
  private int familiar_ID;
  private String nombres;
  private String apellidos;
  private int rol_ID;
  private int funcionario_ID;

  public Familiar(int familiar_ID, String nombres, String apellidos, int rol_ID, int funcionario_ID) {
    this.familiar_ID = familiar_ID;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.rol_ID = rol_ID;
    this.funcionario_ID = funcionario_ID;
  }

  public Familiar() {
  }

  public int getFamiliar_ID() {
    return familiar_ID;
  }

  public void setFamiliar_ID(int familiar_ID) {
    this.familiar_ID = familiar_ID;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public int getRol_ID() {
    return rol_ID;
  }

  public void setRol_ID(int rol_ID) {
    this.rol_ID = rol_ID;
  }

  public int getFuncionario_ID() {
    return funcionario_ID;
  }

  public void setFuncionario_ID(int funcionario_ID) {
    this.funcionario_ID = funcionario_ID;
  }
}
