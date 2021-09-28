package numbers;

public class OddNumberImpl implements AmazingChecker {
    @Override
    public boolean check(long number) {
        return number % 2 != 0;
    }
}
