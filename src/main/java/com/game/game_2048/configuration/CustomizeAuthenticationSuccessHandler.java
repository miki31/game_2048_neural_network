//package com.game.game_2048.configuration;
//
//import com.game.game_2048.model.Role;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
//                                        HttpServletResponse response,
//                                        Authentication authentication)
//            throws IOException, ServletException {
//        //set our response to OK status
//        response.setStatus(HttpServletResponse.SC_OK);
//
//        for (GrantedAuthority auth : authentication.getAuthorities()) {
//            if (Role.ADMIN.equals(Role.valueOf(auth.getAuthority()))) {
//                response.sendRedirect("/dashboard");
//            }
//        }
//    }
//}
