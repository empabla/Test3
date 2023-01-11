package pl.kurs.zadanie3.app;

public class FibonacciRunner {
    public static void main(String[] args) {

        System.out.println("getFibonacciIndex(-10) = " + getFibonacciIndex(-10));
        System.out.println("getFibonacciIndex(1) = " + getFibonacciIndex(1));
        System.out.println("getFibonacciIndex(2) = " + getFibonacciIndex(2));
        System.out.println("getFibonacciIndex(5) = " + getFibonacciIndex(5));
        System.out.println("getFibonacciIndex(8) = " + getFibonacciIndex(8));
        System.out.println("getFibonacciIndex(377) = " + getFibonacciIndex(377));
        System.out.println("getFibonacciIndex(123456789) = " + getFibonacciIndex(123456789));

    }

    public static int getFibonacciIndex(int number) {
        if (number == 1) return 1;
        if (number == 2) return 2;

        int element1 = 1;
        int element2 = 2;
        int index = 3;
        while (element2 <= number) {
            int temp = element1;
            element1 = element2;
            element2 = temp + element2;
            if (element2 == number)
                return index;
            index++;
        }
        return -1;
    }

}
