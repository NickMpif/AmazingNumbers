package controller;

import numbers.*;
import utils.PrintUtils;

import java.util.*;

public class NumberControl {
    public static String buzz = "BUZZ";
    public static String duck = "DUCK";
    public static String gapful = "GAPFUL";
    public static String even = "EVEN";
    public static String sunny = "SUNNY";
    public static String square = "SQUARE";
    public static String odd = "ODD";
    public static String spy = "SPY";
    public static String palindromic = "PALINDROMIC";
    public static String jumping = "JUMPING";
    public static String happy = "HAPPY";

    private final static Map<String, AmazingChecker> amazingMap = new HashMap<>();
    private final static Map<String, Boolean> amazingResult = new HashMap<>();

    static {
        amazingMap.put(buzz, new BuzzNumberImpl());
        amazingMap.put(duck, new DuckNumberImpl());
        amazingMap.put(gapful, new GapfulNumberImpl());
        amazingMap.put(even, new EvenNumberImpl());
        amazingMap.put(odd, new OddNumberImpl());
        amazingMap.put(spy, new SpyNumberImpl());
        amazingMap.put(palindromic, new PalindromicNumberImpl());
        amazingMap.put(sunny, new SunnyNumberImpl());
        amazingMap.put(square, new SquareNumberImpl());
        amazingMap.put(jumping, new NumberJumpingImpl());
        amazingMap.put(happy, new HappyNumberImpl());
    }

    public static void handle() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a request: ");
            String guess = scanner.nextLine();

            int length = guess.length();
            if (length == 0) {
                PrintUtils.Description();
                handle();
            }
            String[] properties = guess.split(" ");
            long number = Long.parseLong(properties[0]);
            if (number == 0) {
                System.out.println("Goodbye!");
                return;
            } else if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                handle();
                return;
            }
            for (String key : amazingMap.keySet()) {
                amazingResult.put(key, amazingMap.get(key).check(number));
            }

            if (properties.length == 1) {
                PrintUtils.checkΟneNumber(amazingResult, number);
                handle();
                return;
            } else if (properties.length == 2) {
                long range = Long.parseLong(properties[1]);
                if (range < 0) {
                    System.out.println("The second parameter should be a natural number.");
                    handle();
                    return;
                }
                String ans = PrintUtils.checkTwoNumbers(amazingMap, amazingResult, number, range);
                System.out.println(ans);
                handle();
                return;
            } else if (properties.length > 2) {
                long range = Long.parseLong(properties[1]);
                String[] property = new String[properties.length - 2];

                for (int i = 2; i < properties.length; i++) {
                    property[i - 2] = properties[i];
                }
                if (!PrintUtils.checkProperty(property)){
                    handle();
                    return;
                }
                 else {
                    PrintUtils.checkNumberWithProperties(amazingMap, amazingResult, number, range, property);
                    handle();
                    return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("The first parameter should be a natural number or zero.");
            handle();
            return;
        }
    }
}