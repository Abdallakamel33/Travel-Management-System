/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.factory;
import patterns.factory.products.*;
/**
 *
 * @author Lenovo
 */
public class TravelPackageFactory {
    public static TravelPackage createPackage(String type) {
        switch (type.toLowerCase()) {
            case "luxury":
                return new LuxuryPackage();
            case "adventure":
                return new AdventurePackage();
            case "cultural":
                return new CulturalPackage();
            default:
                throw new IllegalArgumentException("Unknown package type: " + type);
        }
    }
}
