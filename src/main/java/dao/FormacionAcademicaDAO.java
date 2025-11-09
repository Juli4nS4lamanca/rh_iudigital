package dao;



import model.FormacionAcademica;
import utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormacionAcademicaDAO {

    private static final String SQL_INSERT =
        "INSERT INTO formacion_academica (universidad, titulo, nivel_estudio_ID, funcionario_ID) VALUES (?, ?, ?, ?)";

    public void insertar(FormacionAcademica formacion) throws SQLException {
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, formacion.getUniversidad());
            stmt.setString(2, formacion.getTitulo());
            stmt.setInt(3, formacion.getNivelEstudioId());
            stmt.setInt(4, formacion.getFuncionarioId());

            stmt.executeUpdate();
        }
    }
}
