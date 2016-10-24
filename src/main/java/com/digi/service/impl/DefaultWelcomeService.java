package com.digi.service.impl;


import com.digi.db.entity.Account;
import com.digi.db.repository.AccountRepository;
import com.digi.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@Service("sbWelcome") //Pay attention for giving name to Service/Component beans
public class DefaultWelcomeService implements WelcomeService {

	@Autowired
	AccountRepository repository;


	@Override
	public String getMessage () {
		return "Hello, World!";
	}

	@Override
	public Date getTime () {
		return Calendar.getInstance().getTime();
	}

	@Override
	public List<Account> getAccounts () {
		return repository.findAll();
	}
}

