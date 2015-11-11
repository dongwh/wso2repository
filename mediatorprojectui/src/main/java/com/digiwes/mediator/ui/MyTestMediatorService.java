package com.digiwes.mediator.ui;

import org.wso2.carbon.mediator.service.AbstractMediatorService;
import org.wso2.carbon.mediator.service.ui.Mediator;

public class MyTestMediatorService extends AbstractMediatorService{
	
	public MyTestMediatorService() {
		System.out.println("MyTestMediatorService<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	public String getDisplayName() {
		return "MyTest";
	}

	public String getLogicalName() {
		return "MyTestMediator";
	}

	public Mediator getMediator() {
		return (Mediator) new MyTestMediator();
	}

	public String getTagLocalName() {
		return "mytest";
	}
	
	public String getGroupName() {
        return "Extension";
    }

}
