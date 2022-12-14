package com.concessionaria.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
}
