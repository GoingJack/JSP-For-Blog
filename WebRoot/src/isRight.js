 function checkName()
    {
    	var name=document.getElementById("visitorid").value;
    	//用户名的规则： 昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号
    	var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/i;
		if(reg.test(name))
			{
			document.getElementById("namespan").innerHTML="合法√".fontcolor("green"); 
			return true;
			}
		else
			{
			//alert("昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号");  
			document.getElementById("namespan").innerHTML="昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号".fontcolor("red");
			return false;  
			}
    }
		function checkPasswd()
		{
			var password = document.getElementById("password").value;  
		    //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
		    var reg = /^([a-zA-Z0-9]){6,16}$/i;      
		    if(reg.test(password)){  
		        //符合规则     
		        document.getElementById("passwdspan").innerHTML="合法√".fontcolor("green");
		        return true;  
		    }else{  
		        //不符合规则  
		       // alert("密码的长度为 6-16，包含任意的字母、数字，不可以使用其他符号");
		        document.getElementById("passwdspan").innerHTML="密码的长度为 6-16，包含任意的字母、数字，不可以使用其他符号".fontcolor("red");
		        return false;  
		    }
		}
		    function checkSame()
		    {
		    	var password=document.getElementById("password").value;
		    	var repassword=document.getElementById("repassword").value;
		    	if(password==repassword)
		    		{
		    			document.getElementById("repasswdspan").innerHTML="合法√".fontcolor("green");
		    			return true;
		    		}
		    	else
		    		{
		    		 	//alert("俩次输入的密码不一致!");
		    		 	document.getElementById("repasswdspan").innerHTML="俩次输入的密码不一致!".fontcolor("red");
		    			return false;
		    		}
    }
		    function checkNicheng()
		    {
		    	var name=document.getElementById("Nicheng").value;
		    	//用户名的规则： 昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号
		    	var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/i;
				if(reg.test(name))
					{
					document.getElementById("Nichengspan").innerHTML="合法√".fontcolor("green"); 
					return true;
					}
				else
					{
					//alert("昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号");  
					document.getElementById("Nichengspan").innerHTML="昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号".fontcolor("red");
					return false;  
					}
		    }
		    function checkAll()
		    {
		    	
		    	var name=checkName();
		    	var password=checkPasswd();
		    	var repassword=checkSame();
				var Nicheng=checkNicheng();
		    	if(name&&password&&repassword&&Nicheng)
		    		{
		    		return true;
		    		}
		    	else
		    		{
		    		return false;
		    		}
		    }