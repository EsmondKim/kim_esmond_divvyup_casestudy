# DivvyUp App

## Table of Contents:

1. [Description](#description)
2. [Technical Overview](#Tech)
3. [Code Dev and Discussion](#Dev)
4. [YouTube](#YouTube)
5. [The Pages](#Pages)
6. [GitHub](#GitHub)
7. [LinkedIn](#LinkedIn)


## Description

The idea for this app came from a real life experience.  My friend invited about 10 people to a bachelor's dinner.  
It was a great event.  But what a buzzkill when the tab arrived and we wanted to split it 9 ways, while
dividing the Man of the Hour's tab up among us.  The waitstaff flat out declined to do this for us, so one
of my friends had to undertake the task with pen and paper.

User Story:
AS A waiter,
I WANT an app that takes the splitting of dining tabs out of my hands and diners' hands,
SO THAT I can smoothly receive payment from customers.

## Tech
Here's an Entity Relationship Diagram of the SQL schema for this project.  The project makes use of a join table and many-to-many relationships between tables.

![ERD](/src/main/webapp/public/images/PresentationERD.jpg)

Here's a wireframe of the pages within the app, including CRUD operations to the SQL servers.

![Wireframe](/src/main/webapp/public/images/divvyup_capstone.jpg)

## Dev

Dev for this project started on the backend, with planning of the SQL schema and ERD relationships.
From there, front end pages (JSP) and features were built in successive vertical stacks.  
For example, I focused on one feature, one controller route, and one CRUD through one DAO at a time throughout dev. 
I'm proud of what I built here, within the time constraints of the project, but of course, much more can be done and many more features added.

After this project, here are questions I have and things I'd like to know more about as I continue to grow as a Java dev.

(1) At one point, I was using a .stream(), Lambdas, Collectors.groupingBy and a Collectors.summingDouble within a service layer on the back end.
See this commit: https://github.com/EsmondKim/kim_esmond_divvyup_casestudy/commit/49fd16b1088782f00425b3bf008a4e4e83b99fb2
![Streams_and_Collectors](/src/main/webapp/public/images/streams.jpg)

I found this to require complicated asynchronous AJAX calls on the front end, one for each respective stream:
https://github.com/EsmondKim/kim_esmond_divvyup_casestudy/blob/618198fecd9a3d251091bd911e748f94ded650d1/src/main/webapp/public/scripts/divvyupscript.js

I was excited to try my hand at streams and Lambdas, since they are well suited for iteration and bulk data processing in Java.  
However, I found they made the front end a headache and were poorly suited for use with JSTL Taglibs and <c: forEach> loops.
I also found it cumbersome to chisel down into the resulting Maps, Arrays, and Lists of data structures on the Java side. 
I found it challenging to make the resulting data structures useful for iteration and computation and to package the data for consumption and rendering by the front end.
To grow as a dev, I'd like to know more about these issues, and I suspect on-the-job mentorship would facilitate that.

To streamline dev, I refactored to use Native SQL queries on the front end in the DAO layer:
https://github.com/EsmondKim/kim_esmond_divvyup_casestudy/commit/fc4788871da35f96dda10a16b2b1a397fd12b6e2
![Streams_and_Collectors](/src/main/webapp/public/images/nativeSQL.jpg)
I found the native SQL queries to be more reliable and easier to consume on the front end, as compared to the products of the Java .streams() and Collectors methods.

Finally, I did much mathematical computation on the front end.  It shows off some JavaScript skills, but I wonder, is this the best way to handle computations in an app like this?
Is this math better handled on the back end in Java and sent for consumption to the FE?
Likewise, I'd like to know more about the native query vs Java/Spring stream() methods issue.
I'm excited to work as a Java dev to get first-hand on-the-job experience in these areas.
Here's the relevant JavaScript.  I left the console.logs() in because they show the pseduo-coding that went into this dev task.
https://github.com/EsmondKim/kim_esmond_divvyup_casestudy/blob/40618c897b5cac194f595c4ca4d607734e522526/src/main/webapp/WEB-INF/jsp/personofthehour/personofthehour.jsp
![Streams_and_Collectors](/src/main/webapp/public/images/JavaScript.jpg)


## YouTube

https://www.youtube.com/watch?v=OhaOyPQwF4c

## Pages
Here are the pages of the app:

Employees land on the index page:

![Index](/src/main/webapp/public/images/index_cropped.jpg)

New employees can register to use the system.  This page uses a formbean, error validation, bindingresults, and JSTL.

![register](/src/main/webapp/public/images/register.jpg)

The users page is restricted to Admin users (managers) with the @PreAuthorize Spring Security tag.  Managers can remove employees from the system.

![add-item](/src/main/webapp/public/images/users.jpg)

Servers/employees/users of the app can add diners to a restaurant table for table service.

![adddiners](/src/main/webapp/public/images/adddiners.jpg)

Here is the menu page, where servers can see the diners at the table and add items to the table's order.

![menu](/src/main/webapp/public/images/menu.jpg)

This page displays your plain, ol' restaurant tab, which you'd get at any restaurant.

![tab](/src/main/webapp/public/images/tab.jpg)

The magic starts to happen at the DivvyUp page where users see the table's order broken out on a per-diner basis.

![divvyup](/src/main/webapp/public/images/divvyup.jpg)

The app lets users choose one diner as the "Person of the Hour", and that diner's tab is removed from the table's order and distributed evenly among the other diners' tabs.  
This is all happening within the JavaScript described in the Dev section above.

Before choosing the Person of the Hour:
![poth-before](/src/main/webapp/public/images/poth-before.jpg)

After selecting the Person of the Hour. The code dynamically removes the column of "Split" buttons from the table and changes the POTH's total to "Free" after the user clicks a "Split" button. 
![poth-after](/src/main/webapp/public/images/poth-after.jpg)

A search page where users can search the restaurant's menu for items.  Uses a GET CRUD and @RequestParam Spring annotation.

![search](/src/main/webapp/public/images/search.jpg)

The add item to menu page is restricted to Admin users (managers) with the @PreAuthorize Spring Security tag.  Managers can add dishes to the restaurant's menu.

![add-item](/src/main/webapp/public/images/add-item.jpg)

## GitHub

https://github.com/EsmondKim

## LinkedIn

www.linkedin.com/in/esmondkim

