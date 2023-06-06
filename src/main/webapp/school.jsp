<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

#b{
background-color: red;
padding: 2px;
margin-right: 800px;
margin-left: 300px;
}

 #f
        {
            margin-left: 0px;
            margin-top: -70px;
        }
         #g
        {
            margin-left: 105px;
            background-color: green;
            color: aliceblue;
            margin-top: 10px;
        }
        
        #r
        {
            margin-left: 0px;
        }
         #t
        {
            margin-left: 105px;
            background-color: green;
            color: aliceblue;
            margin-top: 10px;
        }
        
        
        #j
        {
            margin-left: 0px;
        }
         #m
        {
            margin-left: 105px;
            background-color: green;
            color: aliceblue;
            margin-top: 10px;
        }
        
        #a{
        background-color: yellow;
        margin-top: -60px;
        
        }
        
        #d{
        margin-left: 246px;
        margin-top: -545px;
        margin-bottom: 0px
        }
        
        body {
background-color: #DBF9FC;
}

#w{
margin-left: 500px;
margin-top: -80px;
color: red;
}

#h{
margin-left: 1400px;
margin-top: -60px;
}

#l{
margin-right: 1400px;
margin-top: -18px;
}

#e{
margin-left: 700px;
}
        
</style>
</head>
<body>

<form action="saveAdmin" method="post">
<input type="submit">
</form>

<form action="saveTeacher" method="post">
<input type="submit">
</form>

<form action="saveStudent" method="post">
<input type="submit">
</form>

<div id="w">
<h1>INNOVATION PUBLIC SCHOOL</h1>
</div>

<div id="h">
<img alt="" src="https://png.pngtree.com/png-clipart/20211017/original/pngtree-school-logo-png-image_6851480.png" width="130" height="100">
</div>

<div id="a"> <div id="x"><h1>School Data Management System</h1></div>
    </div>
    
    <div id="l">
    <img alt="" src="data:image/png;base64,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" width="242" height="100">
    </div>
    
    <marquee> <h1>Welcome To The Login Page</h1></marquee>
    
    <form action="adminLogin" method="post">
     <div id="f">
            <h3>Admin LogIn</h3>
             <table>
             <tr>
                    <td>Email:</td>
                    <td><input type="email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="Password"></td>
                </tr>
            </table>
            <button id="g">submit</button>
            </form>
            
            <form action="teacherLogin" method="post">
            <div id="r">
            <h3>Teacher LogIn</h3>
             <table>
             <tr>
                    <td>Email:</td>
                    <td><input type="email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="Password"></td>
                </tr>
            </table>
            <button id="t">submit</button>
            </form>
            
            <form action="studentLogin" method="post">
            <div id="j">
            <h3>Student LogIn</h3>
             <table>
             <tr>
                    <td>Email:</td>
                    <td><input type="email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="Password"></td>
                </tr>
            </table>
            <button id="m">submit</button>
            </form>
            
            <div id ="d">
            <img alt="" src="https://media.istockphoto.com/id/1319938106/vector/school-building-facade-with-green-grass-and-trees-public-educational-institution-exterior.jpg?s=612x612&w=0&k=20&c=DwOHvs1pe1DemAymxwS6qg7nrgTw0CwLum_sqfB-H3U=" width="1280" height="500" />
    </div>
    
    <div id="e">
    <footer>
	<p>Created by Md Zakatullah. © 2023</p>
</footer>
<h5>School Address:Marathahalli,Bangalore</h5>
    </div>
  
</body>
</html>