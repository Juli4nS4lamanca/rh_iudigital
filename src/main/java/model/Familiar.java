package model;

public class Familiar {
    private int familiarId;
    private String nombres;
    private String apellidos;
    private int rolFamiliarId;
    private int funcionarioId;

    // Getters y setters
    public int getFamiliarId() { return familiarId; }
    public void setFamiliarId(int familiarId) { this.familiarId = familiarId; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getRolFamiliarId() { return rolFamiliarId; }
    public void setRolFamiliarId(int rolFamiliarId) { this.rolFamiliarId = rolFamiliarId; }

    public int getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(int funcionarioId) { this.funcionarioId = funcionarioId; }
}