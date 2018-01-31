
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

I have used List as data structure to store the object. It becomes easy to compare using the equals method to check if the old list created 
is same as the new list generated.

deser will read the input.txt and it will print objects on stdout.
serDeser will generate output.txt and delete it after everytime you run it.


