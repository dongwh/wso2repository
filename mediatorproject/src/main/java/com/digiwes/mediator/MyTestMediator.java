package com.digiwes.mediator;

import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.mediators.AbstractMediator;

public class MyTestMediator extends AbstractMediator implements ManagedLifecycle{
	
	private Double defaultValue = 0d;
	private String cityName = "CITY_NAME";
	
	public MyTestMediator() {
		System.out.println("MyTestMediator-------------------------");
	}

	public boolean mediate(MessageContext ctx) {
		System.out.println("myTestMediator:mediate() ----------------------------------------------------");
		
		Double defaultValue = this.getDefaultValue();
		System.out.println("MyTestMediator defaultValue==================" + defaultValue);
		
		String city = this.getCityName();
		System.out.println("city==================" + city);
		ctx.setProperty(city, "Beijing-------------------------------------------");
		
		return true;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(SynapseEnvironment arg0) {
		// TODO Auto-generated method stub
		
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
		return "MyTestMediator [defaultValue=" + defaultValue + ", cityName="
				+ cityName + "]";
	}
	
	
	
}
