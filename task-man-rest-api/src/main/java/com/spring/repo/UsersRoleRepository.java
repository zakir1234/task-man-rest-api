/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.UserRole;


public interface UsersRoleRepository extends JpaRepository<UserRole, Long>{
	
    public List<UserRole> findByUser_Username(String username);
   
	@Query(value="INSERT IGNORE INTO user_role (user_id,role_id) VALUES (1, 1), (2,2)", nativeQuery=true)
	@Modifying
	@Transactional
	public void inserInitData();
    
    ;

}
