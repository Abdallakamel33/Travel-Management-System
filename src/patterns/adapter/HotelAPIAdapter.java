/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.adapter;

/**
 *
 * @author Lenovo
 */
import patterns.factory.products.Accommodation;

public class HotelAPIAdapter extends Accommodation {
    private final ExternalHotelAPI externalAPI;

    public HotelAPIAdapter(ExternalHotelAPI externalAPI) {
        this.externalAPI = externalAPI;
    }

    @Override
    public String getDetails() {
        return "Adapted Hotel Data: " + externalAPI.getHotelData();
    }
}

// Mock External API
class ExternalHotelAPI {
    public String getHotelData() {
        return "Grand Plaza Hotel (API)";
    }
}