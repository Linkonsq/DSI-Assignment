package com.linkonsiddique;

import java.util.ArrayList;
import java.util.HashMap;

public class Vehicle {

    public Vehicle(String vehicleType, String modelNumber, String engineType, String enginePower, String tireSize, String weight) {
        setVehicleDescription(vehicleType, modelNumber, engineType, enginePower, tireSize, weight);
    }

    ArrayList<HashMap<String, String>> vehicleList = new ArrayList<>();

    public void setVehicleDescription(String vehicleType, String modelNumber, String engineType, String enginePower, String tireSize, String weight) {
        HashMap<String, String> vehicleDescription = new HashMap<>();
        if (vehicleType.equals("Sports")) {
            vehicleDescription.put("Extra Feature", "Turbo");
        }

        if (vehicleType.equals("Heavy")) {
            vehicleDescription.put("Weight", weight);
        }

        vehicleDescription.put("Vehicle Type", vehicleType);
        vehicleDescription.put("Model Number", modelNumber);
        vehicleDescription.put("Engine Type", engineType);
        vehicleDescription.put("Engine Power", enginePower);
        vehicleDescription.put("Tire Size", tireSize);

        vehicleList.add(vehicleDescription);
    }

    public ArrayList<HashMap<String, String>> getVehicleList() {
        return vehicleList;
    }
}