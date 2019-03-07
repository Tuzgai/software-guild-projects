Run the server with:

	java -jar hangmanserver-1.0-spring-boot.jar


Existing routes are as follows:


GET - http://localhost:8080/api/
	returns the following JSON:
	{
    	"guessedLetters": [], //A list of the letters already guessed
    	"hasWon": false, //True if the user has won
    	"hasLost": false, //True if the user has lost
    	"displayWord": "_______", //The currently known letters in the word, sends an underscore (_) for any unknown letter.  Will always be the correct length of the word being guessed.
    	"remainingGuesses": 6 //Number of guesses the user has left until they lose
    	"word": "" //Optional, when hasLost = true this will hold the word they were trying to guess
	}

POST 	- http://localhost:8080/api/start
		- http://localhost:8080/api/start?guesses=<number>
		Starts a new game by selecting a new word to guess and resetting all parameters.  If you do not send over a number of guesses to allow in the game it will default to 6.

POST	- http://localhost:8080/api/guess?ch=<character>
		Makes a guess of a single character, causing the game state to update.
		Will throw back a 422 error for several reasons:
			If you don't pass a character
			If you make a guess when you've lost
			If you make a guess when you've won
			If you guess a character you've already guessed
		Will throw back a 400 error if you send more then one character.