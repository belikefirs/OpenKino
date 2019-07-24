package com.tokens;

import com.configuration.JwtConfig;
import com.dao.KinoUserDao;
import com.models.KinoUser;
import com.service.KinUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FilterToken extends OncePerRequestFilter {
    private final JwtConfig jwtConfig;
    private KinUserService kinUserService;
    public FilterToken(JwtConfig jwtConfig){
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader(jwtConfig.getHeader());
        if(header == null || !header.startsWith(jwtConfig.getPrefix())){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String token = header.replace(jwtConfig.getPrefix(), "");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret().getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            String username = claims.getSubject();
            List<LinkedHashMap> authoritiesMap = (List<LinkedHashMap>) claims.get("authorities");
            if (username != null) {
                KinoUser kinoUser = kinUserService.findKinoUserByMail(username);
                if (authoritiesMap != null) {
                    List<SimpleGrantedAuthority> authorities = authoritiesMap
                            .stream().map(val -> {
                                        LinkedHashMap val1 = val;
                                        return new SimpleGrantedAuthority((String) val1.get("authority"));
                                    }
                            ).collect(Collectors.toList());
                    ;
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            username, null, authorities
                    );
                    SecurityContextHolder.getContext().setAuthentication(auth);

                }
            }
        } catch (Exception e){
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
