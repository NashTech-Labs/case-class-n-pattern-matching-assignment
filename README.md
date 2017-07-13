The mid term exams of the students have just completed. Now the marking of the
answer sheets have been started and teachers are asking for a software systems
rather than old pen and paper style of giving marks to students.<br/>
<br/>
Now the main goal for you as software developers is to build a module, using
scala language, that represents the marks of the students in a rigid
systematic way and also design the functionalities to calculate marks, finding
best students etc <br/>
Like every other software we need to create our models first. The only field that must be in each model is id.

<b><i>Assignment 1:</i></b> We have created a trait called com.knoldus.kip.models.ModelIdentifier which has a
id called id. Below details must be captured in case classes by extending the ModelIdentifier trait.
<br/>
```
Subject :
	name 				//Subject name
	maxMarks			//maxMarks for a subject
	obtainedMarks		    	//Marks obtained by the student
	
Student :
	firstName 				//Student First Name
	middleName 				//Optional student middle Name
	lastName 				//Last Name
	rollNumber				//Class roll number for attendance
	age						//Optional student Age
	gender					//Gender of student
	enrollemntNumber	    //enrollemntNumber alloted during the admission
	address					//Optional address

Scorecard :
	student            // Student case class
	subjects             // Subject case classes
	total				//Total of marks
	percentage			//Percentage of student
	grade				//Grades of the student based on grades

	//Note : The subjects mentioned in the scorecard all should be of type
	//Subject case class, that is, you'll end using case class inside case
	//class

Course :
	name 				//Name of the course
	category			//category of the Course (like zoology, physics
					//hons, electrical engg etc)
	subjects        // Subject case classes

Course performance:
	year				// Year which has the performances
	course				// Course e.g. ECE, CSE etc.
	scoreCards			// Performance detail of the students

```

<b><i>Assignment 2:</i></b> Create a companion object of Scorecard. Override the apply method which would take the
student and subject object and returns a new Scoreboard object by filling the fields total, percentage grade.
<br/>

<b><i>Assignment 3:</i></b> The scoreboard case class must have two functions which would have the below functionality
1) Get the Subject which has the highest score.
2) Get the Subject which has the lowest score.
<br/>

<b><i>Assignment 4:</i></b> Student must have the below functions
 1) Get address should return either the address or N/A if not preset. Do not use, if-else, match case, getOrElse,
 and use fold with identity instead
 2) As you know middle name might contain more than one name, getMiddleName in Student class will return
 only the first middle name if it exist at all. Ideally you should use map function of Option for that.
<br/>

 For doing some database operation we have a object called RamDatabase which holds the
Course Performance case class in a list buffer. It has three functions add, update and get.
<br/>

<b><i>Assignment 5:</i></b> In the class Postman we have a method called getTheFirstAddressOfFirstYearPerformance
 whenever this function would be called with an id, first it will find the CoursePerformance from the RandomDatabase
 using the find function, then it gets the first scoreBoard by using the headOption function and then it must give us
 back the Address if exist. Ideally you should use map and flatMap for this.
<br/>

<b><i>Assignment 6:</i></b> Principal wants to know whats the result of CSE and he has a wild guess about the Course Performance
id. Find the performance from RamDatabase and using constant pattern matching findout if it really is CSE. If not
throw an exception.
<br/>

<b><i>Assignment 7:</i></b> Principal wants to know by guessing the id and the course name if it exist. And you should
help him by using Variable Pattern for this as well as handle the case if no course matched with a wildcard pattern.
<br/>

<b><i>Assignment 8:</i></b> Principal gives different expressions when he gets to discuss about different topics. His
expression like below.
1. When its about Student he says "Shut up <firstName>". Use constructor pattern, and return the expression as String
2. When its about Scoreboard he says "Hmmm .... <percentage>". Use constructor pattern, and return the expression as String
3. When its about Subject he says "aha <subject name>". Use constructor pattern, and return the expression as String
4. When its about anything else he says "!!! ???". Use constructor pattern, and return the expression as String
<br/>

<b><i>Assignment 9:</i></b> Principal checks scoreboard. It must return something like List["Nitin Java 90",
"Kunal Scala 99"], use pattern matching in "for expression".
<br/>

<b><i>Assignment 10:</i></b> Re do the principal expressions with partial function.