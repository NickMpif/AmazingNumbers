package numbers;

public class DuckNumberImpl implements AmazingChecker {


    @Override
    public boolean check(long number) {
        long temp = number;
        while (temp != 0) {
            if (temp % 10 == 0) {
                return true;
            }
            temp /= 10;
            if (temp < 0) {
                return false;
            }
        }
        return false;
    }
}
