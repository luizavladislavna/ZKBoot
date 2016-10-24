package com.digi.db.repository;

import com.digi.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByUsername (String username);
}

