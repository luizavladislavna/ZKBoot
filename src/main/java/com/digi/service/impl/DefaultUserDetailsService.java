package com.digi.service.impl;

import com.digi.db.entity.Account;
import com.digi.db.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@Service
public class DefaultUserDetailsService  implements UserDetailsService {

	@Autowired
	AccountRepository repository;

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		Account account = repository.findByUsername(username);
		if (account == null) throw new UsernameNotFoundException("User Not Found");
		return account.toUserDetails();
	}
}
