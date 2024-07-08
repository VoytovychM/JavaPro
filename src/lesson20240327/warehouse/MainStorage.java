package lesson20240327.warehouse;

public class MainStorage {
    public static void main(String[] args) {
        BrickPack brickPack1 = new BrickPack(1, 1000);
        BrickPack brickPack2 = new BrickPack(2, 2000);
        BrickPack brickPack3 = new BrickPack(3, 1500);
        BrickPack brickPack4 = new BrickPack(4, 1000);
        BrickPack brickPack5 = new BrickPack(5, 2000);
        BrickPack brickPack6 = new BrickPack(6, 1500);
        BrickPack brickPack7 = new BrickPack(7, 1000);
        BrickPack brickPack8 = new BrickPack(8, 1200);

        // === Склад с одной дверью ===
        StorageStack storage = new StorageStack(5);

        //Завозим на склад
        storage.storagePush(brickPack1);
        storage.storagePush(brickPack2);
        storage.storagePush(brickPack3);
        storage.storagePush(brickPack4);
        storage.storagePush(brickPack5);
        storage.storagePush(brickPack6);
        storage.print();

        // посмотрим какая паллета первая на отгрузку
        System.out.println(storage.storagePeek());
        storage.print();

        // отгружаем паллету
        System.out.println(storage.storagePop());
        storage.print();
        System.out.println(storage.storagePeek());

        // === Склад с двумя дверьми ===
        StorageQueue storage2 = new StorageQueue(5);

        //Завозим на склад
        storage2.storagePush(brickPack1);
        storage2.storagePush(brickPack2);
        storage2.storagePush(brickPack3);
        storage2.storagePush(brickPack4);
        storage2.storagePush(brickPack5);
        storage2.print();

        // посмотрим какая паллета первая на отгрузку
        System.out.println(storage2.storagePeek());
        storage2.print();

        // отгружаем паллету
        System.out.println(storage2.storagePoll());
        storage2.print();
    }
}

