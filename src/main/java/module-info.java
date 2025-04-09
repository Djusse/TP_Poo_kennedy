module com.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.polytechnique to javafx.fxml;
    opens com.polytechnique.Controlleurs to javafx.fxml;
    exports com.polytechnique;
    exports com.polytechnique.Controlleurs;
}