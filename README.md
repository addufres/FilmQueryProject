## Film Query Project

### Skill Distillery Homework

Create a Film query application that takes input from the user and returns search results into a mySQL database.

#### Project Description
This program prompts the user with a menu for 3 options. The user may choose to search for a film by ID number, search for films by use of a keyword or exit the program.

On either of the first two options the user is then prompted again for the corresponding input. Then is shown the output from their query. With the first option only the film with the matching ID is displayed. However, for the second option a list of films is displayed as many times multiple hits come from the keyword being searched.

The information displayed is the Title Year Rating Description and Cast. If no cast is listed then null is printed. The user is then presented a second menu asking if they would like to return to the main menu or see all details associated to the film or films found. 
If they choose to view them then all information is shown. 

These are both called from print methods within the film query app.

It uses: 
* OOP design
	* databaseaccessor class
	* interface for above classes methods
	* An actor and film class are both created
	* only a launch method is called in main.
* Takes input from a user through the use of the Scanner object.
* Call methods with parameters and call methods from objects.

##### Logic of calculations
The only logic needed to figure out this program were how to properly query from a mySQL database. This being so new took some patience but all worked out in the end.


#### How To Run This Project
Run this through the console in eclipse or the terminal by going to the proper directory and type ``java FilmQueryApp``


#### Lessons Learned and Struggles Encountered

Learned about the usefulness and how to navigate through a database a bit easier.
I wrote jUnit tests to help make sure I was getting proper output.
I can comfortably read a database schema and am starting to be able to visualize the structure in my head.

I ran into one issue with extra films being printed when no toString was being called. I understand the fix I used isn't best practice but I could not figure out another way. I created a toString in film that encompassed only what I wanted. Although I never call a toString in my program this seemed to fix the extra outputs. Debug mode wasnt much help in my search for the root of the issue. I can't seem to find where the program was calling for the extra films. Either way it is gone now.
