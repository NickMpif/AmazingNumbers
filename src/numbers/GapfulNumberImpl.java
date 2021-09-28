package numbers;

public class GapfulNumberImpl implements AmazingChecker {

    @Override
    public boolean check(long number) {
        int length = String.valueOf(number).length();
        return length >= 3 && number % (number % 10 + (int) (number / Math.pow(10, length - 1)) * 10) == 0;
    }
}
