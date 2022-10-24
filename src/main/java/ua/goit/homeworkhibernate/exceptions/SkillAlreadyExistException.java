package ua.goit.homeworkhibernate.exceptions;

public class SkillAlreadyExistException extends RuntimeException {
    public SkillAlreadyExistException(String message) {
        super(message);
    }
}
