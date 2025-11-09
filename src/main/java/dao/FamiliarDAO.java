package dao;

import model.Familiar;
import utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FamiliarDAO{

    private static final String SQL_INSERT = 
        "INSERT INTO familiares (nombres, apellidos, rol_familiar_ID, funcionario_ID) VALUES (?, ?, ?, ?)";

    public void insertar(Familiar familiar) throws SQLException {
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, familiar.getNombres());
            stmt.setString(2, familiar.getApellidos());
            stmt.setInt(3, familiar.getRolFamiliarId());
            stmt.setInt(4, familiar.getFuncionarioId());

            stmt.executeUpdate();
        }
    }
}