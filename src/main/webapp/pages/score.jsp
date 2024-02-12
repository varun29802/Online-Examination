<html>

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <style>
        body {
            background-color: #f0f8ff; /* Light Blue */
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            color: #333;
        }

        table,
        th,
        td {
            border: 1px solid #008000; /* Green */
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        td {
            color: #0000ff; /* Blue */
            padding: 10px;
            text-align: center;
        }

        th {
            color: #ff0000; /* Red */
            padding: 10px;
            text-align: center;
        }

        span {
            color: #ff0000; /* Red */
            font-size: 30px;
            display: block;
            margin: 20px 0;
            text-align: center;
        }

        h1 {
            color: #008000; /* Green */
            text-align: center;
            margin-top: 50px;
        }

        a {
            text-decoration: none;
            font-size: 30px;
            color: #333;
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>

</head>

<body>

<span style="color:red;font-size: 30px"> Your score is ${score} </span>

<br><br>

<table>
		<tr>
			<th>qno</th>
			<th>question</th>
			<th>submittedAnswer</th>
			<th>OriginalAnswer</th>
		</tr>
		
		<c:forEach var="answer" items="${allanswers}">
			
				<tr>
						<td>${answer.qno}</td>
						<td>${answer.qtext}</td>
						<td>${answer.submittedAnswer}</td>
						<td>${answer.answer}</td>
				</tr>
					
		</c:forEach>
		
</table>


<h1>Want to attempt exam again?</h1>

<a href="/" style="text-decoration:none;font-size:30px;">Go to Login</a>
 
 <!-- 
 href attribute needs url 
text-decoration's none value remove underline from link
 -->

</body>


</html>