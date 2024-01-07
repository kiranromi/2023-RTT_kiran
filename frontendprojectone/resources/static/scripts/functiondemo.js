/**
 * 
 */

function aFunction() {
	//document.getElementById("demo0").innerHTML = 5 < 6;
	//let value = document.getElementById("demo0").innerHTML = 5 < 6;
	document.write(document.getElementById("demo0").innerHTML = 5 < 6);
}
function aArithmetic() {
	document.getElementById("demo0").innerHTML = 4 + 7;
	document.getElementById("demo1").innerHTML = 7 - 4;
	document.getElementById("demo2").innerHTML = 4 * 7;
	document.getElementById("demo3").innerHTML = 16 / 8;
	document.getElementById("demo4").innerHTML = 5 % 3;
}

function compareOperators() {
	let number = "3";
	document.getElementById("demo0").innerHTML = number === 3;
	document.getElementById("demo1").innerHTML = 10 < 3;
	document.getElementById("demo2").innerHTML = 78 >= 90;
	document.getElementById("demo3").innerHTML = 56 <= 44;
	document.getElementById("demo4").innerHTML = 10 == 10;
	document.getElementById("demo5").innerHTML = 10 != 30;


}
function logicalOperators() {
	document.getElementById("demo0").innerHTML = (3 > 2 && 6 == 6);
	document.getElementById("demo1").innerHTML = (3 > 2 && 6 == 7);
	document.getElementById("demo2").innerHTML = (3 > 2 || 6 == 7);
	document.getElementById("demo3").innerHTML = (3 > 2 || 6 == 6);
	document.getElementById("demo4").innerHTML = !(3 < 2 && 6 != 6);

}

function concatenation() {
	document.getElementById("demo5").innerHTML = "Good Afternoon" + "World"; 
	}
	
function ifStatement(){  
	let number = 14;
	if(number >= 25){
	document.getElementById("demo0").innerHTML = number;
		
	}else {
		document.getElementById("demo0").innerHTML = "This number "+ number + " is less than and not equal to 25";
	}
}	
	
function ifElseFunction(){
	let ch = "A";
	let index = 0;
	let number = ch.charCodeAt(index);
	if(number == 0){
	document.getElementById("demo0").innerHTML = number + "is equal to zero";
	}else if ( number > 0){
		document.getElementById("demo0").innerHTML = number + "is greater than  zero";
	}else if ( number < 0){
		document.getElementById("demo0").innerHTML = number + "is less than  zero";
}	
}
function switchFunction(){
	let x = 5;
	let y = 4;
	let operand = "*";
	switch(operand){
	 case "+" :
	 document.getElementById("demo0").innerHTML = x+y;
	 break;
	 case "-":
	 document.getElementById("demo0").innerHTML = x-y;
	 break;
	  case "/":
	 document.getElementById("demo0").innerHTML = x/y;
	 break;
	  case "*":
	 document.getElementById("demo0").innerHTML = x*y;
	 break;
	   case "%":
	 document.getElementById("demo0").innerHTML = x%y;
	 break;
	 default:
		  document.getElementById("demo0").innerHTML = "invalid Operand";
	 break;
		 }
}
function whileLoopFunction(){
	const RATE = 5;
	const  INITIAL_BALANCE = 10000;
	const TARGET = 2 * INITIAL_BALANCE;
	let balance = INITIAL_BALANCE
	let year = 0;
	while(balance < TARGET){
		let interest = balance * RATE / 100;
		balance = balance + interest;
		year++;
	}
	  document.getElementById("demo0").innerHTML = "This investment doubled after " + year + "years. The balance is now" + balance.toFixed(2);	
	}
function forLoopFunction(){
	for(let index = 10; index >=0; --index){
		document.write(index + "<br>");
	}
}
function doWhileLoopFunction(){
	let number = prompt("Enter number");
	number = parseInt(number);
	do{ 
		document.write("printing <br>");
		number++;
		}
    while(number < 10);
}