package com.example.fitappa.Model.UseCase;

import com.example.fitappa.Model.Gateway.ReadWriter;

public class LoginUseCase implements LoginInputBoundary {

    ReadWriter readWriter;

    public LoginUseCase(ReadWriter readWriter) {
        this.readWriter = readWriter;
    }

    @Override
    public Profile login(String email, String password) {
        return readWriter.read(email, password);
    }
}
