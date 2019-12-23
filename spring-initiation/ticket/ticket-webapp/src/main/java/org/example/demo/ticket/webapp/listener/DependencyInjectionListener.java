package org.example.demo.ticket.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.example.demo.ticket.business.impl.ManagerFactoryImpl;
import org.example.demo.ticket.business.impl.manager.ProjetManagerImpl;
import org.example.demo.ticket.business.impl.manager.TicketManagerImpl;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;

public class DependencyInjectionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ManagerFactoryImpl managerFactory = new ManagerFactoryImpl();
		managerFactory.setProjetManager(new ProjetManagerImpl());
		managerFactory.setTicketManager(new TicketManagerImpl());
		
		AbstractResource.setManagerFactory(managerFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
