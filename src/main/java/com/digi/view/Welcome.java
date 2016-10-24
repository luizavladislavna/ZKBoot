package com.digi.view;

import com.digi.db.entity.Account;
import com.digi.service.WelcomeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.Date;
import java.util.List;


/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@VariableResolver(DelegatingVariableResolver.class)
@Data
@Slf4j
public class Welcome {
	//Pay attention for giving name to Service/Component beans
	@Autowired
	@WireVariable
	private WelcomeService sbWelcome;

	//-------------------------------------------
	private String message;
	private Date date;
	private Account selectedAccount;
	private List<Account> accounts;
	//-------------------------------------------

	@Command
	@NotifyChange({"message", "date"})
	public void sayWelcome () {
		log.debug("testService: {}", sbWelcome);
		setMessage(sbWelcome.getMessage());
		setDate(sbWelcome.getTime());
	}

	@Command
	@NotifyChange({"accounts"})
	public void showList () {
		this.setAccounts(sbWelcome.getAccounts());
	}
}
