<%@include file="navbar.jsp" %>

<%-- <%@ page import="java.sql.*" %>  

<%
if(session.getAttribute("login")!=null) //check login session user not access or back to register.jsp page
{
	response.sendRedirect("welcome.jsp");
}
%>


<%
try
{
	Class.forName("com.mysql.cj.jdbc.Driver"); //load driver
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmwayfresh","root","Password@123"); //create connection
	
	if(request.getParameter("btn_register")!=null) //check register button click event not null
	{
		String firstname,lastname,email,password;
		
		firstname=request.getParameter("txt_firstname"); //txt_firstname
		lastname=request.getParameter("txt_lastname"); //txt_lastname
		email=request.getParameter("txt_email"); //txt_email
		password=request.getParameter("txt_password"); //txt_password
		
		PreparedStatement pstmt=null; //create statement
		
		pstmt=con.prepareStatement("insert into login(firstname,lastname,email,password) values(?,?,?,?)"); //sql insert query
		pstmt.setString(1,firstname);
		pstmt.setString(2,lastname);
		pstmt.setString(3,email);
		pstmt.setString(4,password);
		
		pstmt.executeUpdate(); //execute query
		
		request.setAttribute("successMsg","Register Successfully...! Please login"); //register success messeage

		con.close(); //close connection
	}
}
catch(Exception e)
{
	out.println(e);
}
%>   --%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="<c:url value="/resources/css/login-register.css"/>" rel="stylesheet">
	
	<!-- javascript for registration form validation-->
	<script>	
	
		function validate()
		{
			var first_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
			var last_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
			var email_valid= /^[\w\d\.]+\@[a-zA-Z\.]+\.[A-Za-z]{1,4}$/; //pattern valid email validation
			var password_valid=/^[A-Z a-z 0-9 !@#$%&*()<>]{6,12}$/; //pattern password allowed A to Z, a to z, 0-9, !@#$%&*()<> charecter 
			
			var fname = document.getElementById("firstname"); //textbox id fname
            var lname = document.getElementById("lastname"); //textbox id lname
            var email = document.getElementById("emailId"); //textbox id email
            var password = document.getElementById("password"); //textbox id password
			
			if(!first_name.test(fname.value) || fname.value=='') 
            {
				alert("Enter Firstname Alphabet Only....!");
                fname.focus();
                fname.style.background = '#f08080';
                return false;                    
            }
			if(!last_name.test(lname.value) || lname.value=='') 
            {
				alert("Enter Lastname Alphabet Only....!");
                lname.focus();
                lname.style.background = '#f08080';
                return false;                    
            }
			if(!email_valid.test(email.value) || email.value=='') 
            {
				alert("Enter Valid Email....!");
                email.focus();
                email.style.background = '#f08080';
                return false;                    
            }
			if(!password_valid.test(password.value) || password.value=='') 
            {
				alert("Password Must Be 6 to 12 and allowed !@#$%&*()<> character");
                password.focus();
                password.style.background = '#f08080';
                return false;                    
            }
		}
		
	</script>	

</head>

<body>

    <br>

    <div class="main-content">

        <form class="form-register" method="post" onsubmit="return validate();">

            <div class="form-register-with-email">

                <div class="form-white-background">

                    <div class="form-title-row">
                        <h1>Register</h1>
                    </div>
				   
					<p style="color:green">				   		
					<%
					if(request.getAttribute("successMsg")!=null)
					{
						out.println(request.getAttribute("successMsg")); //register success message
					}
					%>
					</p>
				   
				   <br>
				   
                    <div class="form-row">
                        <label>
                            <span>Firstname</span>
                            <input type="text" name="firstname" id="firstname" placeholder="enter firstname">
                        </label>
                    </div>
					<div class="form-row">
                        <label>
                            <span>Lastname</span>
                            <input type="text" name="lastname" id="lastname" placeholder="enter lastname">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Email</span>
                            <input type="text" name="email" id="emailId" placeholder="enter email">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Password</span>
                            <input type="password" name="password" id="password" placeholder="enter password">
                        </label>
                    </div>
                    
                    <div class = "form-row">
                    	<label>
                    		<span style="padding-top:10px;">User Type</span>
                    		<select id = "userType" style = "width:230px; height:42px;">
                    			<option id = "choice" selected>Select a User Type</option>
                    			<option id = "choice" >Farmer</option>
                    			<option id = "choice" >Customer</option>
                    		</select>
                    	</label>
                    </div>
                    
                    <div class="form-row">
                        <label>
                            <span>Address</span>
                            <input type="text" name="address" id="address" placeholder="Apt., Bldg., Road, Town">
                        </label>
                    </div>
                    
                    <div class="form-row">
                        <label>
                            <span>City</span>
                            <input type="text" name="city" id="city" placeholder="enter city">
                        </label>
                    </div>
                    
                    <div class="form-row">
                        <label>
                            <span>Zipcode</span>
                            <input type="text" name="zipcode" id="zipcode" placeholder="enter zipcode/pincode">
                        </label>
                    </div>
                    
                    <div class="form-row">
                        <label>
                            <span>State</span>
                            <input type="text" name="state" id="state" placeholder="enter state">
                        </label>
                    </div>
                    
                    <div class="form-row">
                        <label>
                            <span>Country</span>
                            <input type="text" name="country" id="country" placeholder="enter country">
                        </label>
                    </div>

					<input type="submit" name="btn_register" value="Register">
					
                </div>
				
                <a href="login" class="form-log-in-with-existing">Already have an account? <b> Login here </b></a>

            </div>

        </form>

    </div>
    
    <br>

</body>

</html>


<%@include file="footer.jsp" %>