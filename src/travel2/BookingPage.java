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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import patterns.factory.TravelPackageFactory;
import patterns.factory.AccommodationFactory;
import patterns.factory.products.TravelPackage;
import patterns.factory.products.Accommodation;
import patterns.builder.Booking;
import patterns.builder.Booking.Builder;
import patterns.singelton.BookingManager;
import patterns.singelton.UserProfileManager;


public class BookingPage extends Application {

    private Stage mainStage;  // Keep track of the main stage

    @Override
    public void start(Stage primaryStage) {
        this.mainStage = primaryStage;  // Initialize the main stage
        // Create GUI Components
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        Label travelPackageLabel = new Label("Choose a Travel Package:");
        ComboBox<String> travelPackageChoice = new ComboBox<>();
        travelPackageChoice.getItems().addAll("Luxury", "Adventure", "Cultural");

        Label accommodationLabel = new Label("Choose Accommodation:");
        ComboBox<String> accommodationChoice = new ComboBox<>();
        accommodationChoice.getItems().addAll("Hotel", "Resort", "Hostel");

        Label userLabel = new Label("User: " + UserProfileManager.getInstance().getUsername());

        Button bookButton = new Button("Book Now");
        Button cancelButton = new Button("Cancel");
        Button viewBookingsButton = new Button("View Bookings");
        Button backButton = new Button("Back");

        // Add components to grid
        grid.add(userLabel, 0, 0);
        grid.add(travelPackageLabel, 0, 1);
        grid.add(travelPackageChoice, 1, 1);
        grid.add(accommodationLabel, 0, 2);
        grid.add(accommodationChoice, 1, 2);
        grid.add(bookButton, 1, 3);
        grid.add(cancelButton, 0, 3);
        grid.add(viewBookingsButton, 0, 4);
        grid.add(backButton, 1, 4); // Back button

        // Cancel button action
        cancelButton.setOnAction(e -> mainStage.close());

        // Book button action
        bookButton.setOnAction(e -> {
            String travelChoice = travelPackageChoice.getValue();
            String accommodationChoiceStr = accommodationChoice.getValue();

            if (travelChoice != null && accommodationChoiceStr != null) {
                // Create TravelPackage and Accommodation using the Factory
                TravelPackage travelPackage = TravelPackageFactory.createPackage(travelChoice);
                Accommodation accommodation = AccommodationFactory.createAccommodation(accommodationChoiceStr);

                // Create Booking using Builder Pattern
                Booking booking = new Booking.Builder()
                        .setTravelPackage(travelPackage)
                        .setAccommodation(accommodation)
                        .setUserDetails(UserProfileManager.getInstance().getUsername())
                        .build();

                // Add the booking to the BookingManager (Singleton)
                BookingManager.getInstance().addBooking(booking.toString());

                // Show a success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Booking Confirmed: " + booking.toString());
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select both travel package and accommodation.");
                alert.showAndWait();
            }
        });

        // View Bookings button action
        viewBookingsButton.setOnAction(e -> {
            // Open ViewBookingPage to show all bookings
            ViewBookingPage viewBookingPage = new ViewBookingPage();
            Stage viewBookingStage = new Stage();
            viewBookingPage.start(viewBookingStage);
        });

        // Back button action: Go back to the previous screen
        backButton.setOnAction(e -> {
            // Here, we will simply close the current page, but you can adjust to go back to a home screen if needed
            mainStage.close();
            // Optionally, create a home screen or previous page that opens when you click Back.
        });

        // Set up the scene and stage
        Scene scene = new Scene(grid, 400, 300);
        mainStage.setTitle("Booking Page");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
