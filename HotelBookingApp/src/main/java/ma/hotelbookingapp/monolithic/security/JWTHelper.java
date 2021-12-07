package ma.hotelbookingapp.monolithic.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTHelper {
    	// generated from https://jwt.io/ 
    private static final String SIGNING_KEY = "VFb0qJ1LRg_4ujbZoRMXnVkUgiuKq5KxWqNdbKq_G9Vvz-S1zZa9LPxtHWKa64zDl2ofkT8F6jBt_K4riU-fPg";

    private JWTHelper() {
    }

    public static String generateToken(Authentication authentication) {

        User user = (User)authentication.getPrincipal();
        List<String> authorities = user.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

        long now = System.currentTimeMillis();
        long expirationTime = now + 1000 * 60 * 60 * 12;

        return Jwts.builder().setSubject(user.getUsername()).setHeaderParam("typ", "JWT")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(expirationTime))
                .claim("roles", authorities)
                .signWith(Keys.hmacShaKeyFor(SIGNING_KEY.getBytes()),
                    SignatureAlgorithm.HS512)
                .compact();
    }

    public static Authentication parse(HttpServletRequest request) {        
        String auth = request.getHeader("Authorization");
        System.out.println(auth);
        if (auth == null || !auth.startsWith("Bearer "))
            return null;
        
        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY.getBytes())
                            .parseClaimsJws(auth.replace("Bearer ", "")).getBody();
        String username = claims.getSubject();
        List<SimpleGrantedAuthority> authorities = ((List<?>)(claims.get("roles"))).stream()
        .map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
        
        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

}

