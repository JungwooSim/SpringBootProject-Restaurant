package me.restaurant.application;

import me.restaurant.domain.User;
import me.restaurant.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder().email(email).name(name).level(1L).build();
        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        // TODO : restaurantService의 예외처리 참고 - orElse(unll)보단 에러 처리하는걸 권
        User user = userRepository.findById(id).orElse(null);

        user.setName(name);
        user.setEmail(email);
        user.setLevel(level);
        return user;
    }

    public User deactivateUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.deativate();
        return user;
    }
}
