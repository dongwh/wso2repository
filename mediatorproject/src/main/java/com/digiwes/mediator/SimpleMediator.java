package com.digiwes.mediator;

import org.apache.log4j.Logger;
import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.MessageContext;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.mediators.AbstractMediator;

public class SimpleMediator extends AbstractMediator implements ManagedLifecycle {
	private static Logger log = Logger.getLogger(SimpleMediator.class);
	
	// 入参
	private String requestParam1 = "requestParam1";
	private String requestParam2 = "requestParam2";
	private String requestParam3 = "requestParam3";

	// 属性
	private String param1;
	private String param2;
	private String param3;

	public boolean mediate(MessageContext synCtx) {

		//class标签之内的参数传递
		param1 = this.getRequestParam1();
		param2 = this.getRequestParam2();
		param3 = this.getRequestParam3();
		System.out.println("param1=" + param1);
		System.out.println("param2=" + param2);
		System.out.println("param3=" + param3);

		// 重新定义一个property 在log日志中打印出来
		synCtx.setProperty("someParam", "someParam value++++++++++++++++++++++++++++++");
		// 得到requestParam1参数的值，并重新赋值是否好使
		synCtx.setProperty(this.requestParam1, "requestParam1  new  value++++++++++++++++++++++++++++++");

		//class标签之外的参数传递
		param3 = (String) synCtx.getProperty("requestParam");
		System.out.println("param3=" + param3);
		//得到requestParame2参数的值，并重新赋值是否好使
		synCtx.setProperty(this.getRequestParam2(), "city's new value is Tianjin");
		
		synCtx.setProperty("QUERY_PARAM", param3);
		
		return true;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(SynapseEnvironment arg0) {
		// TODO Auto-generated method stub

	}

	public String getRequestParam1() {
		return requestParam1;
	}

	public void setRequestParam1(String requestParam1) {
		this.requestParam1 = requestParam1;
	}

	public String getRequestParam2() {
		return requestParam2;
	}

	public void setRequestParam2(String requestParam2) {
		this.requestParam2 = requestParam2;
	}

	public String getRequestParam3() {
		return requestParam3;
	}

	public void setRequestParam3(String requestParam3) {
		this.requestParam3 = requestParam3;
	}

}
