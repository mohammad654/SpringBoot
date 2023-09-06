package com.workshop.june8.basic;

public class EmailHandler {
    private int sent = 0;

    public void sendMail(String message, String emailAddress) throws Exception {

        if (emailAddress.indexOf("@") < 0) {
            throw new Exception("Not a valid email address");
        }
        sent++;
        // Send the email id '@' is in the emailaddress
    }

    public int getSent() {
        return sent;
    }

}
