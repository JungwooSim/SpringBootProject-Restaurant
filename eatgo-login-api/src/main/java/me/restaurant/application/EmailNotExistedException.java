package me.restaurant.application;

public class EmailNotExistedException extends RuntimeException {
    public EmailNotExistedException(String email) {
        super("Email is not registered : " + email);
    }
}
