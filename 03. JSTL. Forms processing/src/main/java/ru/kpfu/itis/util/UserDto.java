package ru.kpfu.itis.util;


import ru.kpfu.itis.validation.PasswordMatches;

import javax.validation.constraints.Pattern;

@PasswordMatches
public class UserDto {
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,15}$", message = "Длина от 3 до 15 симв")
    private String username;

    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "8 символов, (мин. 1 цифра, большая и мелкая буква")
    private String password;

    public UserDto() {
    }

    public UserDto(String username, String password, String matchingPassword) {
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "8 символов, (мин. 1 цифра, большая и мелкая буква")
    private String matchingPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
