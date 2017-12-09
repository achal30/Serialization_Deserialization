
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
For Deser Mode:
ant -buildfile src/build.xml run -Darg0=deser -Darg1=N -Darg2=../input.txt

For serDeser Mode:
ant -buildfile src/build.xml run -Darg0=serDeser -Darg1=N -Darg2=../input.txt

*NOTE* - Here N is the number of Objects you want to create, so replace N with integer value.
-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 12/08/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment.

I have used List as data structure to store the object. It becomes easy to compare using the equals method to check if the old list created 
is same as the new list generated.

deser will read the input.txt and it will print objects on stdout.
serDeser will generate output.txt and delete it after everytime you run it.


-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).


