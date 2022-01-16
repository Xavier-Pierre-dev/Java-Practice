# Java EE - Annotation Details in Servlet 3.0 <!-- omit in TOC -->

<div align="center">

![image](../javaEE.png)

|[previous](./../JAVA_EE_-_Servlet_filter/Readme.md)|[index](./../Readme.md)|[next](./../JAVA_EE_-_Annotation_Details_in_Servlet_3/Readme.md)|
|---|---|---|

</div>

## Summary <!-- omit in TOC -->

- [Introduction](#introduction)
- [Servlet : @WebServlet](#servlet--webservlet)
- [Filter : @WebFilter](#filter--webfilter)
- [Filter & Servlet (initParams) : @WebInitParam](#filter--servlet-initparams--webinitparam)
- [WebListeners : @WebListener](#weblisteners--weblistener)
- [@MultipartConfig](#multipartconfig)
- [Resource](#resource)

<br>
<br>

___

## Introduction

Before Servlet API 3.0 we use only the deployment descriptor ``web.xml`` for deploying our application but the Servlet API 3.0 introduce a new package called ``javax.servlet.annotation``. It provides annotation types which can be used for annotating a servlet class. If you use annotation, then the deployment descriptor (``web.xml``) is not required. But you should use ``tomcat7`` or any later version of tomcat.

Annotations can replace equivalent XML configuration in the web deployment descriptor file (``web.xml``) such as servlet declaration and servlet mapping. Servlet containers will process the annotated classes at deployment time.

<div align="center">Annotation types introduced in Servlet 3.0 
<table class="table table-bordered">
<tbody><tr>
<th>Sr.No.</th>
<th style="text-align:center;">Annotation &amp; Description</th>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">1</td>
<td><p><b>@WebServlet</b></p>
<p>To declare a servlet.</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">2</td>
<td><p><b>@WebInitParam</b></p>
<p>To specify an initialization parameter. </p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">3</td>
<td><p><b>@WebFilter</b></p>
<p>To declare a servlet filter.</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">4</td>
<td><p><b>@WebListener</b></p>
<p>To declare a WebListener</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">5</td>
<td><p><b>@HandlesTypes </b></p>
<p>To declare the class types that a ServletContainerInitializer can handle.</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">6</td>
<td><p><b>@HttpConstraint</b></p>
<p>This annotation is used within the ServletSecurity annotation to represent the security constraints to be applied to all HTTP protocol methods for which a corresponding HttpMethodConstraint element does NOT occur within the ServletSecurity annotation.</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">7</td>
<td><p><b>@HttpMethodConstraint </b></p>
<p>This annotation is used within the ServletSecurity annotation to represent security constraints on specific HTTP protocol messages.</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">8</td>
<td><p><b>@MultipartConfig </b></p>
<p>Annotation that may be specified on a Servlet class, indicating that instances of the Servlet expect requests that conform to the multipart/form-data MIME type.</p></td>
</tr>
<tr>
<td style="text-align:center; vertical-align:middle;">9</td>
<td><p><b>@ServletSecurity</b></p>
<p>This annotation is used on a Servlet implementation class to specify security constraints to be enforced by a Servlet container on HTTP protocol messages.</p></td>
</tr>
</tbody></table>
</div>

<br>
<br>

___

## Servlet : @WebServlet

``@WebServlet`` annotation is the replacement of servlet configuration in web.xml. When we annotate our servlet class with ``@WebServlet`` annotation the container will be able to recognize this as a servlet at the loading time.

Class annotated with ``@WebServlet`` still needs to extends the HttpServlet class With this annotation we can specify servlet-name, url-mapping, load on Start up, description ,init params ,async supported etc

<table class="demo" align=center>
	<caption>loadOnStartup</caption>
	<thead>
	<tr>
		<th>web.xml (old java EE)</th>
		<th>.class & annotation (recent java EE)</th>
	</tr>
	</thead>
	<tbody>
	<tr>
<td>

url pattern
```xml
  <servlet>
  	<servlet-name>LyfeCycleServlet</servlet-name>
  	<servlet-class>com.tutorial.hello.LyfeCycleServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>LyfeCycleServlet</servlet-name>
  	<url-pattern>/LyfeCycleServlet</url-pattern>
  </servlet-mapping>
```

<br>
<br>

url pattern + loadOnStartup
```xml
  <servlet>  
   <servlet-name>LyfeCycleServlet</servlet-name>  
   <servlet-class>com.tutorial.hello.LyfeCycleServlet</servlet-class>  
   <load-on-startup>1</load-on-startup>  
  </servlet>

  <servlet-mapping>
  	<servlet-name>LyfeCycleServlet</servlet-name>
  	<url-pattern>/LyfeCycleServlet</url-pattern>
  </servlet-mapping>
```
        
</td>
		<td>

url pattern only :
```java
/**
 * Servlet implementation class LyfeCycleServlet
 */
@WebServlet("/LyfeCycleServlet")
public class LyfeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
```

<br>

url pattern + loadOnStartup
```java
/**
 * Servlet implementation class LyfeCycleServlet
 */
@WebServlet(urlPatterns="/LyfeCycleServlet", loadOnStartup=1)
public class LyfeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
```
        
</td>
</tr>
	<tr>
		<td>


The link beewteen ``<servlet>`` and ``<servlet-mapping>`` are defined by ``<servlet-name>``. 

In our case we link our ``LyfeCycleServlet.java`` (``LyfeCycleServlet.class``) with the url pattern ``/LyfeCycleServlet``

<br>

By the way ```<load-on-startup>1</load-on-startup>  ``` :

1 is the priority so if we have multiple ``servlet`` wich should ``load on startup`` then 1 will be launch before 2 etc...
        
</td>
		<td>

In this case the link is directly created inside the ``.java`` file
        
        
</td>
	</tr>
	</tbody>
</table>

Same servlet configuration can be done with ``@WebServlet`` annotation as shown below. ``@WebServlet`` annotation is highlighted below and all the attributes configured in ``web.xml`` are configured in annotation itself. With this approach, we need not to configure any entry in ``web.xml`` for Welcome Servlet.

* ``name`` - defines the name of servlet
* ``urlPatterns`` – maps the servlet to the pattern
* ``loadOnStartup`` – defines the value of load on start up
* ``description`` –description about servlet
* ``initParams`` – takes multiple ``@WebInitParam`` annotation

<br>
<br>

___

## Filter : @WebFilter

``@WebFilter`` annotation is the replacement of filter configuration in web.xml. When we annotate our filter class with ``@WebFilter`` annotation the container will be able to recognize this as a filter at the loading time.

Class annotated with ``@WebFilter`` still needs to implements the Filter interface with this annotation we can specify filter-name, url-mapping, description ,init params ,async supported etc

Same filter configuration can be done with ``@WebFilter`` annotation as shown below. ``@WebFilter`` annotation is highlighted below and all the attributes configured in ``web.xml`` are configured in annotation itself. With this approach , we need not to configure any entry in ``web.xml`` for ``MyFilter``.
* ``filterName``- defines the name of filter
* ``urlPatterns`` – maps the servlet to the pattern
* ``description`` – description about servlet
* ``initParams`` – takes multiple ``@WebInitParam`` annotation

<table align="center">
	<caption>comparison comparison beetween <code>web.xml</code> and <code>annotation</code></caption>
	<thead>
	<tr>
		<th><code>web.xml</code></th>
		<th><code>MyFilter.java</code></th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>

```xml
  <filter>
      <filter-name>MyFilter</filter-name>
      <filter-class>com.servlet.tutorial.MyFilter</filter-class>
      <init-param>
           <description>param 1 description</description>
           <param-name>param1</param-name>
          <param-value>value 1</param-value>
      </init-param>
       <init-param>
           <description>param 2 description</description>
           <param-name>param2</param-name>
          <param-value>value 2</param-value>
      </init-param>
  </filter>
  <filter-mapping>
      <filter-name>MyFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
```     
</td>
		<td>

```java
@WebFilter(
filterName="MyFilter",
urlPatterns="/*",
description="Filter description",
initParams={
@WebInitParam(name="param1",value="value 1",description="param 1 description "),
@WebInitParam(name="param2", value="value 2", description="param 2 description ")
})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized...");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter executing...");
        filterChain.doFilter(request, response);
    }
    @Override
    public void destroy() {
        System.out.println("Filter Destroyed..");
    }   
}
```
</td>
	</tr>
	</tbody>
</table>

<br>
<br>

___

## Filter & Servlet (initParams) : @WebInitParam
This annotation is used for init-param configurations of servlet. We can define multiple init parameters for a servlet which we can get in the servlet using servlet config object.

``@WebInitParam`` enables us to configure one init param and provides name , value and description attribute.

* ``Name`` – name of init param
* ``Value`` – value of init param
* ``Description`` – description of init param
One ``@WebInitParam`` annotation is needed for one init param tag and all ``@WebInitParam`` annotation are configured in initParams attribute of ``@WebServlet`` or ``@WebFilter`` annotation.

<table align="center">
	<caption>comparison comparison beetween <code>web.xml</code> and <code>annotation</code></caption>
	<thead>
	<tr>
		<th><code>web.xml</code></th>
		<th><code>MyFilter.java</code> and <code>MyServlet.java</code></th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>

For filter :
```xml
  <filter>
      <filter-name>MyFilter</filter-name>
      <filter-class>com.servlet.tutorial.MyFilter</filter-class>
      <init-param>
           <description>param 1 description</description>
           <param-name>param1</param-name>
          <param-value>value 1</param-value>
      </init-param>
       <init-param>
           <description>param 2 description</description>
           <param-name>param2</param-name>
          <param-value>value 2</param-value>
      </init-param>
  </filter>
  <filter-mapping>
      <filter-name>MyFilter</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
``` 

<br>

For Servlet
```xml
<servlet>
   <description>Welcome Servlet</description>
    <servlet-name>myServlet</servlet-name>
    <servlet-class>com.servlet.tutorial.WelcomeServlet</servlet-class>
<init-param>
<description> param1 </description>
      <param-name>Param1</param-name>
      <param-value>Param 1 Value </param-value>                       
    </init-param>
<init-param>
<description> param2 </description>
         <param-name>Param1</param-name>
      <param-value>Param 2 Value</param-value>
</init-param>
 <load-on-startup>1</load-on-startup>
 </servlet>
<servlet-mapping>
    <servlet-name>myServlet</servlet-name>
    <url-pattern>/WelcomeServlet</url-pattern>
</servlet-mapping>
```

</td>
		<td>

For Filter :
```java
@WebFilter(
filterName="MyFilter",
urlPatterns="/*",
description="Filter description",
initParams={
@WebInitParam(name="param1",value="value 1",description="param 1 description "),
@WebInitParam(name="param2", value="value 2", description="param 2 description ")
})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized...");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter executing...");
        filterChain.doFilter(request, response);
    }
    @Override
    public void destroy() {
        System.out.println("Filter Destroyed..");
    }   
}
```

<br>
For Servlet

```java
@WebServlet(name="/myServlet",
urlPatterns="/WelcomeServlet",
loadOnStartup=1,
description="Welcome Servlet", 
initParams={
@WebInitParam(name="Param1",value="Param 1 Value",description="param1"),
@WebInitParam(name="Param2",value="Param 2 Value",description="param 2")})
public class myServlet extends HttpServlet
{
```

</td>
	</tr>
	</tbody>
</table>

<br>
<br>

___

## WebListeners : @WebListener

``@WebListener``  annotation is the replacement of listener configuration in ``web.xml``. When we annotate our listener class with ``@WebListener`` annotation the container will be able to recognize this as a listener at the loading time. The class still needs to extend the appropriate listener class.

<table align="center">
	<caption>comparison beetween annotation and web.xml</caption>
	<thead>
	<tr>
		<th><code>anotation</code></th>
		<th><code>web.xml</code></th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>

```java
@WebListener
public class MyRequestListener implements ServletRequestListener {
```     
</td>
		<td>

```html
    <listener>
        <listener-class>com.tutorial.hello.listeners.MyRequestListener</listener-class>
    </listener>
```
</td>
	</tr>
	</tbody>
</table>

<br>
<br>

___

## @MultipartConfig

With Servlet 3.0 , there is an inbuilt support for File Upload.When this  annotation is added on the servlet, container knows that the Request this servlet is expecting will have multipart/form-data MIME data. This annotation can specify location to store the file on server, maxFileSize allowed for uploaded files, maxRequestSize allowed for multipart/form-data requets, and fileSizeThreshold after exceeding it the file content will be written on the disk.

<br>
<br>

<div align="center">

|[previous](./../JAVA_EE_-_Servlet_filter/Readme.md)|[index](./../Readme.md)|[next](./../JAVA_EE_-_Annotation_Details_in_Servlet_3/Readme.md)|
|---|---|---|




</div>

<br>
<br>


___

## Resource

* [Servlets - Annotations [tutorialspoint][EN]](https://www.tutorialspoint.com/servlets/servlets-annotations.htm)
* [Annotation Details in Servlet 3.0 [wideskills][EN][Servlet tutorial]](https://www.wideskills.com/servlets/annotation-details-in-servlet-3)