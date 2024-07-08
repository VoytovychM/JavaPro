package summary20240510;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ImageFileExample {
    private static String path = "resources/IMG_4957.JPG";
    public static void main(String[] args) throws Exception {

        BufferedImage image = ImageIO.read(new File(path));
        System.out.println(image.getHeight());
        System.out.println(image.getWidth());
        System.out.println(image.getData());

        readBinaryFile();
    }

    private static void readBinaryFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile(path, "r");

        for (int i = 0; i < 8; i++) {
            int uByte = file.readUnsignedByte();
            System.out.println(uByte + " " + Integer.toHexString(uByte) + " " + (char) uByte);
        }

        for (int i = 0; i < 8; i++) {
            int uByte = file.readUnsignedByte();
            System.out.println(uByte + " " + Integer.toHexString(uByte) + " " + (char) uByte);
        }

        System.out.println("Width: " + file.readInt());
        System.out.println("Height: " + file.readInt());
        System.out.println("Bit depth: " + file.readUnsignedByte());
        System.out.println("Colour type: " + file.readUnsignedByte());
        System.out.println("Compression method: " + file.readUnsignedByte());
        System.out.println("Filter method: " + file.readUnsignedByte());
        System.out.println("Interlace method: " + file.readUnsignedByte());

        file.close();
    }


}