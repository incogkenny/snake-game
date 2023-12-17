module MuiruriJoshua_Source_Code {

    requires jlayer;
    requires java.desktop;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.media;

    exports com.snake_game;
    opens com.snake_game to javafx.fxml, javafx.base;
    exports com.snake_game.Controllers;
    opens com.snake_game.Controllers to javafx.base, javafx.fxml;
}