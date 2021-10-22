/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.User;


public interface UsersRepository extends JpaRepository<User, Long> {

	public User findByUsernameAndPasswordAndEnabled(String username, String password, boolean enabled);

	public User findByUsername(String username);

	public User findByUsernameAndEnabled(String username, boolean enabled);
	
	@Query(value="INSERT IGNORE INTO user (username,nick_name, password, enabled) "
			+ "VALUES ('admin', 'Zakir', '$2a$10$i0o4WYaExzKQN3Ojh46qB.EGd/SwBWqHZIo1xF.3K3xapeeXQado6', true), "
			+ "('user', 'User 1', '$2a$10$i0o4WYaExzKQN3Ojh46qB.EGd/SwBWqHZIo1xF.3K3xapeeXQado6', true)", nativeQuery=true)
	@Modifying
	@Transactional
	public void inserInitData();
	
}
