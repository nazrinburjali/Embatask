package com.embatask.productmanagement.service;

public interface PasswordService {
    String hashPassword(String plainPassword);
    boolean passwordMatch(String plainPassword, String hashedPassword);
}
