package start.summary;

public class CastExamples {
    public static void main(String[] args) {
        int i = 10000;
        long j = i;
        byte k = (byte) i;
        System.out.println(k);

        long l = 100000001;
        i = (int) l;
        System.out.println(i);
    }
}
