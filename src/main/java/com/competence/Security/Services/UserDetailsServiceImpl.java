package com.competence.Security.Services;
//
//import com.bezkoder.springjwt.models.Employee;
//import com.bezkoder.springjwt.repository.UserRepository;
import com.competence.Entities.*;
import com.competence.Repositories.EmployeeRepository;
import com.competence.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	EmployeeRepository employeeRepository;
    RoleRepository roleRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//	List<Role> roles=new ArrayList<Role>();
//        if (employee instanceof Ceo) {
//            roles.add(new Role(ERole.ROLE_CEO));
//        } else if (employee instanceof Manager) {
//            roles.add(new Role(ERole.ROLE_MANAGER));
//        } else if (employee instanceof NormalEmployee) {
//            roles.add(new Role(ERole.ROLE_NORMALEMPLOYEE));
//        }
//
//		return new org.springframework.security.core.userdetails.UserDetailsImpl(employee.getUsername(), employee.getPassword(), roles);
//
//

		return UserDetailsImpl.build(employee);
	}

}