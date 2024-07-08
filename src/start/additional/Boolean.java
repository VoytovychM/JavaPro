package start.additional;

public class Boolean {

    static boolean bDef;
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(bDef);
        boolean b3 = !b1;
        System.out.println(b3);
        int int1 = 0;
        boolean b4 = (int1 != 0);
        System.out.println(b4);

        String sBoolean = "true";
        boolean parsed = java.lang.Boolean.parseBoolean(sBoolean);
        System.out.println(parsed);

    }
}
