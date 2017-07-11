The mid term exams of the students have just completed. Now the marking of the
answer sheets have been started and teachers are asking for a software systems
rather than old pen and paper style of giving marks to students.<br/>
<br/>
Now the main goal for you as software developers is to build a module, using
scala language, that represents the marks of the students in a rigid
systematic way and also design the functionalities to calculate marks, finding
best students etc (requirements declared below)<br/>
<br/>
Use **case** classes to represent the attributes of subjects, student, scorecard
and course. The minimum expected attributes of these entities are-<br/>
<br/>
```
Subject :
	name 				//Subject name
	id				//Subject ID
	maxMarks			//maxMarks for a subject
	obtainedMarks		    	//Marks obtained by the student
	
Student :
	name 				//Student Name
	rollNumber			//Class roll number for attendance
	age				//Student Age
	gender				//Gender of student
	enrollemntNumber	    	//enrollemntNumber alloted during the admission

Scorecard :
	nameOfStudent		    	//Name of student
	rollNumber			//Roll Number (you can add enrol. no. too)
	subject1			//Subject from chosen course
	subject2			//Subject from chosen course
	subject3			//Subject from chosen course
	subject4			//Subject from chosen course
	subject5			//Subject from chosen course
	subject6			//Subject from chosen course
	total				//Total of marks
	percentage			//Percentage of student
	grade				//Grades of the student based on grades

	//Note : The subjects mentioned in the scorecard all should be of type
	//Subject case class, that is, you'll end using case class inside case
	//class

Course :
	name 				//Name of the course
	id 				//ID of the course
	category			//category of the Course (like zoology, physics
					//hons, electrical engg etc)

```
**Objective :**<br/>
<br/>
a)  Create the `trait`'s for defining the functionalities/characterisitics for<br/>
the entitites decared above.<br/>
<br/>
b) Create the **case** classes for all of the entities mentioned above. These case<br/>
classes should extend their respective trait classes. Example, Course can<br/>
be a trait having its methods declared inside it and then define the case<br/>
class for actual course entity that extends that trait and implement the method for<br/>
that particular course.<br/>
<br/>
c) Imlement the methods, defined in the trait, in the case classes.<br/>
<br/>
d) Define the `apply()` methods of the case classes to construct the factory
objects of those classes. For example, define the apply() method of the
Scorecard case class that takes the marks of the subjects (along with student
details) and calculates the total, grades and percentage inside the apply
method and save the values of the those attributes accordingly.
<br/><br/>
e) Create a business logic to store the Scorecard's of all the students in scala collection object e.g. List, Map, Set
etc according to the need and find write the methods to find -<br/> 
1.) the best three students of the class.<br/>
2.) list of failed students<br/>
3.) no of students who passed<br/>
4.) no of students who failed<br/>
5.) list of students who attained a particular aggregate grade , e.g. **A-**, **C+** etc<br/>
6.) no of students who attained greater/lesser than a particular aggregate percentage , e.g. **90**, **75** etc<br/>
7.) list of students who attained greater than a particular aggregate percentage , e.g. **90**, **75** etc<br/>
8.) list of students who attained lesser than a particular aggregate percentage , e.g. **70**, **60** etc<br/>

It's not necessary that all the courses have fixed number of subjects. There can be more or less
than 6 subjects in a course.

**Instructions:** 1. Use the `map` over `Option` type in order to read the values inside them rather then `.get()` method<br/>
2.) Use flatMap wherever needed to eliminate the complexity of the collections.<br/>
3.) Use Pattern-Matching with Option type<br/>
4.) Use the fold and identity with Option type<br/>
5.) Create a Partial Function (inside the business logic) to deal with different courses<br/>
6.) Demonstrate the use of **`for`** expression with pattern Matching. Get help <a href="http://www.artima.com/weblogs/viewpost.jsp?thread=281160">from here</a><br/>
7.) Use wildcard pattern (**`case _ =>`**)<br/>
8.) Use constant pattern (**`case {some_constant} =>`**)<br/>
9.) Use variable pattern (**`case {someVariable} =>`**)<br/>
10.) Use constructor pattern (**`case {SomeClass(param1, param2, param3 .... paramN)} =>`**)<br/>
11.) Don't use `if-else`. Use the `match-case` instead wherever possible.

>>[1] A student is considered failed if he fails even in one subject.<br/>

>>[2] To see how things are working have a look at test cases.<br/>

>>[3] Grades criteria :<br/>
    A+  >= 95%<br/>
    A   >= 90%<br/>
    B+  >= 85%<br/>
    B   >= 80%<br/>
    C+  >= 70%<br/>
    C   >= 60%<br/>
    D+  >= 50%<br/>
    D   >= 40%<br/>
    F   <  40%<br/>
    
>>[4] Follow the project structure strictly. Write logic for the created public methods. 
You can create your own private methods.