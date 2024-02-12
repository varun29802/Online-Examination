<!DOCTYPE html>
<html lang="en">

<head>
    <link href="css/common.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f8ff; /* Light Blue */
            margin: 0;
            padding: 0;
            color: #333;
        }

        #maincontent {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            width: 80%;
            max-width: 600px;
        }

        h1 {
            color: #4682b4; /* Steel Blue */
            text-align: center;
            margin-bottom: 30px;
        }

        h2 {
            color: #4682b4; /* Steel Blue */
            text-align: center;
        }

        img {
            display: block;
            margin: 0 auto;
            width: 100px;
            height: 100px;
        }

        #remainingtime {
            color: #008000; /* Green */
            font-size: 20px;
            text-align: right;
            margin-top: 10px;
            margin-right: 20px;
        }

        form {
            text-align: center;
        }

        input[type="text"],
        input[type="radio"],
        input[type="submit"] {
            margin: 10px 0;
        }

        input[type="text"] {
            border: none;
            background-color: #87ceeb; /* Sky Blue */
            color: #fff;
            padding: 5px;
            width: 100%;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        span {
            display: inline-block;
            margin-right: 15px;
            font-size: 16px;
        }

        .btn {
            background-color: #4682b4; /* Steel Blue */
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #87ceeb; /* Sky Blue */
        }
    </style>

    <script>
        // Your existing JavaScript code here
        function displayTime()
					{
						sessionStorage.setItem("duration",sessionStorage.getItem("duration")-1);
						
						var remainingSeconds=sessionStorage.getItem("duration");//125

						var minutes=Math.floor(remainingSeconds/60);//125/60=2
						
						var seconds=remainingSeconds%60;//125/60=5

						//<p style="color:red" id="remainingtime">  </p>
						
						document.getElementById("remainingtime").innerHTML=" remaining time " + minutes + ":" + seconds;

						if(remainingSeconds==0)
						{
							location.href="/endexam";
						}
						
					}

					
					setInterval(displayTime,1000);/* 1000 ms - 1 sec . It means displayTime() will be called after every 1 second  */
					

					function changeColor()
					{
											
						var allAnswers=document.getElementsByTagName("span");
			
						var allRadioButtons=document.getElementsByName("submittedAnswer");	

					    var previousAnswer=document.getElementById("previousAnswer").value;
						
						for(var i=0;i<4;i++)
						{
								console.log(allAnswers[i].innerText.length)
								
								console.log(previousAnswer.length)
								
								if(allAnswers[i].innerText.trim()==previousAnswer.trim())
								{
									
									allAnswers[i].style.color="red";
									allRadioButtons[i].checked=true;
									break;
								}
						}
				     }
    </script>
</head>

<body onload="changeColor()">

    <img src="${imagepath}" alt="Image" width="100" height="100">
    
    <h4>Subject Name:- ${selectedsubject}</h4>

    <p id="remainingtime">Remaining Time: </p>

    <h1>Questions</h1>

    <h2>${message}</h2>

    <form>

        <div id="maincontent">

            <input type="text" name="qno" value="${question.qno}">
            <input type="text" name="qtext" value="${question.qtext}" size="50px"><br><br>

            <input type="radio" name="submittedAnswer" value="${question.op1}"><span>${question.op1}</span>
            <input type="radio" name="submittedAnswer" value="${question.op2}"><span>${question.op2}</span>
            <input type="radio" name="submittedAnswer" value="${question.op3}"><span>${question.op3}</span>
            <input type="radio" name="submittedAnswer" value="${question.op4}"><span>${question.op4}</span>

            <input type="hidden" name="answer" value="${question.answer}">
            <input type="hidden" id="previousAnswer" value="${previousAnswer}"><br><br>

            <input type="submit" value="Next" formaction="next" class="btn">
            <input type="submit" value="Previous" formaction="previous" class="btn">
            <input type="submit" value="End Exam" formaction="endexam" class="btn">

        </div>

    </form>

</body>

</html>