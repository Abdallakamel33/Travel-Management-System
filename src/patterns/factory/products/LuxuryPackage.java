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
public class LuxuryPackage extends TravelPackage {
    @Override
    public String getDescription() {
        return "Luxury Package: A premium travel experience with 5-star accommodations and VIP services.";
    }
}
