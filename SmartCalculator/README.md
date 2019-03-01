# Project in details

From the beginning of this project my motive was to use calculator more naturally in our personal computer. To make this phenomena possible I thought that there was nothing more natural to us then our language which is “string” in terms of a computer. So, I wanted to take strings from user and decode the string somehow to make the computer calculate the equation. For that I implemented POST-FIX method. But first I had to decode the string from user. Bellow is the graphical view of the process I did.

1. I tried to take string and split each character in it.

  string | split
  -------|--------
   "1+2" | \| 1 \| + \| 2 \|

  it was fine with single digit numbers(splitting each character). But when I used two or three digit numbers this is what happens

  string | split
  -------|--------
  "12+34" | \| 1 \| 2 \| + \| 3 \| 4 \|
  
  Computer takes each digit as a single number and the “POST-FIX” method fails to execute.
  
2. To solve this I made a method to explicitly to divide operator and operant and make space between them. Whenever the method finds an operator it makes space between them and returns the string and then I split the string (depending on spaces) to an array of Strings(not characters).
  
  USER | Method Returns | Splitting
  -------|--------------|-----------
  "12+34" | "12 + 34" |\| 12 \| + \| 34 \|
  
  This solved most of the problem however when user wants to give a negative value the program couldn't understand. 
  
  USER | Method Returns | Splitting
  -------|--------------|-----------
  "12^-5-70" | "12 ^ - 5 - 70" |\| 12 \| ^ \| - \| 5 \| - \| 70 \|
  
  This is how the program understand. It couldn't make difference between negative value and minus operator. 
  
3. I solved this problem by
	a. making minus operator negative value and giving + in front of them.
	b. if minus is in front of the equation making the first digit negative.
	c. if minus operator is in front of the  operators that handles negative value makes the next value negative.
	
  USER   | Method Returns | Splitting
  -------|----------------|-----------
  "-12^-5-70" | "-12 ^ -5 + -70" |\| -12 \| ^ \| -5 \| + \| -70 \|
  
  This makes all the errors clear for POST-FIX.
  
4. POST-FIX method was not invented for handling scientific operators such as power(^), sin, cos, tan etc. There are only hierarchy for only plus(+), minus(-), division(/), multiplication(*) and brackets(). For this I had to makes changes in the  hierarchy of POST-FIX method and change how to decode POST-FIX strings and do the calculation. The triangular operators(sin, cos, tan) takes only one operant where others take two. So I had to change the whole POST-FIX decryption method and make triangular operator take one operant. But still there was problem. The result I got was wrong.

  USER | Method Returns | POST-FIX | Giving Result | Acurate Result 
  -------|--------------|----------|---------------|----------------
  "2*5*sin(30)-1" | "2 * 5 * sin ( 30 ) - 1" | 2 5 * 30 sin 1 - * | -5.0 | -0.523
  
  Solution was if the operator is triangular operator and the following  operator is plus(+) or minus(-) it will compare both both triangular operator and its previous one. 
  
  USER | Method Returns | POST-FIX | Giving Result | Acurate Result 
  -------|--------------|----------|---------------|----------------
  "2*5*sin(30)-1" | "2 * 5 * sin ( 30 ) - 1" | 2 5 * 30 sin * 1 - | -0.523 | -0.523
  
  This was how I solved the encryption and decryption of the String using my own version of POST-FIX method.
5. Next challenge was to make a checker class to check if the string that the user gave was correct or not. So I checked these
	a. was the digits that I got was valid or not.
	b. was the operator was at the end or not. 
	c. was any operator placed at the front or end rather then opening brackets, closing brackets and minus.
	d. was any inappropriate operator faced in front of another operator.
	e. was the parenthesis placed properly. And so on.

  Each of the errors make error report to the user using appropriate reason. 

These are the major problems I faced in this project. But there were many more such as making “History.txt” file, printing results and errors on runtime in GUI, conversion of degree to radian in GUI and so on. I tried to solve each problem. There might be more bugs yet to be discovered and many solution yet to be made to make this the perfect smart calculator. This is an open platform for making any smart changes...
