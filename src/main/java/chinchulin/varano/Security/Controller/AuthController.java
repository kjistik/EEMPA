package chinchulin.varano.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinchulin.varano.Security.DTO.JwtDTO;
import chinchulin.varano.Security.DTO.LoginUser;
import chinchulin.varano.Security.DTO.NewUser;
import chinchulin.varano.Security.Models.User;
import chinchulin.varano.Security.Service.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<?> CreateUser (@Valid @RequestBody NewUser newUser) {

        User user = authService.NewUser(newUser);

    return ResponseEntity.status(HttpStatus.CREATED).body(user);


    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login (@Valid @RequestBody LoginUser loginUser) {

        JwtDTO jwtDto = authService.login(loginUser);

        return ResponseEntity.status(HttpStatus.OK).body(jwtDto);
    }

}
