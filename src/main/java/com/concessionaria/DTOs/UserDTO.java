package com.concessionaria.DTOs;

import lombok.Data;
import lombok.NonNull;
@Data
public class UserDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
}
