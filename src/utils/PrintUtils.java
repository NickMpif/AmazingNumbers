package utils;

import controller.NumberControl;
import numbers.AmazingChecker;

import java.sql.Array;
import java.util.*;

public class PrintUtils {

    public static void Description() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public static void checkΟneNumber(Map<String, Boolean> amazingResults, long number) {
        System.out.println("Properties of " + number);
        System.out.println("\t\tbuzz: " + amazingResults.get(NumberControl.buzz));
        System.out.println("\t\tduck: " + amazingResults.get(NumberControl.duck));
        System.out.println(" palindromic: " + amazingResults.get(NumberControl.palindromic));
        System.out.println("\t  gapful: " + amazingResults.get(NumberControl.gapful));
        System.out.println("\t\t spy: " + amazingResults.get(NumberControl.spy));
        System.out.println("\t  square: " + amazingResults.get(NumberControl.square));
        System.out.println("\t   sunny: " + amazingResults.get(NumberControl.sunny));
        System.out.println("\t jumping: " + amazingResults.get(NumberControl.jumping));
        System.out.println("\t\teven: " + amazingResults.get(NumberControl.even));
        System.out.println("\t\t odd: " + amazingResults.get(NumberControl.odd));
        System.out.println("\t\t sad: " + !amazingResults.get(NumberControl.happy));
        System.out.println("\t   happy: " + amazingResults.get(NumberControl.happy));
    }

    public static String checkTwoNumbers(Map<String, AmazingChecker> AmazingMap, Map<String, Boolean> AmazingResults, long number, long range) {
        StringBuilder sb = new StringBuilder();
        for (long i = number; i < number + range; i++) {
            sb.append(theNumbersIs(AmazingMap, AmazingResults, i));
            sb.append("\n");
        }
        return sb.toString();
    }
    public static Boolean checkProperty(String[] parameters) {
        String avail = "BUZZ DUCK PALINDROMIC GAPFUL SPY SQUARE SUNNY EVEN ODD JUMPING HAPPY SAD " +
                "-BUZZ -DUCK -PALINDROMIC -GAPFUL -SPY -SQUARE -SUNNY -EVEN -ODD -JUMPING -HAPPY -SAD";
        boolean check = true;
        ArrayList<String> accountExcl = new ArrayList<>();
        ArrayList<String> properties = new ArrayList<>();
        for (String parameter : parameters) {
            String sBig = parameter.toUpperCase(Locale.ROOT);
            if (!avail.contains(sBig)) {
                properties.add(sBig);
            } else {
                accountExcl.add(sBig);
            }
        }
        if (properties.size() > 1) {
            System.out.println("The properties " + properties + " are wrong.\n" +
                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n");
            check = false;
        } else if (properties.size() == 1) {
            System.out.println("The property " + properties + " is wrong.\n" +
                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n");
            check = false;
        } else if (accountExcl.size() > 1) {
            if (accountExcl.contains("EVEN") && accountExcl.contains("ODD")) {
                System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("-EVEN") && accountExcl.contains("-ODD")) {
                System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("-EVEN") && accountExcl.contains("-EVEN")) {
                System.out.println("The request contains mutually exclusive properties: [-EVEN, -EVEN]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("-ODD") && accountExcl.contains("-ODD")) {
                System.out.println("The request contains mutually exclusive properties: [-ODD, -ODD]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("HAPPY") && accountExcl.contains("SAD")) {
                System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("-HAPPY") && accountExcl.contains("-SAD")) {
                System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("HAPPY") && accountExcl.contains("-HAPPY")) {
                System.out.println("The request contains mutually exclusive properties: [HAPPY, -HAPPY]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("SAD") && accountExcl.contains("-SAD")) {
                System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("DUCK") && accountExcl.contains("-DUCK")) {
                System.out.println("The request contains mutually exclusive properties: [DUCK, -DUCK]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("DUCK") && accountExcl.contains("SPY")) {
                System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("SPY") && accountExcl.contains("-SPY")) {
                System.out.println("The request contains mutually exclusive properties: [SPY, -SPY]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("SUNNY") && accountExcl.contains("SQUARE")) {
                System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("SUNNY") && accountExcl.contains("-SUNNY")) {
                System.out.println("The request contains mutually exclusive properties: [SUNNY, -SUNNY]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            } else if (accountExcl.contains("SQUARE") && accountExcl.contains("-SQUARE")) {
                System.out.println("The request contains mutually exclusive properties: [SQUARE, -SQUARE]\n" +
                        "There are no numbers with these properties.\n");
                check = false;
            }
        }
        return check;
    }

    public static void checkNumberWithProperties(Map<String, AmazingChecker> AmazingMap, Map<String, Boolean> AmazingResults, long n1, long n2, String[] property) {
        for (String key : AmazingMap.keySet()) {
            AmazingResults.put(key, AmazingMap.get(key).check(n1));
        }
        long k = 0;
        long n2Counter = n2;
        String result;
        for (long i = 0; i < n2Counter; i++) {
            boolean check = true;
            String str = theNumbersIs(AmazingMap, AmazingResults, n1);
            for (String properties : property) {
                if (properties.startsWith("-")) {
                    if (str.contains(properties.replace("-", "").toLowerCase())) {
                        check = false;
                        break;
                    }
                } else {
                    if (!str.contains(properties.toLowerCase())) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                result = (theNumbersIs(AmazingMap, AmazingResults, n1));
                System.out.println(result);
                k++;
            }
            if (k == n2) {
                break;
            } else {
                n2Counter++;
            }
            n1++;
        }
    }

    public static String theNumbersIs(Map<String, AmazingChecker> AmazingMap, Map<String, Boolean> AmazingResults, long number) {
        StringBuilder sb = new StringBuilder(number + " is ");
        for (String key : AmazingMap.keySet()) {
            AmazingResults.put(key, AmazingMap.get(key).check(number));
        }
        if (AmazingResults.get(NumberControl.buzz)) {
            sb.append("buzz, ");
        }
        if (AmazingResults.get(NumberControl.duck)) {
            sb.append("duck, ");
        }
        if (AmazingResults.get(NumberControl.palindromic)) {
            sb.append("palindromic, ");
        }
        if (AmazingResults.get(NumberControl.gapful)) {
            sb.append("gapful, ");
        }
        if (AmazingResults.get(NumberControl.spy)) {
            sb.append("spy, ");
        }
        if (AmazingResults.get(NumberControl.square)) {
            sb.append("square, ");
        }
        if (AmazingResults.get(NumberControl.sunny)) {
            sb.append("sunny, ");
        }
        if (AmazingResults.get(NumberControl.jumping)) {
            sb.append("jumping, ");
        }
        if (AmazingResults.get(NumberControl.even)) {
            sb.append("even, ");
        }
        if (AmazingResults.get(NumberControl.odd)) {
            sb.append("odd, ");
        }
        if (AmazingResults.get(NumberControl.happy)) {
            sb.append("happy");
        } else {
            sb.append(("sad"));
        }
        return sb.toString();
    }
}
