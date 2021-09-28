package numbers;

public class SpyNumberImpl implements AmazingChecker {

    @Override
    public boolean check(long number) {
        long temp = number;
        long sum = 0;
        long product = 1;
        while (temp != 0) {
            sum += temp % 10;
            product *= temp % 10;
            temp /= 10;
        }

        return sum == product;
    }
}
