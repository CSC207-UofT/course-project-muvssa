package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

public interface LoginInputBoundary {
    Profile login(String email, String password);
}
