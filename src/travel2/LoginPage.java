/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel2;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import patterns.singelton.UserProfileManager;
import patterns.singelton.BookingManager;

public class LoginPage extends Application {
    @Override
    public void start(Stage stage) {
        VBox layout = new VBox(10);
        Label usernameLabel = new Label("Enter Username:");
        TextField usernameField = new TextField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            if (!username.isEmpty()) {
                UserProfileManager.getInstance().setUsername(username);
                new BookingPage().start(new Stage());
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a username!");
                alert.show();
            }
        });

        layout.getChildren().addAll(usernameLabel, usernameField, loginButton);
        Scene scene = new Scene(layout, 300, 200);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
