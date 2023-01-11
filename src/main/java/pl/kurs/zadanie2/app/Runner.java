package pl.kurs.zadanie2.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

public class Runner {
    public static void main(String[] args) {

        File directory = new File("C:/Users/User/IdeaProjects");
        printFilesQtyPerDayOfWeekInfo(directory);

//        Result:
//        MONDAY -> 29
//        TUESDAY -> 74
//        WEDNESDAY -> 19
//        THURSDAY -> 56
//        FRIDAY -> 35
//        SATURDAY -> 48
//        SUNDAY -> 45

    }

    public static void printFilesQtyPerDayOfWeekInfo(File directory) {
        if (!directory.exists()) {
            throw new IllegalArgumentException("Provided directory does not exist.");
        }
        int[] filesQtyPerDay = new int[7];
        collectFilesQtyData(directory, filesQtyPerDay);
        for (DayOfWeek day : DayOfWeek.values())
            System.out.println(day + " -> " + filesQtyPerDay[day.ordinal()]);
    }

    private static void collectFilesQtyData(File directory, int[] filesQtyPerDay) {
        File[] files = directory.listFiles();
        if (files == null)
            System.out.println("Provided directory is empty!");
        for (File f : files)
            if (f.isDirectory())
                collectFilesQtyData(f, filesQtyPerDay);
            else if (f.getName().endsWith("java")) {
                DayOfWeek dayOfWeek = getDayOfWeekFromFile(Paths.get(f.getAbsolutePath()));
                filesQtyPerDay[dayOfWeek.ordinal()]++;
            }
    }

    private static DayOfWeek getDayOfWeekFromFile(Path filePath) {
        try {
            BasicFileAttributes bfa = Files.readAttributes(filePath, BasicFileAttributes.class);
            FileTime ft = bfa.creationTime();
            LocalDate ld = LocalDate.ofInstant(ft.toInstant(), ZoneId.of("UTC"));
            return ld.getDayOfWeek();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}