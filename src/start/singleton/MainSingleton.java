package start.singleton;

import java.math.BigDecimal;

public class MainSingleton {
        public static void main(String[] args) {
            // классические схема Singleton
            Singleton s1 = Singleton.getInstance();
            System.out.println(s1);

            Singleton s2 = Singleton.getInstance();
            System.out.println(s2);

            // enum схема Singleton
            SingletonEnum s3 = SingletonEnum.INSTANCE.getInstance();
            System.out.println(s3 +" - "+ s3.hashCode());

            SingletonEnum s4 = SingletonEnum.INSTANCE;
            System.out.println(s4 +" - "+ s3.hashCode());

        }

}