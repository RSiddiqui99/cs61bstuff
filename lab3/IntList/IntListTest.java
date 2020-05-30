import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testReverse()
    {
        IntList inputList =new IntList(3,new IntList(4,new IntList(5,new IntList(6,null))));
        IntList expectedList =new IntList(6,new IntList(5,new IntList(4,new IntList(3,null))));
        IntList inputListTwo=null;
        IntList expectedListTwo=null;
        IntList tempOne=inputList;
        IntList tempTwo=expectedList;

        //Test case 1
        inputList=inputList.reverse(inputList);
        tempOne=inputList; //Why do I have to assign tempOne again?

        while (tempOne!=null)
        {
            org.junit.Assert.assertEquals(tempTwo.first,tempOne.first) ;
            //System.out.println((tempOne.first));
            tempOne=tempOne.rest;
            tempTwo=tempTwo.rest;
        }

        System.out.println("Test Case Reverse Check: Passed");

        //Test case 2
        org.junit.Assert.assertEquals(inputList,expectedList);

        System.out.println("Test Case Destructive: Passed");

        //Test case 3
        inputListTwo.reverse(inputListTwo);

        assertEquals(null, IntList.reverse(null));

        System.out.println("Test Case Empty List: Passed");

    }


    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.of(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.of(1, 2, 3), L);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.of(1, 2, 3), A);
    }

    /** If you're running this from the command line, you'll need
      * to add a main method. See ArithmeticTest.java for an
      * example. */

}
