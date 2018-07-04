package com.epam.lab.task;

import java.util.Scanner;

import static com.epam.lab.task.Methods.*;

public class Main {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOG.info("Enter the number: ");
        int enteredNumber = scanner.nextInt();
        LOG.info(String.format("Sum of numbers = %s", sumCount(enteredNumber)));
        LOG.info("Enter the numbers (0 to stop): ");
        countNumbers();
        dividingResidue();
        LOG.info("Enter the number: ");
        enteredNumber = scanner.nextInt();
        LOG.info(String.format("Count of even digits = %s", countEvenDigits(enteredNumber)));
        LOG.info(String.format("The largest digit = %s", findLargestDigit(enteredNumber)));
        try {
            showNumbers();
        } catch (WrongLastNumberException e) {
            e.printStackTrace();
            LOG.error("Wrong last number.");
        }
    }
}
