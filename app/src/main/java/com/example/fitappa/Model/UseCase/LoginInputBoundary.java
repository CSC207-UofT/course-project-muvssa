package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

public interface LoginInputBoundary {
    LoginUseCase.LoginResult login(String email, String password);
}
