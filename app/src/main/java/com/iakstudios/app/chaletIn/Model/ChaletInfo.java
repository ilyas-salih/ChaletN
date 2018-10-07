package com.iakstudios.app.chaletIn.Model;

// Class made to store all the details about a particular chalet in the database
public class ChaletInfo {

    String chaletID, chaletPrice, chaletCardType, chaletGuests, chaletRooms, chaletBaths, chaletKitchens, chaletDesc, chaletPlayAreaToggle, chaletBedroomToggle, chaletFridgeToggle, chaletPoolToggle, chaletMajlisToggle, image1Address, image2Address, image3Address, image4Address;
    Double chaletLatitude, chaletLongitude;

    public ChaletInfo() {

    }

    public ChaletInfo(String chaletID, String chaletPrice, String chaletCardType, String chaletGuests, String chaletRooms, String chaletBaths, String chaletKitchens, String chaletDesc, String chaletPlayAreaToggle, String chaletBedroomToggle, String chaletFridgeToggle, String chaletPoolToggle, String chaletMajlisToggle, Double chaletLatitude, Double chaletLongitude, String image1Address, String image2Address, String image3Address, String image4Address) {
        this.chaletID = chaletID;
        this.chaletPrice = chaletPrice;
        this.chaletCardType = chaletCardType;
        this.chaletGuests = chaletGuests;
        this.chaletRooms = chaletRooms;
        this.chaletBaths = chaletBaths;
        this.chaletKitchens = chaletKitchens;
        this.chaletDesc = chaletDesc;
        this.chaletPlayAreaToggle = chaletPlayAreaToggle;
        this.chaletBedroomToggle = chaletBedroomToggle;
        this.chaletFridgeToggle = chaletFridgeToggle;
        this.chaletPoolToggle = chaletPoolToggle;
        this.chaletMajlisToggle = chaletMajlisToggle;
        this.chaletLatitude = chaletLatitude;
        this.chaletLongitude = chaletLongitude;
        this.image1Address = image1Address;
        this.image2Address = image2Address;
        this.image3Address = image3Address;
        this.image4Address = image4Address;
    }
}
