package com.spring.config.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.repo.RoleRepository;
import com.spring.repo.UsersRepository;
import com.spring.repo.UsersRoleRepository;

@Component
@Transactional
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
    private UsersRepository usersRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UsersRoleRepository usersRoleRepository;
	@Autowired
	private OauthClientDetailRepository oauthClientDetailRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        saveOuthInitData();
    }

    private void saveOuthInitData() {
    	insertInitData();
    }
    
    private void insertInitData() {
    	usersRepository.inserInitData();
    	roleRepository.inserInitData();
    	usersRoleRepository.inserInitData();    	
    	oauthClientDetailRepository.inserInitData();
    }

}