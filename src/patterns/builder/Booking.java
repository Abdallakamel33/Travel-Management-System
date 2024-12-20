/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.builder;
import patterns.factory.products.Accommodation;
import patterns.factory.products.TravelPackage;

public class Booking {
    private final TravelPackage travelPackage;
    private final Accommodation accommodation;
    private final String userDetails;

    private Booking(Builder builder) {
        this.travelPackage = builder.travelPackage;
        this.accommodation = builder.accommodation;
        this.userDetails = builder.userDetails;
    }

    public static class Builder {
        private TravelPackage travelPackage;
        private Accommodation accommodation;
        private String userDetails;

        public Builder setTravelPackage(TravelPackage travelPackage) {
            this.travelPackage = travelPackage;
            return this;
        }

        public Builder setAccommodation(Accommodation accommodation) {
            this.accommodation = accommodation;
            return this;
        }

        public Builder setUserDetails(String userDetails) {
            this.userDetails = userDetails;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }

    @Override
    public String toString() {
        return "Booking{" +
                "travelPackage=" + travelPackage.getDescription() +
                ", accommodation=" + accommodation.getDetails() +
                ", userDetails='" + userDetails + '\'' +
                '}';
    }
}
