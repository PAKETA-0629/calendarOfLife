package edu.calendaroflife.security.service;

import edu.calendaroflife.config.jwt.JwtProvider;
import edu.calendaroflife.dto.user.UserLogin;
import edu.calendaroflife.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncoderService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EncoderService(JwtProvider jwtProvider, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isValidPassword(UserLogin userLogin, UserEntity userEntity) {
        return passwordEncoder.matches(userLogin.getPassword(),
                userEntity.getPassword());
    }



    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
