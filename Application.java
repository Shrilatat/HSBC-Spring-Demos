package com.trg;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trg.dao.AccountDao;
import com.trg.model.Account;

@SpringBootApplication
public class Application implements CommandLineRunner{

	 private static final Logger log = LoggerFactory.getLogger(Application.class);
	 
	 @Autowired
	    JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 AccountDao dao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		runJDBC();
	}
	
	void runJDBC() {

        log.info("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE accounts IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE accounts(" +
                "acctid number(3), aname VARCHAR(20), type varchar(15), bal number(7, 2))");

        List<Account> accounts = Arrays.asList(
                new Account(1, "Account-1", "savings", 50000),
                new Account(2, "Account-2", "savings", 20000),
                new Account(3, "Account-3", "current", 35000),
                new Account(4, "Account-4","current",20000)
        );

        log.info("[SAVE]");
        accounts.forEach(account -> {
            log.info("Saving...{}", account.getAname());
            dao.save(account);
        });

        // count
        log.info("[COUNT] Total accounts: {}", dao.count());

        // find all
        log.info("[FIND_ALL] {}", dao.findAll());

        // find by id
        /* log.info("[FIND_BY_ID] :2");
        Book book = dao.findById(2).orElseThrow(IllegalArgumentException::new);
        log.info("{}", book);

        // find by name (like) and price
        log.info("[FIND_BY_NAME_AND_PRICE] : like '%Java%' and price <= 10");
        log.info("{}", dao.findByNameAndPrice("Java", 10));

        // get name (string) by id
        log.info("[GET_NAME_BY_ID] :1L = {}", dao.getNameById(1));

        // update
        log.info("[UPDATE] :2L :99.99");
        book.setPrice(new BigDecimal("99.99"));
        log.info("rows affected: {}", bookRepository.update(book));

        // delete
        log.info("[DELETE] :3L");
        log.info("rows affected: {}", bookRepository.deleteById(3L));

        // find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());
*/
    }
}
