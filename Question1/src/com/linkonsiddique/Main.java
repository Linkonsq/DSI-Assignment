package com.linkonsiddique;

import java.util.*;

enum VehicleType {
    Normal,
    Sports,
    Heavy
}

enum EngineType {
    Oil,
    Gas,
    Diesel
}

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //Initial dummy data
        Vehicle vehicle = new Vehicle(
                VehicleType.Normal.toString(),
                "Lamborghini Veneno",
                EngineType.Oil.toString(),
                "640bhp@8000rpm",
                "245/30 R20",
                "1000 KG"
        );

        System.out.println("Available list of vehicles with expected visitor");

        int expectedVisitor = 30;
        System.out.println("Number of expected visitor: " + expectedVisitor);

        ArrayList<HashMap<String, String>> vehicleList = vehicle.getVehicleList();

        System.out.println("Number of available vehicles: " + vehicleList.size());

        System.out.println("Vehicle list with details: ");

        for (HashMap<String, String> description : vehicleList) {
            for (Map.Entry<String, String> entry : description.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        String vehicleType;
        String modelNumber;
        String engineType;
        String enginePower;
        String tireSize;
        String weight;

        System.out.println("---------------------------------------------");

        while (true) {
            System.out.print("Do you want to add any Vehicle? y/n: ");
            String addVehicle = userInput.next();

            if (addVehicle.equals("y") || addVehicle.equals("Y")) {
                System.out.print("Enter vehicle type among 'Normal', 'Sports', 'Heavy': ");
                vehicleType = userInput.next();

                if (vehicleType.equals(VehicleType.Normal.toString())) {
                    System.out.print("Enter model number: ");
                    modelNumber = userInput.next();

                    System.out.print("Enter any engine type from 'Oil', 'Gas', 'Diesel': ");
                    engineType = userInput.next();

                    System.out.print("Enter engine power: ");
                    enginePower = userInput.next();

                    System.out.print("Enter tire size: ");
                    tireSize = userInput.next();

                    vehicle.setVehicleDescription(VehicleType.Normal.toString(), modelNumber, engineType, enginePower, tireSize, "");

                } else if (vehicleType.equals(VehicleType.Sports.toString())) {
                    System.out.print("Enter model number: ");
                    modelNumber = userInput.next();

                    System.out.println("Extra Feature: Turbo");

                    System.out.println("Engine type: " + EngineType.Oil);

                    System.out.print("Enter engine power: ");
                    enginePower = userInput.next();

                    System.out.print("Enter tire size: ");
                    tireSize = userInput.next();

                    expectedVisitor += 20;

                    vehicle.setVehicleDescription(VehicleType.Sports.toString(), modelNumber, EngineType.Oil.toString(), enginePower, tireSize, "");
                } else if (vehicleType.equals(VehicleType.Heavy.toString())) {
                    System.out.print("Enter model number: ");
                    modelNumber = userInput.next();

                    System.out.println("Engine type: " + EngineType.Diesel);

                    System.out.print("Enter weight: ");
                    weight = userInput.next();

                    System.out.print("Enter engine power: ");
                    enginePower = userInput.next();

                    System.out.print("Enter tire size: ");
                    tireSize = userInput.next();

                    vehicle.setVehicleDescription(VehicleType.Heavy.toString(), modelNumber, EngineType.Diesel.toString(), enginePower, tireSize, weight);
                } else {
                    System.out.println("Please enter a valid vehicle type.");
                }
            } else {
                if (vehicleList.size() < 2) System.out.println("\nTerminating application.");
                break;
            }
        }

        if (vehicleList.size() > 1) {
            System.out.println("---------------------------------------------");
            System.out.println("Available list of vehicles with expected visitor after adding new vehicle");
            System.out.println("Number of expected visitor: " + expectedVisitor);
            System.out.println("Number of available vehicles: " + vehicleList.size());
            System.out.println("Vehicle list with details: ");

            for (HashMap<String, String> description : vehicleList) {
                System.out.println("----------");
                for (Map.Entry<String, String> entry : description.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }

        String removeVehicle;
        boolean vehicleRemoved = false;

        while (true) {
            if (vehicleList.size() > 1) {
                System.out.print("\nDo you want to remove any vehicle? y/n: ");
                removeVehicle = userInput.next();

                if (removeVehicle.equals("y") || removeVehicle.equals("Y")) {
                    vehicleRemoved = false;
                    System.out.print("Please enter vehicle model number: ");
                    modelNumber = userInput.next();

                    for (HashMap<String, String> description : vehicleList) {
                        if(description.get("Model Number").equals(modelNumber)) {
                            vehicleList.remove(description);
                            vehicleRemoved = true;
                            if (description.get("Vehicle Type").equals(VehicleType.Sports.toString())) expectedVisitor -= 20;
                            break;
                        }
                    }

                    if (!vehicleRemoved) {
                        System.out.println("\nThere is no available vehicle named " + modelNumber + ".");
                        System.out.println("Please enter vehicle model number from available vehicles.");
                    }

                } else {
                    System.out.println("\nTerminating application.");
                    break;
                }
            }else {
                break;
            }
        }

        if (vehicleRemoved) {
            System.out.println("---------------------------------------------");
            System.out.println("Available list of vehicles with expected visitor after removing vehicle");
            System.out.println("Number of expected visitor: " + expectedVisitor);
            System.out.println("Number of available vehicles: " + vehicleList.size());
            System.out.println("Vehicle list with details: ");

            for (HashMap<String, String> description : vehicleList) {
                System.out.println("----------");
                for (Map.Entry<String, String> entry : description.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }

            System.out.println("\nTerminating application.");
        }
    }
}
