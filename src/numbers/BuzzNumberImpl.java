package numbers;

public class BuzzNumberImpl implements AmazingChecker {


    @Override
    public boolean check(long number) {
        return  number % 10 == 7 || number % 7 == 0;
    }
}
