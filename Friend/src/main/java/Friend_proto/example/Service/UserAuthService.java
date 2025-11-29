package Friend_proto.example.Service;


import Friend_proto.example.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public JWTService jwtService;

    public String verifyUser(Users user){
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUserName() , user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user);
        }
        return "failed";
    }

}
