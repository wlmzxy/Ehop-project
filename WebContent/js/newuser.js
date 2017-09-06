$(function(){
	document.getElementById("img").onclick=function(){
		this.src="codesservlet?id="+Math.random();
	}
		//验证邮箱
		document.querySelector("#email").onblur=function(){
		var text=document.getElementById("checkemail");
		var email=document.querySelector("#email").value;
		var reg=/(\w)+@(\w)+.(com|org|net|gov)$/;
		//验证格式
		if(email==null){
			text.innerHTML="<font color='red'>"+"邮箱不能为空"+"</font>";
			return false;
		}else if(email.match(reg)==null){
			text.innerHTML="<font color='red'>"+"邮箱格式不正确"+"</font>";
			return false;
		}else{
		//验证是否已被使用
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.open("get", "checkservlet?type=email&email="+email, true);
		xmlhttp.send(null);
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
				var respose=xmlhttp.responseText;
				if(respose=="0"){
					text.innerHTML="<font color='red'>"+"此邮箱已被使用,请更换邮箱"+"</font>";
					return false;
				}else if(respose=="1"){
					text.innerHTML="<font color='green'>"+"此邮箱未被使用,可用"+"</font>";
					return true;
				}
			}
		}
	}
}		
		//验证用户名
		document.querySelector("#loginid").onblur=function(){
			var text=document.getElementById("checkloginid");
			var loginid=document.querySelector("#loginid").value;
			var reg=/^(\w)$/;
			//验证格式
			if(loginid==null){
				text.innerHTML="<font color='red'>"+"会员名不能为空"+"</font>";
				return false;
			}else if(loginid.length<3){
				text.innerHTML="<font color='red'>"+"长度不能小于3"+"</font>";
				return false;
			}else if(reg.test(loginid)){
				text.innerHTML="<font color='red'>"+"只能是数字和字母"+"</font>";
				return false;
			}else{
			//验证是否已被使用
			var xmlhttp=new XMLHttpRequest();
			xmlhttp.open("post", "checkservlet", true);
			var data="type=loginid&loginid="+loginid;
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=utf-8");
			xmlhttp.send(data);
			xmlhttp.onreadystatechange=function(){
				if(xmlhttp.readyState==4&&xmlhttp.status==200){
					var respose=xmlhttp.responseText;
					if(respose=="0"){
						text.innerHTML="<font color='red'>"+"此用户名已被使用,请更换用户名"+"</font>";
						return false;
					}else if(respose=="1"){
						text.innerHTML="<font color='green'>"+"此用户名未被使用,可用"+"</font>";
						return true;
					}
				}
			}
		}
	}
});
