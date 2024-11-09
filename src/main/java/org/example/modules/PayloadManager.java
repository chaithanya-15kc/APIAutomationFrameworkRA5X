package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.Bookingdates;

public class PayloadManager {

    Gson gson;

    //create payload by gson library
    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        Faker faker = new Faker();
        booking.setFirstname("Pramod");
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1000));
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");


        System.out.println(booking);
        // Object -> JSON String (GSON)
        Gson gson = new Gson();
        String jsonStringBooking =  gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    //create using Jackson - In Future purpose
    public void createPayloadJackSon() {

    }

    //for update folder will use separate function
    public void updatePayload() {

    }

    public String getTokenFromJSON(String string) {

        return string;
    }

    public String setAuthPayload() {
        return null;
    }
}
