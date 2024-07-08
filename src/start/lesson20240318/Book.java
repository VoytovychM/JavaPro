package start.lesson20240318;

import java.util.Comparator;

public class Book {

        private String title;

        private String author;

        private double price;

        private int bookCount;

        private boolean isInStock;

        public Book(String title, String author, double price, boolean isInStock, int bookCount) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.isInStock = isInStock;
            this.bookCount = bookCount;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public double getPrice() {
            return price;
        }

        public int getBookCount() {
            return bookCount;
        }

        public boolean isInStock() {
            return isInStock;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", price=" + price +
                    ", bookCount=" + bookCount +
                    ", isInStock=" + isInStock +
                    '}';
        }

        public static class BookByAuthorComparator implements Comparator<Book> {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.author.compareTo(book2.author);
            }
        }

        public static class BookByPriceComparator implements Comparator<Book> {
            @Override
            public int compare(Book book1, Book book2) {
                double price1 = book1.price;
                double price2 = book2.price;
//            return (price1 < price2 ? -1 : (price1 == price2 ? 0 : 1));
                return Double.compare(price1, price2);
            }
        }

        public static class BookByCountComparator implements Comparator<Book> {
            @Override
            public int compare(Book book1, Book book2) {
                int count1 = book1.bookCount;
                int count2 = book2.bookCount;
                return (Integer.compare(count1, count2));
//            return (count1 < count2 ? -1 : (count1 == count2 ? 0 : 1));
//            return count1 - count2;   // 1000000 - (-1000000)
            }
        }
    }

