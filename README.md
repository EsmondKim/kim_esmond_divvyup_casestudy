# DivvyUp App

## Table of Contents:

1. [Description](#description)
2. [Technical Overview](#Tech)
3. [Code Dev and Discussion](#Dev)
4. [The Pages](#Pages)
5. [YouTube](#YouTube)
6. [Github](#Github)
7. [LinkedIn](#LinkedIn)


## Description

This app idea came from a real life experience.  My friend invited about 9 people to a bachelor's dinner.  
It was a great event.  But what a buzzkill when the tab arrived and we wanted to split it 8 ways, while
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
Lambdas vs SQL native and chiseling down into Java data. FE vs BE Math

## Pages
Here are the pages of the app:

Employees land on the index page:

![Index](/src/main/webapp/public/images/index_cropped.jpg)

New emloyees can register to use the system.  This page makes use of a formbean, error validation, bindingresults, and JSTL.

![register](/src/main/webapp/public/images/register.jpg)

Servers/emplioyees/users of the app can add diners to a restaurant table.

The users page is restricted to Admin users (managers) with the @PreAuthorize Spring Security tag.  Managers can remove employees from the system.

![add-item](/src/main/webapp/public/images/users.jpg)

![adddiners](/src/main/webapp/public/images/adddiners.jpg)

Here is the menu page, where servers can see the diners at the table and add items to the table's order.

![menu](/src/main/webapp/public/images/menu.jpg)

This page displays your plain, ol' restaurant tab, which you'd get at any restaurant.

![tab](/src/main/webapp/public/images/tab.jpg)

The magic starts to happen at the DivvyUp page where users see the table's order broken out on a per diner basis.

![divvyup](/src/main/webapp/public/images/divvyup.jpg)

The app lets users choose one diner as the "Person of the Hour", and that diner's tab is removed from the table's order and distributed evenly among the other diners' tabs.

Before choosing the Person of the Hour:
![poth-before](/src/main/webapp/public/images/poth-before.jpg)

After selecting the Person of the Hour
![poth-after](/src/main/webapp/public/images/poth-after.jpg)

A search page where users can search the restaurant's menu for items.  Uses a GET CRUD and @RequestParam Spring annotation.

![search](/src/main/webapp/public/images/search.jpg)

The add item to menu page is restricted to Admin users (managers) with the @PreAuthorize Spring Security tag.  Managers can add dishes to the restaurant's menu.

![add-item](/src/main/webapp/public/images/add-item.jpg)

## GitHub

https://github.com/EsmondKim

## LinkedIn

www.linkedin.com/in/esmondkim

##YouTube

[Link to YouTube demo of project.]: (https://www.youtube.com/watch?v=wA98BojvYpA&t=42s)

