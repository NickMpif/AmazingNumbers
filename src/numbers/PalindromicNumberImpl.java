package numbers;

public class PalindromicNumberImpl implements AmazingChecker {

    @Override
    public boolean check(long number) {
        long reverseNumber = reverseDigits(number);
        long numberOfDigits = String.valueOf(number).length();
        if (numberOfDigits != 1) {
            if (number == reverseNumber) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private static long reverseDigits(long number) {
        long reverseNumber = 0L;
        while (number > 0) {
            reverseNumber = reverseNumber * 10 + number % 10;
            number = number / 10;
        }
        return reverseNumber;
    }
}
