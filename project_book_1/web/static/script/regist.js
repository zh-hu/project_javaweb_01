function $(id){
    return document.getElementById(id)
}
function preRegit(){
    //用户名应为6~16位数组和字母组成
    var unameTxt = $("unameTxt")
    var unameReg = /[0-9a-zA-Z]{6,16}/gim;
    var uname = unameTxt.value;
    var unameSpan = $("unameSpan");
    if(!unameReg.test(uname)){
        unameSpan.style.visibility="visible";
        return false;
    }else {
        unameSpan.style.visibility="hidden";
    }
    //密码的长度至少为8位
    var pwdTxt=$("pwdTxt")
    var pwd = pwdTxt.value;
    var  pwdReg = /[\w]{8,}/;
    var pwdSpan = $("pwdSpan")
    if(!pwdReg.test(pwd)){
        pwdSpan.style.visibility="visible"
        return false;
    }else {
        pwdSpan.style.visibility="hidden";
    }
    //两次密码输入不一致
    var pwd1 = $("pwdTxt1").value ;
    var pwdSpan1 = $("pwdSpan1") ;
    if(pwd1!=pwd){
        pwdSpan1.style.visibility="visible";
        return false ;
    }else{
        pwdSpan1.style.visibility="hidden";
    }
    //请输入正确的邮箱格式
    var email = $("emailTxt").value ;
    var emailSpan = $("emailSpan");
    var emailReg = /^[a-zA-Z0-9_\.-]+@([a-zA-Z0-9-]+[\.]{1})+[a-zA-Z]+$/;
    if(!emailReg.test(email)){
        emailSpan.style.visibility="visible";
        return false ;
    }else{
        emailSpan.style.visibility="hidden";
    }
    return true;
}


//如果想要发送异步请求，我们需要一个关键的对象xmlhttprequest
var xmlHttpRequest;
function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DMO2标准浏览器xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest();
    }else if(window.ActiveXObject){//IE浏览器
        try {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP")

        }   catch (e){
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

function ckUname(uname){
    createXMLHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname ;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB ;
    //发送请求
    xmlHttpRequest.send();
}

function ckUnameCB(){
    if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
        //xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
        //alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText ;
        // {'uname':'1'}
        //alert(responseText);
        if(responseText=="{'uname':'1'}"){
            alert("用户名已经被注册！");
        }else{
            alert("用户名可以注册！");
        }
    }
}
