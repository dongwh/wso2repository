package com.digiwes.mediator;

import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;

public class MyTestMediatorFactory extends AbstractMediatorFactory{

	static final QName MYTEST_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "mytest");
	static final QName DEFAULT_VALUE_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "defaultValue"); 
	static final QName CITY_NAME_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "cityName"); 
	
	public QName getTagQName() {
		System.out.println("MyTestMediatorFactory:getTagQName()------------------------------------");
		return MYTEST_QNAME;
	}

	@Override
	protected Mediator createSpecificMediator(OMElement elem, Properties arg1) {
		System.out.println("MyTestMediatorFactory:createSpecificMediator()------------------------------------");
		
		// create new mediator
		MyTestMediator newMediator = new MyTestMediator();
		
		// setup initial settings     
		processTraceState(newMediator, elem);
		
		// read default value
		OMElement defaultValueElement = elem.getFirstChildWithName(DEFAULT_VALUE_QNAME);
	    if (null != defaultValueElement) {
	      Double defaultValue = Double.valueOf(defaultValueElement.getText());
	      System.out.println("defaultValue.getText()=============================="+defaultValue);
	      newMediator.setDefaultValue(defaultValue);
	    } else {
	      throw new SynapseException("default value element missing");
	    }
	    
	    // read cityName 
	    OMElement cityNameValueElement = elem.getFirstChildWithName(CITY_NAME_QNAME);
	 	if (null != cityNameValueElement) {
	 	    String cityName = String.valueOf(cityNameValueElement.getText());
	 	    System.out.println("cityName.getText()================================="+cityName);
	 	    newMediator.setCityName(cityName);
	 	} else {
	 	   throw new SynapseException("cityName element missing");
	 	}
	    
	    //return instance of mediator
		return newMediator;
	}
	
}
