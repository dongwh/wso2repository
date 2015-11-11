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
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.axis2.context.ConfigurationContext"%>
<%@ page import="org.wso2.carbon.CarbonConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil"%>
<%@ page import="org.wso2.carbon.utils.ServerConstants"%>
<%@ page import="org.wso2.carbon.mediator.service.ui.Mediator"%>
<%@ page import="com.digiwes.mediator.ui.MyTestMediator"%>
<%@ page import="org.wso2.carbon.sequences.ui.util.SequenceEditorHelper"%>
<%@ page import="org.apache.synapse.mediators.Value"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<% 
	Mediator mediator = SequenceEditorHelper.getEditingMediator(request, session);
	if (!(mediator instanceof MyTestMediator)) {
	    // todo : proper error handling
	    throw new RuntimeException("Unable to edit the mediator");
	}
	MyTestMediator myTestMediator = (MyTestMediator) mediator;

  
    //String configuration = "";
    String defaultValue = "";
    String cityName = "";
    defaultValue = String.valueOf(myTestMediator.getDefaultValue());
    cityName = myTestMediator.getCityName();
    
    System.out.println("edit-mediator.jsp-----defaultValue="+defaultValue);
    System.out.println("edit-mediator.jsp-----cityName="+cityName);
  
%>

	<div>
		<table class="normal" width="100%">
			<tr>
				<td>
					<h2>
						MyTest Mediator
					</h2>
				</td>
			</tr>
			<tr>
				<td>
					<table class="normal">
						<tr>
							<td>defaultValue</td>
							<td>
								<input class="longInput" type="text" value="<%=defaultValue%>" name="defaultValue" id="defaultValue"/>
							</td>
							<td>	
								<a href="#" >something target</a>
							</td>
						</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td>
					<table class="normal">
						<tr>
							<td>cityName</td>
							<td>
								<input class="longInput" type="text" value="<%=cityName%>" name="cityName" id="cityName" readonly="false" />
							</td>
							<td>	
								<a href="#" >something target</a>
							</td>
						</tr>
					</table>	
				</td>
			</tr>
		</table>
		<a name="registryBrowserLink"></a>
		<div id="registryBrowser" style="display:none;"></div>
	</div>

