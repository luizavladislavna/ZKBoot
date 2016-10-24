package com.digi.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@Entity
@Data
@Table(name = "dg_user",
		uniqueConstraints = @UniqueConstraint(columnNames = {"username"}, name = "unique_account_phone_number"))
@NoArgsConstructor
public class Account extends IdEntity {

	@Column(name = "username", length = 50, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "initdate", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date initDate;

	@Column(name = "role", length = 10, nullable = false)
	private String role;

	//TODO: pay attention - have to be refactored
	@Deprecated
	public UserDetails toUserDetails () {
		return new UserDetails(){

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities () {
				return new ArrayList<>();
			}

			@Override
			public String getPassword () {
				return password;
			}

			@Override
			public String getUsername () {
				return username;
			}

			@Override
			public boolean isAccountNonExpired () {
				return true;
			}

			@Override
			public boolean isAccountNonLocked () {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired () {
				return true;
			}

			@Override
			public boolean isEnabled () {
				return true;
			}
		};
	}
}
