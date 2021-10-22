package com.spring.config.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OauthClientDetailRepository extends JpaRepository<OauthClientDetail, Long>{


	@Query(value="INSERT IGNORE INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity, autoapprove) VALUES ('spring-boot-rest-read-write-client', 'spring-boot-rest-api', '$2a$04$cxpFWusuwHxDwFHn8DC2DeyYk4YJd49jB9WcZhiacDybUx123G/aa', 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', '108000', '200000', 1)", nativeQuery=true)
	@Modifying
	@Transactional
	public void inserInitData();

}
