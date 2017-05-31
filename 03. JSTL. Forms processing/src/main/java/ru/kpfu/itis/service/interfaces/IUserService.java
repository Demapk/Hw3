package ru.kpfu.itis.service.interfaces;

import ru.kpfu.itis.util.UserDto;

public interface IUserService {

    boolean saveIfNotExists(UserDto user);
}
