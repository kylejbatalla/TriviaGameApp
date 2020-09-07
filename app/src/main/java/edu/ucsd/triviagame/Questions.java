/*
 * File Name: Questions.java
 * Author: Kyle Batalla
 * Date: 8/30/2020
 * Description: This file contains all questions and answers for each difficulty. The file
 *              contains a total of 90 questions and 360 possible answers. Ten questions are randomly
 *              generated and displayed to the user depended on what difficulty is chosen.
 */
package edu.ucsd.triviagame;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Random;
/*
 * Class Name: Questions
 * Extends: AppCompatActivity
 * Description: This class contains all necessary methods and instances for Questions
 */
public class Questions extends AppCompatActivity {

    public Random random = new Random();// Random instance used to generated random numbers

    public int[] arr = new int[10]; //Array that will hold random numbers 0-29
    public String[] easyQuestions = new String[10]; //Holds easy questions
    public String[] easyAnswers = new String[10]; //Holds easy question answers
    public String[][] easyChoices = new String[10][4]; //Holds easy answer choices

    public String[] mediumQuestions = new String[10]; //Holds medium questions
    public String[] mediumAnswers = new String[10]; //Holds medium question answers
    public String[][] mediumChoices = new String[10][4]; //Holds medium answer choices

    public String[] hardQuestions = new String[10]; //Holds hard questions
    public String[] hardAnswers = new String[10]; //Holds hard question answers
    public String[][] hardChoices = new String[10][4]; //Holds hard answer choices

//30 easy questions
public String easyQuestionsPool[] = {
       "What was the last U.S. state to enter the Union?",
       "What is the rarest blood type?",
       "In Greek mythology, who is known as God of the Sea?",
       "Who was the first man on the moon?",
       "What is the longest river in the world?",
       "What are the 3 primary colors?",
       "Which Robin Williams film feature him dressing as an old British nanny?",
        "How many years in a millennium?",
        "Which athlete is known as the fastest man in the world?",
        "Which artists is known as the King of Pop?",
        "Who is author of the famous Harry Potter novels?",
        "The Mona Lisa was painted by which famous artist?",
        "What is the longest running television show of all time?",
        "Kobe Bryant scored how many points in his last career game?",
        "The fastest land animal in the world is what?",
        "The Statue of Liberty in New York City was gifted from which country?",
        "Michael Jordan has how many NBA championships?",
        "The chemical symbol for hydrogen is?",
        "Meteorology is the study of?",
        "Which country is credited with the invention of tea?",
        "Labor day in the U.S. is in what month?",
        "Oktoberfest in Germany is celebrated with what drink?",
        "The most viewed Youtube video as of 2020 is what?",
        "Wolverine is played by which actor in the famous X-Men series?",
        "Who did Forbes name the youngest self-made billionaire in 2019?",
        "As of 2020, how many American presidents have been impeached?",
        "Steve Jobs passed away in what year?",
        "The Pyramids of Giza consists of how many main pyramids?",
        "WW1 started in what year?",
        "What is the tallest building in the world as of 2020?",

};
    //Easy answer choices for all easy questions
    public String easyChoicesPool[][] = {
            {"Hawaii", "Washington", "Alaska", "Oregon"},
            {"AB+", "AB-", "O+", "O-"},
            {"Poseidon", "Zeuz", "Ares", "Apollo"},
            {"Chris Hadfield", "Buzz Aldrin", "Neil Armstrong", "Alan Shepard"},
            {"Amazon", "Mississippi", "Congo", "Nile"},
            {"Red, Blue, Green", "Red, Yellow, Blue", "Red, Green, Yellow", "Red, Blue, Orange"},
            {"Dead Poets Society", "Jumanji", "Good Will Hunting", "Mrs. Doubtfire"},
            {"10", "100", "1,000", "10,000"},
            {"Usain Bolt", "Lebron James", "Cristiano Ronaldo", "Tyreek Hill"},
            {"Stevie Wonder", "Michael Jackson", "Prince", "Madonna"},
            {"Mark Twain", "Suzanne Collins", "George R.R. Martin", "J.K. Rowling"},
            {"Vincent Van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Michelangelo"},
            {"Family Guy", "The Simpsons", "South Park", "Futurama"},
            {"55", "59", "60", "65"},
            {"Panther", "Tiger", "Gazelle", "Cheetah"},
            {"France", "England", "Germany", "Russia"},
            {"4", "5", "6", "7"},
            {"He", "H", "Hf", "Ho"},
            {"Meteors", "Earth", "Weather", "Outer Space"},
            {"Japan", "India", "China", "Turkey"},
            {"August", "September", "October", "November"},
            {"Beer", "Whiskey", "Rum", "Mead"},
            {"Gangdam Style", "Baby Shark", "Despacito", "Shape of You"},
            {"Chris Pratt", "Hugh Jackman", "Chris Evans", "James McAvoy"},
            {"Kendall Jenner", "Jonathan Kwok", "Mark Zuckerberg", "Kylie Jenner"},
            {"3", "4", "5", "6"},
            {"2010", "2011", "2012", "2013"},
            {"1", "2", "3", "4"},
            {"1914", "1915", "1916", "1917"},
            {"One World Trade Center", "Shanghai Tower", "Ping'an Finance Center", "Burj Khalifa"},

    };
    //Answers for all easy questions
    public String easyAnswersPool[] = {
        "Hawaii", "AB-", "Poseidon", "Neil Armstrong", "Nile", "Red, Yellow, Blue",
            "Mrs. Doubtfire", "1,000", "Usain Bolt", "Michael Jackson", "J.K. Rowling",
            "Leonardo da Vinci", "The Simpsons", "60", "Cheetah", "France", "6", "H",
            "Weather", "China", "September", "Beer", "Despacito", "Hugh Jackman", "Kylie Jenner",
            "3", "2011", "3", "1914", "Burj Khalifa"

    };
    /*
     * Class Name: populateArray
     * Description: Populates array with random numbers 0-29. This array will be used to retrieve
     * random questions from the question pool. This function uses a hash set to make
     * sure duplicate numbers are not added.
     * Parameters: None
     * Return: None
     */
    public int[] populateArray(){
        int randomInt;
        arr = new int[10]; //Initializes array with random numbers to size 10
        HashSet<Integer> set = new HashSet<>(); //Hash set initialization to check to duplicates
        randomInt = random.nextInt(30); //Sets bound to 0-29
        for(int i = 0; i < 10; i++) {
            while (set.contains(randomInt)) { //Checks for duplicate in hash set
                randomInt = random.nextInt(30);
            }
            set.add(randomInt); //Adds random number to hash set
            arr[i] = randomInt; //Adds random number to array
            randomInt = random.nextInt(30); //Generates new random number
        }
        return arr;
    }
    /*
     * Class Name: populateEasyQuestions
     * Description: Populates easyQuestions array with questions
     * Parameters: None
     * Return: None
     */
    public void populateEasyQuestions(){
        for(int i = 0; i < 10; i++)
            easyQuestions[i] = easyQuestionsPool[arr[i]]; //Adds random question to array
    }
    /*
     * Class Name: populateEasyChoices
     * Description: Populates easyChoices with corresponding question
     * Parameters: None
     * Return: None
     */
    public void populateEasyChoices(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++){
                easyChoices[i][j] = easyChoicesPool[arr[i]][j]; //Adds question choices to array
            }
        }
    }
    /*
     * Class Name: populateEasyAnswers
     * Description: Populates easyAnswers array with correct answers
     * Parameters: None
     * Return: None
     */
    public void populateEasyAnswers(){
        for(int i = 0; i < 10; i++){
            easyAnswers[i] = easyAnswersPool[arr[i]]; //Adds correct answers to array
        }
    }
    /*
     * Class Name: getEasyQuestions
     * Description: Retrieves easy question at a specific index of the array
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the question returned
     */
    public String getEasyQuestions(int num){
        return easyQuestions[num];
    }
    /*
     * Class Name: getEasyChoices1
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the easy choice returned
     */
    public String getEasyChoices1(int num){
        return easyChoices[num][0];
    }
    /*
     * Class Name: getEasyChoices2
     * Description: Retrieves choice 2 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the easy choice returned
     */
    public String getEasyChoices2(int num){
        return easyChoices[num][1];
    }
    /*
     * Class Name: getEasyChoices3
     * Description: Retrieves choice 3 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the easy choice returned
     */
    public String getEasyChoices3(int num){
        return easyChoices[num][2];
    }
    /*
     * Class Name: getEasyChoices4
     * Description: Retrieves choice 4 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the easy choice returned
     */
    public String getEasyChoices4(int num){
        return easyChoices[num][3];
    }
    /*
     * Class Name: getEasyAnswers
     * Description: Retrieves correct answer for the corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the correct answer returned
     */
    public String getEasyAnswers(int num){
        return easyAnswers[num];
    }




    //30 medium questions
    public String mediumQuestionsPool[] = {
            "What is the second book in the bible?",
            "How many edges does a cube have?",
            "March Madness occurs in which college sports?",
            "Which continent is the most populous in the world?",
            "A tandoor is a type of what kitchen appliance?",
            "In Forrest Gump, what is Forrest's favorite past time?",
            "What is the capital of China?",
            "The Richter scale measures what natural phenomena?",
            "Which country has the longest coastline in the world?",
            "Spring equinox occurs in what month?",
            "Butterflies have how many legs?",
            "What is the best selling album of all time?",
            "Sicily is the largest island in which sea?",
            "What country does not make up the United Kingdom?",
            "What was the last video game console released by Saga in the United States?",
            "The longest bone in the human body is what?",
            "A victim of an April Fool's joke in England is referred to as what?",
            "What is the second planet from the sun?",
            "Which planet has the most moons?",
            "Pulp Fiction stars two hitmen Samuel L. Jackson and who else?",
            "What is the highest grossing movie of all time as of 2020?",
            "44th president Barack Obama was born in which state?",
            "\"The Answer\", is the nickname who which famous NBA player?",
            "What U.S. territory has the slogan, Where American's day begins?",
            "In tennis, a deuce is a score line of what?",
            "What headquarters of the United Nations is located in which city?",
            "There are a total of how many Harry Potter movies?",
            "In Spongebob Squarepants, what is the name of Plankton's computer wife?",
            "The 2 members of the 4 main Beatles still alive today as of 2020 are Paul McCartney" +
                    " and?",
            "The iPhone was first released in what year?"

    };
    //Answer choices for medium questions
    public String mediumChoicesPool[][] = {
            {"Exodus", "Genesis", "Numbers", "2nd Corinthians"},
            {"8", "12", "14", "16"},
            {"Baseball", "Football", "Tennis", "Basketball"},
            {"North America", "South America", "Asia", "Europe"},
            {"Oven", "Stove", "Refrigerator", "Microwave"},
            {"Swimming", "Reading", "Sleeping", "Running"},
            {"Shanghai", "Beijing", "Shenzhen", "Guangzhou"},
            {"Hurricanes", "Tornadoes", "Earthquakes", "Wildfires"},
            {"Russia", "Australia", "Canada", "China"},
            {"March", "April", "May", "June"},
            {"4", "6", "8", "10"},
            {"1 (Beatles)", "Dark Side of the Moon", "Back in Black", "Thriller"},
            {"Mediterranean Sea", "Black Sea", "Caspian Sea", "Tyrrhenian Sea"},
            {"Wales", "Northern Ireland", "Ireland", "England"},
            {"Genesis", "Saturn", "Dreamcast", "Game Gear"},
            {"Femur", "Tibia", "Fibula", "Ulna"},
            {"Dunce", "Noodle", "Hob", "Plonker"},
            {"Venus", "Mercury", "Mars", "Earth"},
            {"Saturn", "Neptune", "Uranus", "Jupiter"},
            {"George Clooney", "Morgan Freeman", "John Travolta", "Bruce Willis"},
            {"Avengers: Endgame", "Avatar", "Titanic", "Avengers: Civil War"},
            {"California", "Hawaii", "Texas", "Washington"},
            {"Kobe Bryant", "Carmelo Anthony", "Julius Earving", "Allen Iverson"},
            {"Northern Mariana Islands", "Guam", "Wake Island", "American Samoa"},
            {"15-15", "15-30", "30-40", "40-40"},
            {"New York City", "London", "Paris", "Berlin"},
            {"6", "7", "8", "9"},
            {"Karen", "Kelly", "Katie", "Kara"},
            {"George Harrison", "Ringo Starr", "Stuart Sutcliffe", "John Lennon"},
            {"2006", "2007", "2008", "2009"}

    };
    //Correct answers for medium questions
    public String mediumAnswersPool[] = {
        "Exodus", "12", "Basketball", "Asia", "Oven", "Running", "Beijing", "Earthquakes", "Canada",
            "March", "6", "Thriller", "Mediterranean Sea", "Ireland", "Dreamcast", "Femur",
            "Noodle", "Venus", "Jupiter", "John Travolta", "Avengers: Endgame", "Hawaii",
            "Allen Iverson", "Guam", "40-40", "New York City", "8", "Karen", "Ringo Starr", "2007"

    };
    /*
     * Class Name: populateMediumQuestions
     * Description: Populates mediumQuestions array with questions
     * Parameters: None
     * Return: None
     */
    public void populateMediumQuestions(){
        for(int i = 0; i < 10; i++)
            mediumQuestions[i] = mediumQuestionsPool[arr[i]];
    }
    /*
     * Class Name: populateMediumChoices
     * Description: Populates mediumChoices with corresponding question
     * Parameters: None
     * Return: None
     */
    public void populateMediumChoices(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++){
                mediumChoices[i][j] = mediumChoicesPool[arr[i]][j];
            }
        }
    }
    /*
     * Class Name: populateMediumAnswers
     * Description: Populates mediumAnswers array with correct answers
     * Parameters: None
     * Return: None
     */
    public void populateMediumAnswers(){
        for(int i = 0; i < 10; i++){
            mediumAnswers[i] = mediumAnswersPool[arr[i]];
        }
    }
    /*
     * Class Name: getMediumQuestions
     * Description: Retrieves medium question at a specific index of the array
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the question returned
     */
    public String getMediumQuestions(int num){
        return mediumQuestions[num];
    }
    /*
     * Class Name: getMediumChoices1
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the medium choice returned
     */
    public String getMediumChoices1(int num){
        return mediumChoices[num][0];
    }
    /*
     * Class Name: getMediumChoices2
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the medium choice returned
     */
    public String getMediumChoices2(int num){
        return mediumChoices[num][1];
    }
    /*
     * Class Name: getMediumChoices3
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the medium choice returned
     */
    public String getMediumChoices3(int num){
        return mediumChoices[num][2];
    }
    /*
     * Class Name: getMediumChoices4
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the medium choice returned
     */
    public String getMediumChoices4(int num){
        return mediumChoices[num][3];
    }
    /*
     * Class Name: getMediumAnswers
     * Description: Retrieves correct answer for the corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the correct answer returned
     */
    public String getMediumAnswers(int num){
        return mediumAnswers[num];
    }




    //30 hard questions
    public String hardQuestionsPool[] = {
            "On average, how many taste buds does the average adult have on their tongue?",
            "How many bits are in a byte?",
            "Who is credited with creating the world's first car?",
            "What is the capital of Paraguay?",
            "How long is the 90 Mile beach in New Zealand?",
            "Who was the first person so suggest Daylight Savings Times?",
            "Which land animal has the largest eyes?",
            "Which continent has hosted the Olympics the most times?",
            "Ancraophobia is the fear of what?",
            "What instrument is associated with Earl Bud Powell?",
            "\"The girl in the polka dot dress\" was an eyewitness to whose assassination?",
            "Caravaggio shared a first name with what other famous artist?",
            "Who painted the famous painting \"The Potato Eaters\"?",
            "From 1919 to 1933, the Weimar Republic was the government of what country?",
            "Who was the only British Pope?",
            "In Shawshank Redemption, the first thing Andy looks for is a what?",
            "What was the first movie to be rated PG-13?",
            "The term \"computer bug\" was derived from an actual bug found in a computer in 1947. What " +
                    "bug was it?",
            "Where in the human body would you find the medulla oblongata?",
            "When a hydrogen bomb is detonated, what gas is formed?",
            "Aconcagua is the highest mountain in the Andes. What country does it lie in?",
            "Elmas International Airport is located in which country?",
            "The world's largest ____  in London was made in 1988 to celebrated the " +
                    "re-release of Lady and The Tramp",
            "Which country consumes the most chocolate per capita?",
            "What is a duel between 3 people called?",
            "Arizona and what other U.S. state does not observe Daylight Savings Time?",
            "The first advertised toy on television was what?",
            "What is the smallest bone in the human body?",
            "Which country has the oldest continuously used national flag?",
            "What is the largest county in the United States?"
    };
    //Choices for hard questions
    public String hardChoicesPool[][] = {
            {"7,000", "10,000", "13,000", "15,000"},
            {"8", "16", "64", "256"},
            {"Henry Ford", "Nicolaus Otto", "Rudolf Diesel", "Carl Benz"},
            {"Rio de Janerio", "Buenos Aires", "Asuncion", "Santiago"},
            {"55 miles", "65 miles", "80 miles", "90 miles"},
            {"Nikola Tesla", "Thomas Edison", "Samuel Morse", "Benjamin Franklin"},
            {"Elephant", "Giraffe", "Walrus", "Ostrich"},
            {"Asia", "South America", "Europe", "Africa"},
            {"Fire", "Wind", "Water", "Clouds"},
            {"Piano", "Violin", "Guitar", "Trumpet"},
            {"Abraham Lincoln", "Martin Luther King Jr.", "John F. Kennedy", "James A. Garfield"},
            {"Vincent Van Gogh", "Michelangelo", "Rembrandt", "Titian"},
            {"Claude Monet", "Salvador Dali", "Vincent Van Gogh", "Pablo Picasso"},
            {"France", "Greece", "Poland", "Germany"},
            {"Pope Adrian IV", "Pope Sixtus IV", "Pope Innocent X", "Pope Paschal I"},
            {"Shank", "Dirt Shovel", "Scissors", "Rock Hammer"},
            {"Ferris Bueller's Day Off", "Gremlins", "Red Dawn (1984)", "Indiana Jones & The First Crusade"},
            {"Spider", "Moth", "House Fly", "Mosquito"},
            {"Brain", "Heart", "Kidney", "Liver"},
            {"Hydrogen", "Helium", "Oxygen", "Argon"},
            {"Peru", "Chile", "Ecuador", "Argentina"},
            {"Italy", "Greece", "Denmark", "Sweden"},
            {"Bowl of Soup", "Bowl of Spaghetti", "Bowl of Pasta", "Bowl of Lasagna"},
            {"Switzerland", "Sweden", "Denmark", "Finland"},
            {"Tri-duel", "Triel", "Truel", "Trial"},
            {"Oregon", "Hawaii", "Alaska", "New Mexico"},
            {"Mr. Potato Head", "G.I. Joe Figures", "Jack-in-the-Box", "Candy Land"},
            {"Incus", "Stapes", "Malleus", "Distal"},
            {"Finland", "Sweden", "Denmark", "Iceland"},
            {"Kern County", "Los Angeles County", "San Bernardino County", "Clark County"}


    };
    //Correct answers for hard questions
    public String hardAnswersPool[] = {
            "10,000", "8", "Carl Benz", "Asuncion", "55 miles", "Benjamin Franklin", "Ostrich",
            "Europe", "Wind", "Piano", "John F. Kennedy", "Michelangelo", "Vincent Van Gogh",
            "Germany", "Pope Adrian IV", "Rock Hammer", "Red Dawn (1984)", "Moth", "Brain",
            "Helium", "Argentina", "Italy", "Bowl of Spaghetti", "Switzerland", "Truel", "Hawaii",
            "Mr. Potato Head", "Stapes", "Denmark", "San Bernardino County"
    };
    /*
     * Class Name: populateHardQuestions
     * Description: Populates hardQuestions array with questions
     * Parameters: None
     * Return: None
     */
    public void populateHardQuestions(){
        for(int i = 0; i < 10; i++)
            hardQuestions[i] = hardQuestionsPool[arr[i]];
    }
    /*
     * Class Name: populateHardChoices
     * Description: Populates hardChoices with corresponding question
     * Parameters: None
     * Return: None
     */
    public void populateHardChoices(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++){
                hardChoices[i][j] = hardChoicesPool[arr[i]][j];
            }
        }
    }
    /*
     * Class Name: populateHardAnswers
     * Description: Populates hardAnswers array with correct answers
     * Parameters: None
     * Return: None
     */
    public void populateHardAnswers(){
        for(int i = 0; i < 10; i++){
            hardAnswers[i] = hardAnswersPool[arr[i]];
        }
    }
    /*
     * Class Name: getHardQuestions
     * Description: Retrieves medium question at a specific index of the array
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the question returned
     */
    public String getHardQuestions(int num){
        return hardQuestions[num];
    }
    /*
     * Class Name: getHardChoices1
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the hard choice returned
     */
    public String getHardChoices1(int num){
        return hardChoices[num][0];
    }
    /*
     * Class Name: getHardChoices2
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the hard choice returned
     */
    public String getHardChoices2(int num){
        return hardChoices[num][1];
    }
    /*
     * Class Name: getHardChoices3
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the hard choice returned
     */
    public String getHardChoices3(int num){
        return hardChoices[num][2];
    }
    /*
     * Class Name: getHardhoices4
     * Description: Retrieves choice 1 for corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the hard choice returned
     */
    public String getHardChoices4(int num){
        return hardChoices[num][3];
    }
    /*
     * Class Name: getHardAnswers
     * Description: Retrieves correct answer for the corresponding question
     * Parameters: int num, the index of the array the question is retrieved from
     * Return: String, the correct answer returned
     */
    public String getHardAnswers(int num){
        return hardAnswers[num];
    }
}