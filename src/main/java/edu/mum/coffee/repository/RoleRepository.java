package edu.mum.coffee.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	 Role findByname(String name);
}