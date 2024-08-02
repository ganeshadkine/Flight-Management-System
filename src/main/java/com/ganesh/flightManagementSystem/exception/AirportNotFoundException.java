package com.ganesh.flightManagementSystem.exception;

public class AirportNotFoundException extends Exception {
    public AirportNotFoundException(String message) {
        super(message);
    }
}