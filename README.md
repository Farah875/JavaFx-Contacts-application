# JavaFx-Contacts-application
A java application that represents a contacts application
The project is constructed from the main package “sample”, that contains:
•	The package “datamodel” having the classes: 
o	ContactData class.
o	Contacts class.
o	CSVAdd class.
o	CSVParser class.
o	JContact class.
o	JParser Class.
o	JSONAdd class.
o	IAdd interface.
o	IMap interface.
o	IParser interface.

•	CSVController class
•	CSVView.fxml
•	JSONController class
•	JSONView.fxml
•	Main class
•	Module-info.java

•	Module-info.java:
This java folder contains the required packages to run the main program.
•	Main class:
Overrides the application start method, to call the FXML launcher target file and creating the scene with the correct dimensions. 
Then start the message by calling the launch from the main method.
•	JSONView.fxml
Describes the Graphical user interface elements, their size and their positions.
•	CSVView.fxml
Describes the Graphical user interface elements, their size and their positions.
This view calls a different controller than the json view, and the main difference between these 2 is one additional field included in the json view. Other than that, they both have the same input methods same functions but called through different controllers.
•	JSONController class
Contains all the input text fields variables from the fxml file and 2 functions which each is called due to onAction event click on the corresponding button.
+ the readSearchFields() method will read all string inputs from the input text fields, and return them as one string for the ContactData class getSearchResult(String) method to find the matching contacts and get the result back from the same function and print it out in the provided text area.

+ the addNewElement() method that reads the input fields from the user of the contact information that would be added to the data, put them in a JContact class instance and add them to the specified file using the ConactData class object instance, through calling the method addNew (Contacts).
•	CSVController class
Contains the same methods and variables as JSONController class, but with one less field which is special for the JSON file.
•	ContactData class:
This class contains the most important methods that are the base of running the application and its file dependent, 
+ loadData() function, this function is used to call a class instance of the interface IParser in order to parse data from the specified file type class using the interface function Reader(), and returns an array list of the data parsed from the file.
+getSearchResult(String) function, first we create an array list and call the loadData() function to get the data we need, and this  is done on each search time, so if data is changed by adding values when we reapply a search it will load the file data again and contain the new data.
Then the input constraint string is split into a String array with all the values from the input.
Then we are going to use the IMap interface function mapping() by defining it where it maps each contact to its key index in the array list for later usage and mapping, 
Then n array list is created to contain all the matched keys with the search field constraints.
The pattern and matcher are created in order to take solve uncompleted search constraint fields with data, so if the name is not completed or any other field and its us a subpart from contact data, this data is considered matching.
Then the search criteria starts, if the first name field is a constraint , we will do a for loop over the data presented and if the value is not null and matches the patter from the input field constraint the index is added to the previously created array list as one of the matches.
Now the program has to search for matches with other field constraints of data already matched, but if the first field returns one match then this is the targeted, else if it is not a constraint all the data provided should be taken as matches for the first field, 
This criteria of looping over each field and taking the matching entries of the previously matched items if the input constraint is not null will continue over a loop till the input constraints field end, the comparison is done using the getElement(int) function method, so according to the constraint index the corresponding field is tested, this method returns the string field based on index.
In addition for the loop over all fields each time we are going to save the matches keys in a new array list and then compare it with the previous version if the new one is empty it is not taken else the array list of previous matches will have the current values, if only one key is matching then we will end the loop.
Remember that when testing we are in other fields rather than the first one, we don’t loop over all the data we just do it over the matching ones.
At the end a string having the output of the number of matches and the matches data is returned to be printed for the user.
+addNew(Contacts) this method use the interface IAdd and its add_contact(Contacts) method to add a new contact value to the data file, by using the defined method from corresponding data file class definition.
•	Contacts class:
It consists of four inner classes and that is for the purpose of organizing all the fields, 
The information inner class that contains the basic information fields of a contact with their getters and setters and a string return function that provides a string of all fields organized.
The PhoneInfo ineer class that contains 2 array lists one for the type and the other for the values, so the program could be extended to use more than 2 phone fields, with their getters and setters and a string return function that provides a string of all fields organized.
The Address inner class that contains the address data fields of a contact with their getters and setters and a string return function that provides a string of all fields organized.
The Organization inner class that contains the organization data fields of a contact with their getters and setters and a string return function that provides a string of all fields organized.
The Contacts class contains object instances of each of the used inner classes, the constructor creates the instance by creating the information class instance, and then 3 set functions that create the instances of the other 3 classes instances and that is all for the purpose of organizing the class, then we have 4 get functions that return the String return function of the class, 
And the most important function is the getElement(int) function that returns a string based on the index provided using the switch statement, this is for the purpose of testing so we can create a loop and each time just change the index rather than writing 24 get functions according to the targeted field.
•	JContact class:
Based on the fact that a json file could contain additional fields, ours Jason file contained one more filed for this purpose I used a JContact class that extends the parent class Contacts, having all the same characteristics, but with one more field, for this purpose the JContact constructor calls the super function which is the constructor of the parent class and then assigns the new field.
Then we override the two methods affected by this change which are, getElement(int), in this method the added field will have the highest index so the loop in the search criteria isn’t affected by this change.
And also override the getinformation() method to hold the information of the new field.
•	IParser interface:
This interface is used to be as a file dependent function calling for parsing data from the files having the undefined method reader().
•	IAdd interface:
This interface is used to be as a file dependent function calling for adding data to a file, using the undefined method add_contact(Contacts).
•	IMap interface:
This interface is used as a data from dependent object mapping the keys of objects to their data, with its undefined method mapping(). 



•	CSVParser class:
Implementation of the IParser interface for parsing data from a csv file by using the open csv reader library, the file is read using Input Stream Reader and each line is read using the CSVReader and a contacts class object instance is created and added to the returned array list.
•	JParser Class:
 Implementation of the IParser interface for parsing data from a json file by using the org.json.simple  library, 
An object instance is created and casted into an JSONARRAY and filled using the JSONParser(),
Then each json object is read from the json array and each field is read identified by its keyword from the json object and added to its appropriate place in the JContact object instance, and then adding this instance into the array list. 
•	CSVAdd class:
This class implements the IAdd interface add_contact() method, by reading the fields of the Contacts object instance and added into a string of comma separated values,
Then a writer object instance is created in append mode and the string created is added to the file. 
•	JSONAdd class:
This class implements the IAdd interface add_contact() method, and by using the simple json library, create a json object and fill it with all the fields with their corresponding keys, 
Then the JSON file is parsed into casted JSONARRAY and the created JSON Object is added at the end of the array and the using a writer object instance written back to the file.
