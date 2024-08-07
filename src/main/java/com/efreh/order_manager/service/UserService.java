package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.EmployeeRepository;
import com.efreh.order_manager.dao.UserRepository;
import com.efreh.order_manager.entity.Employee;
import com.efreh.order_manager.entity.authN.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User is not found");
        }

        return user;
    }

//    public User findUserById(Long userId) {
//        Optional<User> userFromDb = userRepository.findById(userId);
//        return userFromDb.orElse(new User());
//    }
//
//    public List<User> allUser() {
//        return userRepository.findAll();
//    }

    public boolean saveUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }

        user.getEmployee().setLogin_phone(user.getUsername());

        user.setRole("ROLE_EMPLOYEE");
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPasswordTransient()));
        userRepository.save(user);

        return true;
    }

    public boolean mergeUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        Employee employeeFromDb = userFromDb.getEmployee();
        if (bCryptPasswordEncoder.matches(user.getPasswordConfirmTransient(), userFromDb.getPassword())) {
            userFromDb.setUsername(user.getUsername());

            employeeFromDb.setDepartment(user.getEmployee().getDepartment());
            employeeFromDb.setJob_title(user.getEmployee().getJob_title());
            employeeFromDb.setName(user.getEmployee().getName());
            employeeFromDb.setOtchestvo(user.getEmployee().getOtchestvo());
            employeeFromDb.setSector(user.getEmployee().getSector());
            employeeFromDb.setSurname(user.getEmployee().getSurname());
            employeeFromDb.setWork_center(user.getEmployee().getWork_center());
            employeeFromDb.setLogin_phone(user.getUsername());

            userRepository.save(userFromDb);
            return true;

        } else return false;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public boolean uniqueUser(User user){
        return userRepository.findByUsername(user.getUsername()) == null;
    }
}
