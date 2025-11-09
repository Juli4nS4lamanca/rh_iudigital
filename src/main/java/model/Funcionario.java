package model;

import java.time.LocalDate;

public class Funcionario {
  private int funcionario_ID;
  private int tipo_documento_ID;
  private String no_identificacion;
  private String nombres;
  private String apellidos;
  private int estado_civil_ID;
  private int sexo_ID;
  private String direccion;
  private String telefono;
  private LocalDate fecha_nacimiento;

  public Funcionario(int funcionario_ID, int tipo_documento_ID, String no_identificacion, String nombres, String apellidos, int estado_civil_ID, int sexo_ID, String direccion, String telefono, LocalDate fecha_nacimiento) {
    this.funcionario_ID = funcionario_ID;
    this.tipo_documento_ID = tipo_documento_ID;
    this.no_identificacion = no_identificacion;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.estado_civil_ID = estado_civil_ID;
    this.sexo_ID = sexo_ID;
    this.direccion = direccion;
    this.telefono = telefono;
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public Funcionario() {
  }

  public int getFuncionario_ID() {
    return funcionario_ID;
  }

  public void setFuncionario_ID(int funcionario_ID) {
    this.funcionario_ID = funcionario_ID;
  }

  public int getTipo_documento_ID() {
    return tipo_documento_ID;
  }

  public void setTipo_documento_ID(int tipo_documento_ID) {
    this.tipo_documento_ID = tipo_documento_ID;
  }

  public String getNo_identificacion() {
    return no_identificacion;
  }

  public void setNo_identificacion(String no_identificacion) {
    this.no_identificacion = no_identificacion;
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

  public int getEstado_civil_ID() {
    return estado_civil_ID;
  }

  public void setEstado_civil_ID(int estado_civil_ID) {
    this.estado_civil_ID = estado_civil_ID;
  }

  public int getSexo_ID() {
    return sexo_ID;
  }

  public void setSexo_ID(int sexo_ID) {
    this.sexo_ID = sexo_ID;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public LocalDate getFecha_nacimiento() {
    return fecha_nacimiento;
  }

  public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  @Override
  public String toString() {
    return nombres + " " + apellidos + " (" + no_identificacion + ")";
  }
}
