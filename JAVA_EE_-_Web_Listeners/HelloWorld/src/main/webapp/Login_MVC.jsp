<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Veuillez vous authentifier</title>
        <link rel='stylesheet' type='text/css' href='styles.css' />
    </head>
    <body>
        <h1>[MVC] Veuillez vous authentifier</h1>
        <h2>isConnected set to : ${isConnected} at <%= new Date() %></h2>
    

            <form method="post" action="login_MVC">
                <label for='txtLogin'>Login :</label>
                <input id='txtLogin' name='txtLogin' type='text' value='${login}' autofocus /> <br/>
                <label for='txtPassword'>Password :</label>
				
				
				<!-- 
				here we comment the old synthax :
				<input name='txtPassword' type='password' value='<%= session.getAttribute("password") %>' /> <br/>
				
				and let's the newer equivalent synthax present :
				 -->                
                <input name='txtPassword' type='password' value='${password}' /> <br/>
                
                <br/>
                <input name='btnConnect' type='submit' value='Se connecter' /> <br/>
            </form>
  
    </body>
</html>