package numbers;

public class SunnyNumberImpl implements AmazingChecker{

    @Override
    public boolean check(long number) {
        if (Math.sqrt(number + 1) % 1 == 0)
            return true;
        return false;
    }
}
