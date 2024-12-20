/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.factory.products;

/**
 *
 * @author Lenovo
 */
public class Hostel extends Accommodation {
    @Override
    public String getDetails() {
        return "Hostel: Affordable accommodations with shared rooms for budget-conscious travelers.";
    }
}
