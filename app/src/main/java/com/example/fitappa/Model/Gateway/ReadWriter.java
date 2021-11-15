package com.example.fitappa.Model.Gateway;

import com.example.fitappa.Model.UseCase.Profile;

public interface ReadWriter {
    void save(Object o);

    Profile read(String email, String password);
}
