module com.polytechnique {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.base;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.polytechnique.LogiqueMetier.Appareil to javafx.base;
    opens com.polytechnique to javafx.fxml;
    opens com.polytechnique.Controlleurs to javafx.fxml;
    exports com.polytechnique;
    exports com.polytechnique.Controlleurs;
}