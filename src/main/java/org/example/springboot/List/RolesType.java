package org.example.springboot.list;

import java.util.Arrays;
import java.util.Objects;

public enum RolesType{

    ROLE_ADMIN,
    ROLE_USER;

    public static RolesType fromString(String roles){
        return Arrays.stream(RolesType.values())
                .filter(type -> Objects.equals(roles, type.name()))
                .findAny()
                .orElse(null);
    }
}
