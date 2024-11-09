package org.example.tests.crud;

import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TCcreateBooking extends BaseTest {//we will inherit(inheritance used) from BaseTest
    // Step1 - POST
    // URL -> Base URI + base Path
    // HEADER
    // BODY
    // Auth - NO


    // Step 2
    // prepare the Payload ( Object -> JSON String)
    // send the request

    //Step 3
    // Validate Response ( JSON String -> Object)
    // FirstName,
    // Status Code
    // Time Response

    @Test
    public void testPositivePostReq() {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(200);
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));

        // DeSer
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Pramod");

        // TestNG Assertions
        assertActions.verifyStatusCode(response,200);

    }
}
