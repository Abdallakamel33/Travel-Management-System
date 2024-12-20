/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.singelton;

/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private static BookingManager instance;
    private final List<String> bookings;

    private BookingManager() {
        bookings = new ArrayList<>();
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    public void addBooking(String booking) {
        bookings.add(booking);
    }

    public List<String> getAllBookings() {
        return bookings;
    } 
}
