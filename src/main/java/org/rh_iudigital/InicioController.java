package org.rh_iudigital;

import java.io.IOException;
import javafx.fxml.FXML;

public class InicioController {

    @FXML
    private void formFuncionarios() throws IOException {
        App.setRoot("Form_Funcionario");
    }

    @FXML
    private void verFuncionarios() throws IOException{
        App.setRoot("verFuncionarios");
    }
}
