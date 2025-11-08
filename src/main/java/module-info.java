module org.rh_iudigital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.rh_iudigital to javafx.fxml;
    exports org.rh_iudigital;
}
