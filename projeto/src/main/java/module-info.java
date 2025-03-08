module projeto {

    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens projeto to javafx.fxml;

    exports projeto;

    opens projeto.view to javafx.fxml;

    exports projeto.view;

    opens projeto.controller to javafx.fxml;

    exports projeto.controller;

    opens projeto.object to javafx.fxml;

    exports projeto.object;
}
