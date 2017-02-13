

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prasad.um.authentication.LoginValidation;
import com.prasad.um.users.UserBase;
import com.prasad.um.users.UserManagementHelper;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Test Servlet.....");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		List<Person> person_m = new ArrayList<Person>();
//		
//		person_m = UserManagementHelper.getAllUsers() ;
//		
//		for(Person person:person_m)
//		{
//			System.out.println(person.toString());
//			int userId = person.getPersonId() ;
//			Integer Id = new Integer(userId);
//			String userIdStr = Id.toString() ;
//			String dobStr = person.getDateOfBirth().toString() ;
//			response.getWriter().append("UserId:").append(userIdStr);
//			response.getWriter().append("  ");
//			response.getWriter().append("FirstName:").append(person.getFirstName());
//			response.getWriter().append("  ");
//			response.getWriter().append("MiddleName:").append(person.getMiddleName());
//			response.getWriter().append("  ");
//			response.getWriter().append("LastName:").append(person.getLastName());
//			response.getWriter().append("  ");
//			response.getWriter().append("DateOfBirth:").append(dobStr);
//			response.getWriter().append("\n");
//			response.encodeURL("http://localhost:8080/HouseHoldManagementPortal/prasad.html");
//			
//		}
		
//		response.sendRedirect("prasad.html");
		String action = new String();
		action = request.getParameter("action");
		System.out.println("action = " + action);
		
		String userName = new String();
		userName = request.getParameter("username");
		System.out.println("userName = " + userName);
		
		String passWord = new String();
		passWord = request.getParameter("password");
		System.out.println("passWord = " + passWord);
		
		boolean isUserAuthorized = false ;
		isUserAuthorized = LoginValidation.isUserAutherized(userName, passWord);
		
		if(isUserAuthorized)
		{
			List<UserBase> users = new ArrayList<UserBase>();
			
			users = UserManagementHelper.getAllUsers() ;
			
			request.setAttribute("users", users);
			RequestDispatcher view = request.getRequestDispatcher("users.jsp");
			view.forward(request, response);
//			response.sendRedirect("welcome.html");
		}
		else
		{
			response.sendRedirect("notauthorized.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
