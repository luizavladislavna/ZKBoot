package com.digi.service;


import com.digi.db.entity.Account;

import java.util.Date;
import java.util.List;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
public interface WelcomeService {

	String getMessage ();

	Date getTime ();

	List<Account> getAccounts();
}
