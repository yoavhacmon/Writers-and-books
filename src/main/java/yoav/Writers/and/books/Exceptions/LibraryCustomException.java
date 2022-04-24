package yoav.Writers.and.books.Exceptions;

public class LibraryCustomException extends Exception{

    public LibraryCustomException(){
        super("Book/Author not found");
    }

    public LibraryCustomException(String massage){
        super(massage);
    }
}
