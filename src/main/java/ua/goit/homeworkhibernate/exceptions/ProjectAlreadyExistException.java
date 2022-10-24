package ua.goit.homeworkhibernate.exceptions;

public class ProjectAlreadyExistException extends RuntimeException {
    public ProjectAlreadyExistException(String message) {
        super(message);
    }
}
