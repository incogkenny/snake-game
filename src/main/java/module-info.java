module MuiruriJoshua_Source_Code {

    requires jlayer;
    requires java.desktop;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports com.snake_game;
    opens com.snake_game to javafx.fxml, javafx.base;
}