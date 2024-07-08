package summary20240621;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }
    public void registerUser(User user){
        users.add(user);
    }
    public Book findBookByIsbn(int isbn){
       return books.stream().filter(book -> book.getIsbn()== isbn).findFirst().orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }
}
