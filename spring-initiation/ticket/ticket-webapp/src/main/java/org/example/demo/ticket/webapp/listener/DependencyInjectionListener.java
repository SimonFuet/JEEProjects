package org.example.demo.ticket.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.example.demo.ticket.business.ManagerFactory;
import org.example.demo.ticket.business.manager.ProjetManager;
import org.example.demo.ticket.business.manager.TicketManager;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;

public class DependencyInjectionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ManagerFactory managerFactory = new ManagerFactory();
		managerFactory.setProjetManager(new ProjetManager());
		managerFactory.setTicketManager(new TicketManager());
		
		AbstractResource.setManagerFactory(managerFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
