package com.example.fitappa.Model.UseCase;

public interface LoginInputBoundary {
    Profile login(String email, String password);
    void updateProfile(Profile profile);
}
