package practice20240513.jackson;

import com.fasterxml.jackson.dataformat.protobuf.ProtobufMapper;
import com.fasterxml.jackson.dataformat.protobuf.schema.ProtobufSchema;

public class ProtobufMain {
    public static void main(String[] args) throws Throwable {
        ProtobufMapper om = new ProtobufMapper();
        ProtobufSchema schema = om.generateSchemaFor(Person.class);

        Person person = new Person("Вася", "Пупкин",
                new Address(7, "Н", "Бассейная"));
        byte[] bytes = om.writer(schema).writeValueAsBytes(person);

        System.out.println(new String(bytes));

        // десериализация
        Person read = om.readerFor(Person.class)
                .with(schema)
                .readValue(bytes);
        System.out.printf("Read person: %s\n", read);
    }
}

