package ua.goit.homeworkhibernate.exceptions;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
