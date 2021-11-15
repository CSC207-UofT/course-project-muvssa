package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.LoginInputBoundary;
import com.example.fitappa.Model.UseCase.LoginUseCase;
import com.example.fitappa.Model.UseCase.Profile;

public interface ReadWriter {
    void save(Object o);

    void read(String email, String password, LoginInputBoundary useCase);
}
