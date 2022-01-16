<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>[MVC] Welcome</title>
        <link rel='stylesheet' type='text/css' href='styles.css' />
    </head>
    <body>
        <h1>[MVC] Welcome : ${login}</h1>
        <h2>isConnected set to : ${isConnected} at <%= new Date() %></h2>
    

            <form method="post" action="logout">
                <input name='btnConnect' type='submit' value='Se deconnecter' /> <br/>
            </form>
  
    </body>
</html>