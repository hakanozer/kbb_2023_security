package com.works.services;

import com.works.entities.Employe;
import com.works.entities.Role;
import com.works.repositories.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeService implements UserDetailsService {

    final EmployeRepository employeRepository;
    final PasswordEncoder passwordEncoder;

    public Employe register( Employe employe ) {
        Optional<Employe> optionalEmploye = employeRepository.findByUsernameEquals(employe.getUsername());
        if (optionalEmploye.isPresent()) {
            return null;
        }else {
            employe.setPassword(passwordEncoder.encode(employe.getPassword()) );
            employeRepository.save(employe);
            return employe;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employe> optionalEmploye = employeRepository.findByUsernameEquals(username);
        if (optionalEmploye.isPresent() ) {
            Employe employe = optionalEmploye.get();
            return new User(
                    employe.getUsername(),
                    employe.getPassword(),
                    employe.getEnable(),
                    true,
                    true,
                    true,
                    parseRoles(employe.getRoles())
            );
        }
        throw new UsernameNotFoundException("Not Found");
    }

    private Collection<? extends GrantedAuthority> parseRoles(List<Role> roles) {
        List<GrantedAuthority> ls = new ArrayList<>();
        for ( Role item : roles ) {
            ls.add( new SimpleGrantedAuthority( item.getName() ));
        }
        return ls;
    }

}
