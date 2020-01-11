package org.example.demo.ticket.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ticket.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class AbstractManager {

	@Inject
	@Named("txManagerTicket")
	private PlatformTransactionManager platformTransactionManager;

	private DaoFactory daoFactory;

	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

}
