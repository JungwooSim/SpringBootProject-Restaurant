package me.restaurant.interfaces;

public class PasswordWrongException extends RuntimeException {
    public PasswordWrongException(){
        super("Password is wrong");
    }
}
