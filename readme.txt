
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
For Debug Level 0(Release):
ant -buildfile src/build.xml run -Darg0=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/input.txt -Darg1=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/output.txt -Darg2=0

For Debug Level 1(In_State):
ant -buildfile src/build.xml run -Darg0=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/input.txt -Darg1=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/output.txt -Darg2=1

For Debug Level 2(In_Results):
ant -buildfile src/build.xml run -Darg0=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/input.txt -Darg1=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/output.txt -Darg2=2

For Debug Level 3(Data_Structure):
ant -buildfile src/build.xml run -Darg0=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/input.txt -Darg1=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/output.txt -Darg2=3

For Debug Level 4(Constructor):
ant -buildfile src/build.xml run -Darg0=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/input.txt -Darg1=/import/linux/home1/apatel58/cs542/achal_patel_assign_3/airportSecurityState/output.txt -Darg2=4

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

[Date: 12//2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment.



-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).


