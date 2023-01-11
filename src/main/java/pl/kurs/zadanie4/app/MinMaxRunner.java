package pl.kurs.zadanie4.app;

import pl.kurs.zadanie4.services.MinMaxService;

import java.util.ArrayList;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(-12);
        integers.add(null);
        integers.add(222);
        integers.add(-22);
        integers.add(12);
        integers.add(0);

        System.out.println("getMinAndMax(integers) = " + MinMaxService.getMinAndMax(integers));
        System.out.println("getMinAndMax(integers).getMin() = " + MinMaxService.getMinAndMax(integers).getMin());

        List<String> strings = new ArrayList<>();
        strings.add("Lolek");
        strings.add("Bolek");
        strings.add("Antek");
        strings.add("Rysiek");
        strings.add("Zosia");
        strings.add("Krysia");
        System.out.println("getMinAndMax(strings) = " + MinMaxService.getMinAndMax(strings));
        System.out.println("getMinAndMax(strings).getMax() = " + MinMaxService.getMinAndMax(strings).getMax());

    }
}
