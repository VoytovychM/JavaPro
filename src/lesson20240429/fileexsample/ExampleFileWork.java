package lesson20240429.fileexsample;

import java.io.File;

public class ExampleFileWork {
    public static void main(String[] args) {
        String pathToFile = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/custom/fileCopy.txt";
       File file =  new File(pathToFile);
       boolean exists = file.exists();
        System.out.println("File exists " + exists);

//        Create dir
        String pathDir = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/fileexsample/newdir";
        file =new File(pathDir);
        boolean created = file.mkdir();
        System.out.println("Is created" + created);

        // Get length

        String pathToRealFile = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/custom/fileCopy.txt";
        file = new File(pathToRealFile);
        System.out.println("Length = " + file.length());


        //4.Delete file
        String pathToDelete = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/custom/fileCopy.txt";
        file = new File(pathToDelete);
        boolean delete = file.delete();
        System.out.println("Is deleted " + delete);

        //5.Check that it is directory
        file = new File(pathDir);
        System.out.println("Is directory " + file.isDirectory());
        //6.Get all file names
        String pathToAllFiles = "//Users/maria/IdeaProjects/JavaPro/src/lesson20240429/fileexsample";
        file = new File(pathToAllFiles);
        String[] list = file.list();
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println();

        //7.Get all files in directory
        file = new File(pathToAllFiles);
        File[] files = file.listFiles();
        for (File currentFile : files) {
            String name = currentFile.getName();
            long length = currentFile.length();
            System.out.printf("File with name %s, has length %d\n", name, length);
        }

    }
}
