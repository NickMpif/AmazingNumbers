package numbers;

public class HappyNumberImpl implements AmazingChecker{


    @Override
    public boolean check(long number) {
        if (number == 1 || number == 7)
            return true;
        long sum = number;
        long x = number;
        while(sum > 9) {
            sum = 0;

            // this loop finds the sum of square of digits
            while (x > 0) {
                long d = x%10;
                sum += d*d;
                x/=10;
            }
            if (sum == 1)
                return true;
            x = sum;
        }
        if(sum == 7)
            return true;
        return false;
    }
}
