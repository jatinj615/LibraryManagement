function checkUsername(){
	var xmlHttp;
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
		var usrname=encodeURIComponent(document.getElementById("username").value);
		
		xmlHttp.onreadystatechange=function()
		{
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			document.getElementById("userCheck").innerHTML=xmlHttp.responseText;
		}};
		xmlHttp.open("GET","CheckUsername?usr_name="+usrname,true);
		xmlHttp.send(null);
}