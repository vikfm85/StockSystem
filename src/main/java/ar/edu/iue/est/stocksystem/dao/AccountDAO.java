package ar.edu.iue.est.stocksystem.dao;

import ar.edu.iue.est.stocksystem.entity.Account;

public interface AccountDAO {

	public Account findAccount(String userName);

}