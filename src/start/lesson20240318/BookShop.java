package start.lesson20240318;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookShop {
    public static void main(String[] args) {

        Book book1= new Book("Anna Karenina", "Tolstoy",45, true,1 );
        Book book2 = new Book("Harry Potter 2", "Rawling", 15.0, true, 12);
        Book book3 = new Book("War and Peace", "Tolstoy", 50.0, false, 34);
        Book book4 = new Book("Crime and Punishment", "Dostoewsky", 25.0, true, 12);
        Book book5 = new Book("Tom Sawyer", "Mark Twain", 18.0, true, 23);
        Book book6 = new Book("Harry Potter 3", "Rawling", 15.0, true, 55);
        Book book7 = new Book("Harry Potter 4", "Rawling", 15.0, true, 1);
        List<Book> bookList = Arrays.asList(book1, book2, book3, book4, book5, book6, book7);

        Collections.sort(bookList, new Book.BookByAuthorComparator()); // merge sort -- stable -- устойчивая
        System.out.println("Books in shop by Author:");
        for (Book book : bookList){
            System.out.println(book);
        }

        System.out.println("Books in shop by Price:");
        Collections.sort(bookList, new Book.BookByPriceComparator());
        for (Book book : bookList){
            System.out.println(book);
        }

        System.out.println("Books in shop by Count:");
        Collections.sort(bookList, new Book.BookByCountComparator());
        for (Book book : bookList){
            System.out.println(book);
        }

        System.out.println("Books in shop by Price: Max - Min:");
        Collections.sort(bookList, new Book.BookByPriceComparator().reversed());
        for (Book book : bookList){
            System.out.println(book);
        }

        // sort by author, price
        System.out.println("Books in shop, sort by author, price:");
        Collections.sort(bookList, new Book.BookByPriceComparator());
        Collections.sort(bookList, new Book.BookByAuthorComparator());
        for (Book book : bookList){
            System.out.println(book);
        }

        // sort by author, price with anonymous comparator
        System.out.println("Books in shop, sort by author, price with anonymous comparator:");
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                int result = book1.getAuthor().compareTo(book2.getAuthor());
                if (result == 0) {
                    result = Double.compare(book1.getPrice(), book2.getPrice());
                }
                return result;
            }
        });

        for (Book book : bookList){
            System.out.println(book);
        }
    }


}

