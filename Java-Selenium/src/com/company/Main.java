package com.company;

import testcase.BE002LoginToPageUnsuccessfully;
import testcase.BE004CreateNewHotelSuccessfully;
import testcase.FE009VerifyRevisionAndPament;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // write your code here
        BE002LoginToPageUnsuccessfully tcBE002 = new BE002LoginToPageUnsuccessfully();
        tcBE002.loginUnsuccessfully();

        BE004CreateNewHotelSuccessfully tcBE004 = new BE004CreateNewHotelSuccessfully();
        tcBE004.createHotel();

        FE009VerifyRevisionAndPament tc009 = new FE009VerifyRevisionAndPament();
        tc009.verifyRevisionAndPayment();
    }
}