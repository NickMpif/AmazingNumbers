package numbers;

public class NumberJumpingImpl implements AmazingChecker{

    @Override
    public boolean check(long number) {
        while(number != 0) {
            long digit1 = number % 10;
            number = number / 10;
            if (number != 0) {
                long digit2 = number % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
