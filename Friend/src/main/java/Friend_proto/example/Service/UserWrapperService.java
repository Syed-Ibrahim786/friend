package Friend_proto.example.Service;

import Friend_proto.example.Entity.Users;
import Friend_proto.example.Repository.UserRepository;
import Friend_proto.example.Security.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserWrapperService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByuserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Not found");
        }
        return new UserWrapper(user);
    }
}
