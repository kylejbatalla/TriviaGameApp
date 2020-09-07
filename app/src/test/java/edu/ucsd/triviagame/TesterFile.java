/*
 * File Name: TesterFile.java
 * Author: Kyle Batalla
 * Date: 9/7/2020
 * Description: This file serves as the tester file for the trivia game app.
 */
package edu.ucsd.triviagame;
import org.junit.*;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
/*
 * Class Name: TesterFile
 * Description: This class contains all necessary methods and member variables to run necessary tests
 */
public class TesterFile {
    //Instance declarations
    ShowResultsActivity object1;
    Questions object2;

    HashSet<Integer> set; //Used to check for duplicates
    int arr[]; //Used to store numbers for tests
    /*
     * Class Name: setUp
     * Description: Initializes instance and member variables to run necessary tests.
     * Parameters: None
     * Return: void
     */
    @Before
    public void setUp(){
        object1 = new ShowResultsActivity();
        object2 = new Questions();
        set = new HashSet<>();
        arr = object2.populateArray();
    }
    /*
     * Test Name: testRandomArray
     * Description: Tests that array size is 10.
     * Parameters: None
     * Return: void
     */
    @Test
    public void testRandomArray(){
        assertEquals(10, arr.length);
    }
    /*
     * Test Name: testDuplicates
     * Description: Tests for duplicates in random array generator. Passes if no duplicates are
     * found and fails if duplicates are found.
     * Parameters: None
     * Return: void
     */
    @Test
    public void testDuplicates(){
        boolean containsDuplicate = false;
        set.add(arr[0]);
        for(int i = 1; i < 10; i++){
            if(set.contains(arr[i])){ //Checks for duplicates in array
                containsDuplicate = true;
            }
        }
        assertEquals(false, containsDuplicate);
    }

}
