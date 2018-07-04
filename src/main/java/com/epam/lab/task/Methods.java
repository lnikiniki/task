package com.epam.lab.task;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Methods {
    private static final Logger LOG = Logger.getLogger(com.epam.lab.task.Methods.class);

    static int sumCount(int number) {
        int sum = number;
        if (number > 0)
            return sum + sumCount(number - 1);
        else return sum;
    }

    static void countNumbers() {
        Scanner scanner = new Scanner(System.in);
        int count = -1;
        double sum = 0;
        int number;
        double arithmeticMean = 0;
        int retry = 25;
        do {
            number = scanner.nextInt();
            sum += number;
            count++;
            retry--;
        } while (number != 0 || retry == 0);
        arithmeticMean = sum / count;
        LOG.info(String.format("Count of numbers = %s\nTotal sum = %s\nArithmetic mean = %s", count, sum, arithmeticMean));
    }

    static void dividingResidue() {
        LOG.info("Numbers which give residue 1, 2 or 5 during dividing by 7:");
        for (int i = 35; i < 87; i++) {
            if (i % 7 == 1 || i % 7 == 2 || i % 7 == 5) {
                LOG.info(i);
            }
        }
    }

    static int countEvenDigits(int number) {
        int count = 0;
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            int digit = numberString.charAt(i) - '0';
            if (digit % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static int findLargestDigit(int number) {
        int max = 0;
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            int digit = numberString.charAt(i) - '0';
            if (digit > max) {
                max = digit;
            }
        }
        return max;
    }

    static void showNumbers() throws WrongLastNumberException {
        Scanner scanner = new Scanner(System.in);
        LOG.info("Enter the first number: ");
        int first = scanner.nextInt();
        LOG.info("Enter the last number: ");
        int last = scanner.nextInt();
        if(last<=first){
            throw new WrongLastNumberException("Last number should be bigger.");
        }
        int oddSum = 0, evenSum = 0, oddCount = 1;
        double percentageOdd, percentageEven;
        int F1 = (last % 2 != 0) ? last : last - 1;
        int F2 = (last % 2 == 0) ? last : last - 1;
        LOG.info("Odd numbers from start to the end:");
        for (int i = first, j = last; i <= last; i++, j--) {
            if (i % 2 != 0) {
                System.out.println(i);
                oddSum += i;
            }
        }
        LOG.info(String.format("Sum of odd numbers = %s\nEven numbers from the end to start:", oddSum));
        for (int i = last; i >= first; i--) {
            if (i % 2 == 0) {
                System.out.println(i);
                evenSum += i;
            }
        }
        LOG.info(String.format("Sum of even numbers = %s\nEnter the size of set: ", evenSum));
        double size = scanner.nextInt();
        LOG.info(String.format("Fibonacci numbers:\n%s\n%s", F1, F2));
        for (int i = 0; i < size - 2; i++) {
            LOG.info(F1 + F2);
            if ((F1 + F2) % 2 != 0)
                oddCount++;
            int temp = F1;
            F1 = F2;
            F2 += temp;
        }
        percentageOdd = oddCount / size * 100;
        percentageEven = 100 - percentageOdd;
        LOG.info(String.format("Percentage of odd numbers = %s\nPercentage of even numbers = %s", percentageOdd, percentageEven));
    }
}
