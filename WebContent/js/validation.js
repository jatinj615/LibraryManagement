/**
 * 
 */
function passwordValidate(){
	var newPass=document.resetPassword.newPassword.value;
	var confPass=document.resetPassword.confPassword.value;
	if(newPass != confPass){
		document.getElementById("passwordCheck").innerHTML="Password Does not match the above";
		return false;
	}
	return true;
}
function changePasswordValidate(){
	var curr_pass=document.changePassword.current_password.value;
	var new_pass=document.changePassword.new_password.value;
	var confirmNew_pass=document.changePassword.confirmNew_password.value;
	if(curr_pass == new_pass){
		document.getElementById("newPassCheck").innerHTML="New Password Cannot be same as old..!";
		return false;
	}
	if(new_pass != confirmNew_pass){
		document.getElementById("checkPass").innerHTML="Password Does not match the above";
		return false;
	}
	return true;
}
function addLibrarianFormValidate(){
		var x=document.add.email.value;
		var atposition=x.indexOf("@");
		var dotposition=x.indexOf(".");
		if(atposition < 1 || dotposition+2 >= x.length || dotposition < atposition+2){
			alert("Please Enter a valid Email Address !");
			return false;
		}
		var n=document.add.phoneNo.value;
		if(isNaN(n)){
			document.getElementById("numonly").innerHTML="Enter numeric values only";
			return false;
			}
		var p=document.add.password.value;
		if(p.length < 8){
			document.getElementById("pass").innerHTML="Password is Too Short..!";
			return false;
		}
		return true;
		}
function studentRegistrationValidate(){
	var p=document.stu_register.stu_password.value;
	var rp=document.stu_register.stu_rePassword.value;
	if(p.length < 8){
		document.getElementById("pass").innerHTML="Password is Too Short..!";
		return false;
	}
	if(p != rp){
		document.getElementById("checkPass").innerHTML="Password is not Same..!";
		return false;
	}
	var n=document.stu_register.stu_contact.value;
	if(isNaN(n)){
		document.getElementById("numonly").innerHTML="Enter numeric values only";
		return false;
	}
		var x=document.stu_register.stu_email.value;
		var atposition=x.indexOf("@");
		var dotposition=x.indexOf(".");
		if(atposition < 1 || dotposition+2 >= x.length || dotposition < atposition+2){
			alert("Please Enter a valid Email Address !");
			return false;
		}
		return true;
		}