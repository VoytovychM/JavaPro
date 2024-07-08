package lesson20240429.custom;

public class FileCopyApp {
    public static void main(String[] args) {
//        String pathFrom = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/custom/fileFromCopy.txt";
        String pathFrom = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/file.txt";
        String pathTo = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/custom/fileToCopy.txt";
      FileWorkUtil.copy(pathFrom, pathTo);
    }
}
