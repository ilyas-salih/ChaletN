package com.iakstudios.app.chaletIn.Model;

import com.google.android.gms.maps.model.LatLng;

public class PlaceInfo {
    private String name;
    private LatLng latlng;

public PlaceInfo()
{

}
    public PlaceInfo(String name, LatLng latlng, float rating) {
        this.name = name;
        this.latlng = latlng;
        this.rating = rating;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    private float rating;

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "name='" + name + '\'' +
                ", latlng=" + latlng +
                ", rating=" + rating +
                '}';
    }



}
