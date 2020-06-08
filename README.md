# Welcome to MDK - Dices Game !

Hi! This is a simple dices game freely hosted on **Heroku** at   [Dice Game](dices-game-jpa.herokuapp.com/). 
This project was initially done as an exercise in Java 8 / Spring Boot, but it has grow rapidly to add technologies, dependencies and a proper view to reach the actual state of nature.

Here you will find a mirror of the Repo that is deployed and running. You are welcome to explore, suggest, copy, maintain, learn etc. In order to keep it as a free and open source project, I have disabled the chance of playing twice with the same user. Security is enabled but for other reasons, and data base is not persisted after the app automatically turned off.
There are a few reasons behind this, like free hosting and because the spirit of this project is mostly oriented on, front and back integration, REST api exposure, testing etc.

If you want to learn about technologies involved, I will soon add some reference to nice and complete documentation, meanwhile feel free to fork, download or clone the repo, and play with. 

# Rules of the game
Yeah ... well ... the rules of the game are simple and if you do not like it, you can change them so ..... can you discover the rules in the code ?? in that case do not read the net sentence
> You win if you obtain 4 dices with same number or the addition is 16 or more
 
# Files 

You will find a **Maven** project that can be imported in your IDE of choice. It is ready to be served as it is. View resolution is handled with **Spring Web** (MVC) and also **Thymeleaf** to extend view resolution capabilities (check error page, or "/canvas").  

Generally speaking it is made with **Spring Data JPA** (you can find a JDBC older version of the project in my GitHub account) and an embedded Database **H2-Database**.

With minor changes in the code you can use **MySql Driver** that is commented, and extend persistent  capabilities, but I has keep it like this to simplify things to keep it publish in a free hosting. The database is initiated when application starts, and this happened every time server it is not being used for a while.

**Spring security** is also enabled but as I said before it is working only for administrator purposes of the game. If you are interested in extend the use of it, or make your users have the chance of re-logged to continue playing, check that JPA and JDBC have different approach to user data persistence, and choose a robust authentication method. **JWT** for example, is a very interesting approach, and you will find many examples on the web.

## Serve locally

**spring-boot-devtools** is still enabled to take advantage of hot swapping/live reload, very useful for developing process.

## Technology
### Front 
Responsive HTML, JS and CSS. Using Bootstrap v4, P5-JS, Animation.style, font-awesome and sweet-alert.
### Back
Java 8, Spring Boot, Thymeleaf, Spring Security, Spring Data JPA, H2-Database, Dev-Tools and Spring Starter Test


# Future of the project

### Back
I will be publishing soon a JDBC updated version, very useful to see differences between JPA - JDBC, and to show same examples of good practices on SQL queries implementation on services in the application to interact with  CrudRepositories. Meanwhile feel free to check the older version of Dice Game, (no view resolution, just REST controller) in my GitHub.

### Front
I love the angular approach, so soon the view will be an Angular application in REST communication with Dices Game. 

