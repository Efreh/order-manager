package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.EmployeeRepository;
import com.efreh.order_manager.dao.UserRepository;
import com.efreh.order_manager.dto.UserDTO;
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
        User user = userRepository.findByPhoneNumber(username);
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

    public boolean saveUser(UserDTO userDTO) {
        User userFromDb = userRepository.findByPhoneNumber(userDTO.getPhoneNumber());
        if (userFromDb != null) {
            return false;
        }

        User user = new User();
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole("ROLE_EMPLOYEE");

        Employee employee = new Employee();
        employee.setPhoneNumber(userDTO.getPhoneNumber());
        employee.setName(userDTO.getName());
        employee.setOtchestvo(userDTO.getOtchestvo());
        employee.setSurname(userDTO.getSurname());
        employee.setDepartment(userDTO.getDepartment());
        employee.setSector(userDTO.getSector());
        employee.setWorkCenter(userDTO.getWorkCenter());
        employee.setJobTitle(userDTO.getJobTitle());

        user.setEmployee(employee);

        userRepository.save(user);

        return true;
    }

    public boolean mergeUser(UserDTO userDTO) {
        User userFromDb = userRepository.findByPhoneNumber(userDTO.getPhoneNumber());
        Employee employeeFromDb = userFromDb.getEmployee();
        if (bCryptPasswordEncoder.matches(userDTO.getPassword(), userFromDb.getPassword())) {
            userFromDb.setPhoneNumber(userDTO.getPhoneNumber());

            employeeFromDb.setDepartment(userDTO.getDepartment());
            employeeFromDb.setJobTitle(userDTO.getJobTitle());
            employeeFromDb.setName(userDTO.getName());
            employeeFromDb.setOtchestvo(userDTO.getOtchestvo());
            employeeFromDb.setSector(userDTO.getSector());
            employeeFromDb.setSurname(userDTO.getSurname());
            employeeFromDb.setWorkCenter(userDTO.getWorkCenter());
            employeeFromDb.setPhoneNumber(userDTO.getPhoneNumber());

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

    public boolean uniqueUser(UserDTO userDTO){
        return userRepository.findByPhoneNumber(userDTO.getPhoneNumber()) == null;
    }
}
