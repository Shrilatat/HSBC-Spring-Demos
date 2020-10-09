package com.trg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trg.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(Account account) {
		return jdbcTemplate.update("insert into accounts (acctid, aname, type, bal) values(?,?,?,?)",
				account.getAcctId(), account.getAname(), account.getType(), account.getBal());
	}

	public int update(Account account) {
		return jdbcTemplate.update("update accounts set bal = ? where acctid = ?", account.getBal(),
				account.getAcctId());
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from accounts where acctid = ?", id);
	}

	public List<Account> findAll() {
		return jdbcTemplate.query("select * from accounts", (rs, rowNum) -> new Account(rs.getInt("acctid"),
				rs.getString("aname"), rs.getString("type"), rs.getDouble("bal")));
	}

	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from accounts", Integer.class);
	}

	@Override
	public Optional<Account> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
