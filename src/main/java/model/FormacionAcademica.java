package model;

public class FormacionAcademica {
    private int formacionAcademicaId;
    private String universidad;
    private String titulo;
    private int nivelEstudioId;
    private int funcionarioId;

    // Getters y setters
    public int getFormacionAcademicaId() { return formacionAcademicaId; }
    public void setFormacionAcademicaId(int formacionAcademicaId) { this.formacionAcademicaId = formacionAcademicaId; }

    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) { this.universidad = universidad; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getNivelEstudioId() { return nivelEstudioId; }
    public void setNivelEstudioId(int nivelEstudioId) { this.nivelEstudioId = nivelEstudioId; }

    public int getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(int funcionarioId) { this.funcionarioId = funcionarioId; }
}