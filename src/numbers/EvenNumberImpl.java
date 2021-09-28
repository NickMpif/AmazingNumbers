package numbers;

public class EvenNumberImpl implements AmazingChecker {

    @Override
    public boolean check(long number) {
        return number % 2 == 0;
    }
}
