# Trivia Mobile Application


Project video URL: https://youtu.be/jXhlcvCa5HU?si=SnNYraojAsY-kwTf

it comprises six(6) layouts, the main menu, leaderboard, login&register, forgot password, new user(Signup), and congrats.
the main menu has (2) buttons with intent that direct the user to either the leaderboard layout or the login layout.

the login&register layout has two(2) edit text, a button, and 2 text views with intent to other layouts,
the game can only be accessed if the user has an account in the database else a message will be displayed with a toast if a user tries an invalid login detail, if the user does not have an account clicking on the (new use(create an account))text view redirect to the new user layout.

the new user layout has five(5) edit text and a button, after all the fields are filled and the button is clicked the user details are stored in the database and usernames are unique if the username provided has been used the text view for username changes its text to user name exists with a red text color and all the text fields must have values

the forgot password layout has three(3) edit texts to change the user's forgotten password the username and phone number are required at first I did it so it only required the username but the user but if it was like that anyone can find someone username in the leaderboard and change there password which is wrong so I added a phone number column which provided more security for users information, so if username and phone number match the ones in the database the password would be changed to the new one it was set to.

The congrats layout only appears when the user answers all the questions in the main activity and the score has been updated.

the main activity layout displays the questions and four answers with one as the correct answer, there is a 15-second timer if the user fails to choose an answer before time runs out points will not be added, the correct answer will be highlighted,and it moves to the next question,

when the user gets to the end of the question the total score from all the correct answers will be stored in the score column in the database for the user who is logged in, If you want to know your standing amongst other users you can check the leaderboard, which can be accessed from the main menu

The leaderboard layout displays the top 10 players with the highest scores in the database

the database(DBHandler)
the DB handler class handles all the database functions as inserting into the database selecting values from the database to be displayed to users
the select statement was used in different places in the trivia game examples are the leaderboard to get the top 10 users with the highest scores, the select statement gets the users order them by there score and returns only the first 10 users, and they are displayed in the text views provided in the leaderboard layout.
If the game was just installed there would be no users, so the default text would be "No Player" with a default score of 0

It was also used to check if a username already existed in the database when a new user tried to create an account, it was used in the forgot password too to check if the password and phone number provided in the edit text were a match to user detail if its a match the password is changed with the update statement and set to a new password but if the password is not different from what was there before the user gets a toast and user would either change the password or use like that.


the Questions and Answers

the questions,answers, and options are stored in different arrays
the questions and answers are stored in a single dimensional array while the answers are stored in a multi-dimensional array
each question index is the same as the options array index, 
example: {index 0 question,index1 question} {{index 0 option1,index 0 option2,index 0 option3},{index 1 option1,index 1 option1,index 1 option1}} 
so the game starts from the 0 indexes to the last question index the answers are stored in a single-dimensional array, so when the user chooses an option and confirms it the text of the button is compared to the answer if they are the same the user is awarded a 5-points and the button turns green for 1-second then the question moves to the next one in the array, if there isn't any question in the array the user score is updated to the total score and the congrats layout is displayed, but if the user clicks the back button while the game is running a confirmation dialogue would pop up asking "Do you want to quit?" if the yes option is clicked the user progress would be lost and the score would not be recorded
