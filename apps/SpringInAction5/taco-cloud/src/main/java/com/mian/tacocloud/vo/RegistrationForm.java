package com.mian.tacocloud.vo;

import com.mian.tacocloud.domain.CustomUser;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public CustomUser toUser(PasswordEncoder passwordEncoder) {
        return new CustomUser(this.username,
                passwordEncoder.encode(this.password),
                this.fullName,
                this.street,
                this.city,
                this.state,
                this.zip,
                this.phone);
    }

}
