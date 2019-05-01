package com.kshrd.controllers;

import com.kshrd.views.SMSView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SMSView smsView = new SMSView();
        smsView.display();
    }
}
