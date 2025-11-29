package Friend_proto.example.Controller;

import Friend_proto.example.Entity.Users;
import Friend_proto.example.Repository.UserRepository;
import Friend_proto.example.Service.UserAuthService;
import Friend_proto.example.Service.UserWrapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Encoder;

@RestController
public class Controller {

    public BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("/api/register")
    public void register(@RequestBody Users user){
        try{
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
        }catch (Exception E){
            log.error("e: ", E);
        }
    }


    @PostMapping("/api/login")
    public String login(@RequestBody Users user){
        return userAuthService.verifyUser(user);
    }

}
