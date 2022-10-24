package ua.goit.homeworkhibernate.exceptions;

public class CompanyAlreadyExistException extends RuntimeException {
    public CompanyAlreadyExistException(String message) {
        super(message);
    }
}
