import controller.NumberControl;
import utils.PrintUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        PrintUtils.Description();
        System.out.println();
        NumberControl.handle();
    }
}