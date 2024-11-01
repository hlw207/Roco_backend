package com.example.roco_backend.Service;

public interface UserService {

    public boolean login(String account, String password);
    public boolean register(String account, String password);
    public boolean isExist(String account);
    public void changeName(String name, String account);

    public String getName(String account);
}
