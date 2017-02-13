

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prasad.um.users.UserManagementHelper;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = new String();
		String middleName = new String();
		String lastName = new String();
		String action = new String();
		String dob = new String();
		String email = new String();
		String userID = new String();
		String password = new String();
		
		action = request.getParameter("action");
		firstName = request.getParameter("firstname");
		middleName = request.getParameter("middlename");
		lastName = request.getParameter("lastname");
		dob = request.getParameter("dob");
		email = request.getParameter("email");
		userID = request.getParameter("userid");
		password = request.getParameter("password");
		
		System.out.println("firstName: " + firstName);
		System.out.println("middleName: " + middleName);
		System.out.println("lastName: " + lastName);
		System.out.println("dob:" + dob);
		System.out.println("email: " + email);
		System.out.println("userID: " + userID);
		System.out.println("password: " + password);
		
		Map<String,String> userInput = new HashMap<String,String>();
		
		userInput.put("firstName", firstName);
		userInput.put("middleName", middleName);
		userInput.put("lastName", lastName);
		userInput.put("dob", dob);
		userInput.put("email", email);
		userInput.put("userID", userID);
		userInput.put("password", password);
		
		boolean isUserIDAvail = false ;
		
		isUserIDAvail = UserManagementHelper.isUserIDAvailable(userID);
		
		if(isUserIDAvail)
		{
			UserManagementHelper.newUserSignUp(userInput);
		}
		
	}

}
