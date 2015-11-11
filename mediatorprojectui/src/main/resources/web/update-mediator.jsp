<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="org.wso2.carbon.mediator.service.ui.Mediator"%>
<%@ page import="org.wso2.carbon.sequences.ui.util.SequenceEditorHelper"%>
<%@ page import="main.java.com.digiwes.mediator.ui.MyTestMediator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% 
	Mediator mediator = SequenceEditorHelper.getEditingMediator(request, session);
	if (!(mediator instanceof MyTestMediator)) {
    	// todo : proper error handling
    	throw new RuntimeException("Unable to edit the mediator");
	}
	MyTestMediator myTestMediator = (MyTestMediator) mediator;
  
    String value = String.valueOf(myTestMediator.getDefaultValue());
  
%>
<body>
    update---------
    value = <%=value %>
  <input type="text" value="<%=value%>" />
</body>
</html>