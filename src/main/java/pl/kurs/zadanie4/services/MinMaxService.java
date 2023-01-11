package pl.kurs.zadanie4.services;

import pl.kurs.zadanie4.models.MinMax;

import java.util.List;

public class MinMaxService {

    public static <T extends Comparable> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements.isEmpty())
            throw new IllegalArgumentException("List must contain at least one element");
        T min = elements.get(0);
        T max = elements.get(0);
        for (T e : elements)
            if (e != null) {
                if (e.compareTo(min) < 0)
                    min = e;
                if (e.compareTo(max) > 0)
                    max = e;
            }
        return new MinMax<>(min, max);
    }

}