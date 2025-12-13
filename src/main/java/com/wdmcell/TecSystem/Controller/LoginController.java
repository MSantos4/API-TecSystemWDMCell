package com.wdmcell.TecSystem.Controller;

import com.wdmcell.TecSystem.DTO.LoginDTO;
import com.wdmcell.TecSystem.DTO.LoginResponseDTO;
import com.wdmcell.TecSystem.DTO.Response.Response;
import com.wdmcell.TecSystem.Service.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponseDTO>> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {

        LoginResponseDTO usuario = loginService.login(loginDTO);

        if (usuario == null) {
            Response<LoginResponseDTO> loginResponse = new Response<>(
                    "Erro",
                    "usuário ou senha incorrétos",
                    LocalDateTime.now(),
                    null
            );
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }

        String token = UUID.randomUUID().toString();

        Cookie cookie = new Cookie("AUTH_TOKEN" , token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(3600);

        response.addCookie(cookie);

        Response<LoginResponseDTO> loginResponse = new Response<>(
                "Sucesso",
                "Login realizado com sucesso!",
                LocalDateTime.now(),
                usuario
        );

        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    @PostMapping("/logout")
    ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("AUTH_TOKEN", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.ok("Sessão encerrada");
    }
}
