<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>forgotLMS</title>

<link rel="stylesheet" type="text/css" href="fpstyle.css">   

</head>
<body>
<form id="formForgotPassword" onsubmit="return validate()" action="ChangePasswordServlet">
	<div class="loginbox">
		 <h1>Library Management System</h1><br>
    <div>
      <span style="font-size: 17px;color: black;font-weight: bold;">Change Password</span>
    </div>
    <hr style="border-top: 2px solid #eee;"/>
		<br>
		<p class="login">
		
		<label>Username or Email Address</label>
				<input type="text" placeholder="Enter Name" id="user_email" name="user" size="40"><br />
				<span id="na"></span>
				</p>
				
				<p class="NewPassword">
				<label>New Password</label>
				<input type="password" placeholder="Enter New Password"  id="password" name="newpassword" size="40"><br />
				<span id="pw"></span>
				</p>
				
				<p class="Confirmpassword">
				<label>Confirm Password</label>
				<input type="password" placeholder="Confirm Password" id="confirmpassword" name="confirmpassword" size="40"><br />
				<span id="cpw"></span>
				<p>
				
				<input type="submit" value="Reset Password">
		</div>
		
</form>
<script>

function passwordConfirmation(){
	
	if(document.getElementById("password").value!=document.getElementById("confirmpassword").value){
		document.getElementById("cpw").innerHTML="Password does not match";
		document.getElementById("cpw").style.color='red';
		
	}
}

function validate(){
	var flagName=validateName(document.getElementById("user_email").value);
	var flagPassword=validatePassword(document.getElementById("password").value);
	console.log(flagName && flagPassword);
	if(flagName && flagPassword){
		return true;
	}	
	else{
		return false;
	}
}

function validateName(name){
	if(name.trim()!="")
		return true;
	else{
		document.getElementById("na").innerHTML="Enter your username."
		document.getElementById("na").style.color='red';
		return false;
	}
}

function validatePassword(password){
	if(password!="")
		return true;
	else{
		document.getElementById("pw").innerHTML="Enter password."
		document.getElementById("pw").style.color='red';
		return false;
	}
}

</script>

</body>
</html>