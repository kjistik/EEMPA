package chinchulin.varano.Security.JWT;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtException implements AuthenticationEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(JwtException.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        logger.error("fail to the method commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no authorize");
    }

}
