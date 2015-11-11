package com.digiwes.mediator.ui;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.wso2.carbon.mediator.service.ui.AbstractMediator;

public class MyTestMediator extends AbstractMediator {
	static final String MYTEST_LOCAL_NAME = "mytest";
	static final QName DEFAULT_VALUE_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "defaultValue"); 
	static final QName CITY_NAME_QNAME = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "cityName"); 
	
	private Double defaultValue = 0d;
	private String cityName = "CITY_NAME";
	
	public MyTestMediator() {
		System.out.println("UI MyTestMediator///////////////////////////////////////");
	}

	public void build(OMElement element) {
		System.out.println("UI MyTestMediator:build()---------------------");
		
		// read default value
		OMElement defaultValueElement = element.getFirstChildWithName(DEFAULT_VALUE_QNAME);
		if (null != defaultValueElement) {
			Double defaultValue = Double.valueOf(defaultValueElement.getText());
			System.out.println("UI build() defaultValue.getText()=============================="+defaultValue);
			this.setDefaultValue(defaultValue);
		} else {
			throw new SynapseException("default value element missing");
		}
		
		// read cityName 
	    OMElement cityNameValueElement = element.getFirstChildWithName(CITY_NAME_QNAME);
	 	if (null != cityNameValueElement) {
	 	    String cityName = String.valueOf(cityNameValueElement.getText());
	 	    System.out.println("UI build() cityName.getText()================================="+cityName);
	 	    this.setCityName(cityName);
	 	} else {
	 	   throw new SynapseException("cityName element missing");
	 	}
	 	
	 	processAuditStatus(this, element);
	}

	public String getTagLocalName() {
		System.out.println("UI MyTestMediator:getTagLocalName()---------------------");
		return MYTEST_LOCAL_NAME;
	}

	public OMElement serialize(OMElement parent) {
		System.out.println("UI MyTestMediator:serialize()---------------------");
		OMElement myTest = fac.createOMElement("mytest", synNS);
		saveTracingState(myTest, this);
		
		// add default value element
	    OMElement defaultElement = fac.createOMElement(DEFAULT_VALUE_QNAME, myTest);
	    defaultElement.setText(String.valueOf(this.getDefaultValue()));
	    System.out.println("UI serialize() mediator.getDefaultValue()===="+this.getDefaultValue());
	    
	    // add cityName element
	    OMElement cityNameElement = fac.createOMElement(CITY_NAME_QNAME, myTest);
	    cityNameElement.setText(String.valueOf(this.getCityName()));
	    System.out.println("UI serialize() mediator.getCityName()===="+this.getCityName());
		
		saveTracingState(myTest, this);
		
		if (parent != null) {
			parent.addChild(myTest);
		}
		
		return myTest;
	}

	public Double getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Double defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Override
	public String toString() {
		return "UI MyTestMediator [defaultValue=" + defaultValue + ", cityName="
				+ cityName + "]";
	}
	
}
