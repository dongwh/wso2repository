package com.digiwes.mediator.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.mediator.service.MediatorService;

public class MyTestMediatorActivator implements BundleActivator {
	private static final Log log = LogFactory.getLog(MyTestMediatorActivator.class);
	
	public MyTestMediatorActivator() {
		System.out.println("MyTestMediatorActivator>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("log info");
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		bundleContext.registerService(MediatorService.class.getName(), new MyTestMediatorService(), null);
	}

	public void stop(BundleContext arg0) throws Exception {
		System.out.println(this.getClass().getName() + ".stop(BundleContext) called ---------------------------------------------");
		
	}

}
