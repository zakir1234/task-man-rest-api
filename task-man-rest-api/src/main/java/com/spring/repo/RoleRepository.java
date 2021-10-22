package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	
	@Query(value="INSERT IGNORE INTO role (role_name) VALUES ('ROLE_USER'),('ROLE_ADMIN')", nativeQuery=true)
	@Modifying
	@Transactional
	public void inserInitData();

}
