package org.example;
/*
    This is the runner class for the independent task runner
    meant to test the functionality of the framework built.

    @Author Suraj yadav
*/

import org.example.ApiService.ApiRequestHandler;

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("****************** Starting the TestRunner ******************");
        new ApiRequestHandler().handler();
        System.out.println("****************** ShuttingDown TestRunner ******************");
    }
}
