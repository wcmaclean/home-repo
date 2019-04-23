package examples.calculator;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;


/**
 * Modified from...
 *
 * The simplest possible servlet.
 *
 * @author James Duncan Davidson
 */

public class CalculatorServletEJB extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        ResourceBundle rb =
            ResourceBundle.getBundle("LocalStrings",request.getLocale());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        String title = "cheeze"; 

        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

        out.println("<h1>Cheeze</h1>");
        
        out.println("<a href=\"../../index.html\">");
        out.println("Link</a> to docs. <br><br>");



        Properties p = System.getProperties();

        out.println("CLASSPATH used by your servlet engine: ");
        out.println(p.getProperty("java.class.path"));

	out.println("<br>Calling the bean<br>");
/*
	try {
	    Properties props = System.getProperties(); 
	    // NOTE THAT YOU COULD ADD THIS TO THE RESOURCE BUNDLE (see above)
	    // INSTEAD OF HARDCODING IT
	    props.setProperty("java.naming.factory.initial",
		"weblogic.jndi.WLInitialContextFactory");
	    props.setProperty("java.naming.provider.url",
		"t3://localhost:9001");
	    InitialContext ctx = new InitialContext(props);
	    Object obj = ctx.lookup("HelloHome");
	    HelloHome home = 
		(HelloHome)javax.rmi.PortableRemoteObject.narrow(obj, 
			HelloHome.class);
	    Hello hello = home.create();
	    out.println("</p></p>Bean Returned: " + hello.hello());
	    hello.remove();
	} catch (Exception e) {
	    out.println(e);
	}
*/


        out.println("</body>");
        out.println("</html>");
    }
}



