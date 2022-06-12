package edu.calendaroflife.service;

import edu.calendaroflife.config.jwt.JwtProvider;
import edu.calendaroflife.converter.DtoConverter;
import edu.calendaroflife.dto.user.SuccessLogin;
import edu.calendaroflife.dto.user.UserLogin;
import edu.calendaroflife.model.UserEntity;
import edu.calendaroflife.repository.UserRepository;
import edu.calendaroflife.security.service.EncoderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final EncoderService encodeService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final DtoConverter dtoConverter;

    public UserService(UserRepository userRepository, EncoderService encodeService, AuthenticationManager authenticationManager, JwtProvider jwtProvider, DtoConverter dtoConverter) {
        this.userRepository = userRepository;
        this.encodeService = encodeService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.dtoConverter = dtoConverter;
    }

    public UserEntity findUserById(Integer id) {
        return userRepository.findUserEntityById(id);
    }

    public UserEntity findUserByLogin(String email) {
        return userRepository.findUserEntityByEmail(email);
    }

    public SuccessLogin validateUser(UserLogin userLogin) throws Exception {
        userLogin.setEmail(userLogin.getEmail().toLowerCase());
        UserEntity userEntity = findUserByLogin(userLogin.getEmail());
        if (!encodeService.isValidPassword(userLogin, userEntity)) {
            throw new Exception("Wrong password");
        }
        log.debug("user {} logged successfully", userLogin);


        //SecurityContextHolder.getContext().setAuthentication(authentication);

        return dtoConverter.convertFromDtoToDto(userEntity, new SuccessLogin())
                .withAccessToken(jwtProvider.generateToken(userLogin.getEmail()));
    }
}
