//package edu.mum.coffee.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import edu.mum.coffee.domain.Person;
//import edu.mum.coffee.domain.Role;
//import edu.mum.coffee.repository.PersonRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class PersonDetailsServiceImpl implements UserDetailsService{
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//        Person person = personRepository.findOne(Long.valueOf(id));
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : person.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(person.getFirstName(), person.getPassword(), grantedAuthorities);
//    }
//}