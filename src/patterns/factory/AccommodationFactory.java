/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.factory;

/**
 *
 * @author Lenovo
 */
import patterns.factory.products.*;

public class AccommodationFactory {
    public static Accommodation createAccommodation(String type) {
        switch (type.toLowerCase()) {
            case "hotel":
                return new Hotel();
            case "resort":
                return new Resort();
            default:
                throw new IllegalArgumentException("Unknown accommodation type: " + type);
        }
    } 
}
