package pl.kurs.zadanie1.app;

import java.io.File;

public class Runner {
    public static void main(String[] args) {

        File directory = new File("C:/Users/User/IdeaProjects");
        findTheLargestJavaFile(directory);

//        The largest java file = Homework1.java. Size = 12827 bytes.

    }

    public static void findTheLargestJavaFile(File directory) {
        if (!directory.exists())
            throw new IllegalArgumentException("Provided directory does not exist.");
        File largestJavaFile = getTheLargestJavaFile(directory);
        if (largestJavaFile != null)
            System.out.println("The largest java file = " + largestJavaFile.getName() + ". " +
                    "Size = " + largestJavaFile.length() + " bytes.");
        else
            System.out.println("There are no java files in provided directory!");
    }

    private static File getTheLargestJavaFile(File directory) {
        File[] files = directory.listFiles();
        if (files == null)
            System.out.println("Provided directory is empty!");
        File largestJavaFile = null;
        long largestFileSize = 0;
        for (File f : files)
            if (f.isDirectory()) {
                File temp = getTheLargestJavaFile(f);
                if (temp != null && temp.length() > largestFileSize) {
                    largestJavaFile = temp;
                    largestFileSize = temp.length();
                }
            } else if (f.getName().endsWith("java")) {
                if (f.length() > largestFileSize) {
                    largestJavaFile = f;
                    largestFileSize = f.length();
                }
            }
        return largestJavaFile;
    }

}

