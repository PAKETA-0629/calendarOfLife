package edu.calendaroflife.controller;

import edu.calendaroflife.config.jwt.JwtProvider;
import edu.calendaroflife.dto.user.SuccessLogin;
import edu.calendaroflife.model.UserEntity;
import edu.calendaroflife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    //@PreAuthorize("!isAuthenticated()")
    //@PostMapping("/signin")
    //public SuccessLogin signIn() {
    //    UserEntity userEntity = userService.find(request.getLogin(), request.getPassword());
    //    String token = jwtProvider.generateToken(userEntity.getLogin());
    //    return new AuthResponse(token);
    //    }


    /**
     * The controller returns dto {@code SuccessLogin} of sign-inned user.
     *
     * @param userLogin - dto with all params.
     * @return new {@code SuccessLogin}.
     */
}