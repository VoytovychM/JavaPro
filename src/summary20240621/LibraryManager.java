package summary20240621;

public class LibraryManager {

    public Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void borrowBook(int isbn, User user) {
        Book book = library.findBookByIsbn(isbn);
        if (book != null && book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            user.borrowBook(book);
        } else {
            System.out.println("Book not available");
        }

    }


    public void returnBook(int isbn, User user) {
        Book book = library.findBookByIsbn(isbn);
        if (book != null) {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            user.returnBook(book);
        } else {
            System.out.println("Book not found in the library");
        }

    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }

    public void registerUser(User user) {
        library.registerUser(user);


    }


    public static void main(String[] args) {
        Library library = new Library();
        LibraryManager libraryManager = new LibraryManager(library);

        Book book1 = new Book("Thinking, Fast and Slow", "Daniel Kahneman", 45, 2);
        Book book2 = new Book("The laws of human nature", "Robert Greene", 29, 3);
        Book book3 = new Book("Clean Code", "Robert C. Martin", 11, 1);

        libraryManager.addBook(book1);
        libraryManager.addBook(book2);
        libraryManager.addBook(book3);

        User user = new User("Masha", 1);
        libraryManager.registerUser(user);
        libraryManager.borrowBook(11, user);
        System.out.println(user.getBorrowedBooks().size());
        user.returnBook(book3);
        System.out.println(user.getBorrowedBooks().size());
        libraryManager.returnBook(11, user);
        System.out.println(user.getBorrowedBooks().size());
        libraryManager.borrowBook(29, user);

        System.out.println("Borrowed books by " + user.getName());
        for (Book borrowedBook : user.getBorrowedBooks()) {
            System.out.println(borrowedBook);
        }

        libraryManager.returnBook(29, user);
        System.out.println("List of books in the library");
        for (Book book : libraryManager.library.getBooks()) {
            System.out.println(book);
        }


    }

}

