package Friend_proto.example.Service;

import Friend_proto.example.Entity.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JWTService {

    String generatedKey = "";

    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk = keyGenerator.generateKey();
        generatedKey = Base64.getEncoder().encodeToString(sk.getEncoded());
    }

    public String generateToken(Users user){
        Map<String , Objects> claims = new HashMap<>();
        return Jwts.builder().claims().subject(user.getUserName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*60*30))
                .add(claims)
                .and()
                .signWith(getKey())
                .compact();
    }

    public Key getKey(){
        byte[] key =Decoders.BASE64.decode(generatedKey);
        return Keys.hmacShaKeyFor(key);
    }
}
