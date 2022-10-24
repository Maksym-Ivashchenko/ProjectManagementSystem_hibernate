package ua.goit.homeworkhibernate.exceptions;

public class DeveloperAlreadyExistException extends RuntimeException {
    public DeveloperAlreadyExistException(String message) {
        super(message);
    }
}
