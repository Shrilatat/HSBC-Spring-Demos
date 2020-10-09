package com.trg.dao;


import java.util.List;
import java.util.Optional;

import com.trg.model.Account;

public interface AccountDao {
	public int count();
	public int save(Account account);
	public int update(Account account);
	public int deleteById(int id);
	public List<Account> findAll();

	public List<Account> findByName(String name);

	public Optional<Account> findById(int i);

	public String getNameById(int i);
}
