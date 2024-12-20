/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel2;

/**
 *
 * @author Lenovo
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import patterns.singelton.BookingManager;

public class ViewBookingPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create GUI Components
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Your Bookings");

        // Create a ListView to display all the bookings
        ListView<String> bookingListView = new ListView<>();
        bookingListView.getItems().addAll(BookingManager.getInstance().getAllBookings());

        Button closeButton = new Button("Close");

        // Add components to the layout
        layout.getChildren().addAll(titleLabel, bookingListView, closeButton);

        // Close button action
        closeButton.setOnAction(e -> primaryStage.close());

        // Set up the scene and stage
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("View Bookings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}