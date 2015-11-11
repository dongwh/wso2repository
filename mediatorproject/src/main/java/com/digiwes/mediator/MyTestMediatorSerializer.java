package com.digiwes.mediator;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorSerializer;

public class MyTestMediatorSerializer extends AbstractMediatorSerializer{

	public String getMediatorClassName() {
		System.out.println("MyTestMediatorSerializer:getMediatorClassName()-----------------------");

		return MyTestMediator.class.getName();
	}

	@Override
	protected OMElement serializeSpecificMediator(Mediator m) {
		
		if (!(m instanceof MyTestMediator)) {
		      handleException("Unsupported mediator passed in for serialization : " + m.getType());
		}
		
		//OMElement myTest = fac.createOMElement(MyTestMediatorFactory.SURCHARGE_STOCK_QUOTE_Q);
		System.out.println("MyTestMediatorSerializer:serializeSpecificMediator()-----------------------");
		MyTestMediator mediator = (MyTestMediator)m;
		OMElement myTest = fac.createOMElement("mytest", synNS);
        saveTracingState(myTest, mediator);
        
        // add default value element
	    OMElement defaultElement = fac.createOMElement(MyTestMediatorFactory.DEFAULT_VALUE_QNAME, myTest);
	    defaultElement.setText(String.valueOf(mediator.getDefaultValue()));
	    System.out.println("mediator.getDefaultValue()===="+mediator.getDefaultValue());
	    
	    // add cityName element
	    OMElement cityNameElement = fac.createOMElement(MyTestMediatorFactory.CITY_NAME_QNAME, myTest);
	    cityNameElement.setText(String.valueOf(mediator.getCityName()));
	    System.out.println("mediator.getCityName()===="+mediator.getCityName());
        
		return myTest;
	}

}
