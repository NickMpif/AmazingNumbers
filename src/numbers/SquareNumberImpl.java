package numbers;

public class SquareNumberImpl implements AmazingChecker{
    @Override
    public boolean check(long number) {
        double sqrt = (double) Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}
