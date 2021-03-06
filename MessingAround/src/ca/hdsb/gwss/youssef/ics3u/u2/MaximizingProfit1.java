/*
 * Name: Youssef Mohamed
 * Date: 3rd Mar 2017
 * Version: 1.0
 * Description:
 *      This program maximizes your profit
 */
package ca.hdsb.gwss.youssef.ics3u.u2;

//Organizing imports
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Youss
 */
public class MaximizingProfit1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initializing Variables
        double originalCost = 0;
        double numberOfSales = 0;
        double salesLost = 0;
        double deductionChunk = 0;
        double root1;
        double root2;
        double profit;
        double vertex;
        boolean check = false;

        //Formatting decimals that end with .0 so that it won't include the .0
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        //Initializing scanner for user input
        Scanner read = new Scanner(System.in);

        /*
        * Welcome text made HUGE!
        * want to make some for yourself?
        * http://patorjk.com/software/taag/Op=display&f=Epic&t=YOUSSEF
         */
        System.out.println(" __  __                          __  __       _             _ \n"
                + "|  \\/  | ___  _ __   ___ _   _  |  \\/  | __ _| | _____ _ __| |\n"
                + "| |\\/| |/ _ \\| '_ \\ / _ \\ | | | | |\\/| |/ _` | |/ / _ \\ '__| |\n"
                + "| |  | | (_) | | | |  __/ |_| | | |  | | (_| |   <  __/ |  |_|\n"
                + "|_|  |_|\\___/|_| |_|\\___|\\__, | |_|  |_|\\__,_|_|\\_\\___|_|  (_)\n"
                + "                         |___/                                \n");
        System.out.println("I can find out how to maximize your profit! \n");

        //while loop that waits until check = true.
        while (!check) {
            try {
                //Starts off by asking the question.
                System.out.format("%86s ", "How much does your product cost?");
                //program expects double.
                originalCost = read.nextDouble();
                    check = true;
                //if the user does not enter a number, the program will catch that error.
            } catch (InputMismatchException e) {
                check = false;
                System.out.println("Sorry, you entered an invalid value");
                System.err.println(e);
                read.next();
            }
        }

        //same while loop structure for next double
        check = false;
        while (!check) {
            try {
                System.out.format("%86s ", "How many sales do you get with that cost?");
                numberOfSales = read.nextDouble();
                if (numberOfSales == 0) {
                    System.out.println("I will not have a trend to follow.");
                    System.out.format("%86s ", "How many sales do you get with that cost?");
                    read.next();
                } else {
                    check = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, you entered an invalid value");
                System.err.println(e);
                read.next();
            }
        }

        //next while loop for next double
        check = false;
        while (!check) {
            try {
                System.out.print("For your 'price increase to sales lost trend',"
                        + " how much are you changing your cost by? ");
                deductionChunk = read.nextDouble();
                if (deductionChunk == 0) {
                    System.out.println("I will not have a trend to follow.");
                    System.out.print("For your 'price increase to sales lost trend',"
                            + " how much are you changing your cost by? ");
                    read.next();
                } else {
                    check = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, you entered an invalid value");
                System.err.println(e);
                read.next();
            }
        }

        //final while loop for final double
        check = false;
        while (!check) {
            try {
                System.out.format("%86s ", "How many sales do you predict to lose for every "
                        + "increase of $" + String.format(format.format(deductionChunk))
                        + "?");
                salesLost = read.nextDouble();
                if (salesLost == 0) {
                    System.out.format("%86s ", "I will not have a trend to follow.");
                    System.out.format("%86s ", "How many sales do you predict to lose for every "
                            + "increase of $" + String.format(format.format(deductionChunk))
                            + "?");
                    read.next();
                } else {
                    check = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry, you entered an invalid value");
                System.err.println(e);
                read.next();
            }
        }

        //calculating best possible cost for most profit
        root1 = (numberOfSales / salesLost);
        root2 = (originalCost / -deductionChunk);
        vertex = (root1 + root2) / 2;
        profit = (numberOfSales - salesLost * vertex)
                * (originalCost + deductionChunk * vertex);

        /*if the data the user entered forces the best possible cost to be negative
         * the program will repeat what the user has given, for best possible profit.
         */
        if (vertex <= 0) {
            System.err.println("Something is wrong with this trend.");
            System.out.println("You should sell your product for $" + originalCost);

            System.out.println("You will make $"
                    + String.format("%.2f", originalCost * numberOfSales));

            System.out.println("This can be modeled with the quadratic equation f(x) = ("
                    + format.format(numberOfSales) + "-" + format.format(salesLost)
                    + "n" + ")" + "(" + format.format(originalCost) + "+"
                    + format.format(deductionChunk) + "n" + ")");

            System.out.println("Keep in mind all the numbers in the model "
                    + "equation that have more than 2 decimal places were rounded "
                    + "down to 2 decimal places for easier reading.");
        } else {
            System.out.println("You should sell your product for $"
                    + String.format("%.2f", vertex));

            System.out.println("You will make $" + String.format("%.2f", profit));

            System.out.println("This can be modeled with the quadratic equation f(x) = ("
                    + format.format(numberOfSales) + "-" + format.format(salesLost)
                    + "n" + ")" + "(" + format.format(originalCost) + "+"
                    + format.format(deductionChunk) + "n" + ")");

            System.out.println("Keep in mind all the numbers that have more "
                    + "than 2 decimal places were rounded down to 2 decimal "
                    + "places for easier reading.");
        }
    }

}
