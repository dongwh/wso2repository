<%@page import="org.snmp4j.agent.mo.snmp.SNMPv2MIB.SysOREntry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%--
  ~  Copyright (c) 2008, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  ~
  ~  Licensed under the Apache License, Version 2.0 (the "License");
  ~  you may not use this file except in compliance with the License.
  ~  You may obtain a copy of the License at
  ~
  ~        http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~  Unless required by applicable law or agreed to in writing, software
  ~  distributed under the License is distributed on an "AS IS" BASIS,
  ~  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~  See the License for the specific language governing permissions and
  ~  limitations under the License.
  --%>
<%@ page import="org.wso2.carbon.mediator.service.ui.Mediator" %>
<%@ page import="com.digiwes.mediator.ui.MyTestMediator" %>
<%@ page import="org.wso2.carbon.sequences.ui.util.SequenceEditorHelper" %>
<%@ page import="org.apache.synapse.mediators.Value"%>
<%
	Mediator mediator = SequenceEditorHelper.getEditingMediator(request, session);
    /* System.out.println("update mediator ="+mediator.toString());
	System.out.println("update mediator ="+mediator.getClass().getName()); */
	if (!(mediator instanceof MyTestMediator)) {
	    // todo : proper error handling
	    throw new RuntimeException("Unable to edit the mediator");
	}
	MyTestMediator myTestMediator = (MyTestMediator) mediator;
    
    String defaultValue = "0";
    defaultValue = request.getParameter("defaultValue");
    if(null == defaultValue){
    	defaultValue = "10";
    }
    String cityName = "";
    cityName = request.getParameter("cityName");
    
    System.out.println("update-mediator.jsp-----defaultValue="+defaultValue);
    System.out.println("update-mediator.jsp-----cityName="+cityName);
    
    myTestMediator.setDefaultValue(Double.parseDouble(defaultValue));
    myTestMediator.setCityName(cityName);
    

%> 

