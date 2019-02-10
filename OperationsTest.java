
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class OperationsTest.
 *
 * @author  Delenda "Pineapple McGee" Joseph for Group Hero
 * @version 1.0
 */
public class OperationsTest extends junit.framework.TestCase
{   @Test
    public void testAddingTwoLargePositiveNumbers() {
        double expected = 1229220;
        double actual = new Operations().add(836436, 392784);
        assertEquals (expected, actual);
    }

    @Test
    public void testAddingTwoLargeNegativeNumbers() {
        double expected = -1229220;
        double actual = new Operations().add(-836436, -392784);
        assertEquals (expected, actual);
    }

    @Test
    public void testAddingTwoTinyPositiveNumbers() {
        double expected = 3;
        double actual = new Operations().add (1, 2);
        assertEquals (expected, actual);

    }

    @Test
    public void testAddingTwoTinyNegativeNumbers() {
        double expected = -12;
        double actual = new Operations().add(-5, -7);
        assertEquals (expected, actual);
    }

    @Test
    public void testAddingTwoPositiveDecimals() {
        double expected = 53.7;
        double actual = new Operations().add(15.8, 37.9);
        assertEquals (expected, actual);
    }

    @Test
    public void testAddingTwoNegativeDecimals() {
        double expected = -53.7;
        double actual = new Operations().add(-15.8, -37.9);
        assertEquals (expected, actual);
    }

    @Test
    public void testAddingOneLargePositiveandOneLargeNegativeNumbers() {
        double expected = 0;
        double actual = new Operations().add(999999, -999999);
        assertEquals (expected, actual);
    }

    @Test
    public void testAddingOneNegativeAndOnePositiveDecimals() {
        double expected = 22.099999999999998;
        double actual = new Operations().add(-15.8, 37.9);
        assertEquals (expected, actual);
    }

    @Test
    public void testSubtractingTwoLargePositiveNumbers() {
        double expected = -64956;
        double actual = new Operations().subtract(656976, 721932);
        assertEquals (expected, actual);
    }

    @Test
    public void testSubtractingTwoTinyPositiveNumbers() {
        double expected = 6;
        double actual = new Operations().subtract(9, 3);
        assertEquals (expected, actual);
    }

    @Test
    public void testSubtractingTwoTinyNegativeNumbers() {
        double expected = -6;
        double actual = new Operations().subtract(-9, -3);
        assertEquals (expected, actual);
    }

    @Test
    public void testSubtractingTwoLargeNegativeNumbers() {
        double expected = 64956;
        double actual = new Operations().subtract(-656976, -721932);
        assertEquals (expected, actual);
    }

    @Test
    public void testSubtractingTwoPositiveDecimals() {
        double expected = -22.099999999999998;
        double actual = new Operations().subtract(15.8, 37.9);
        assertEquals (expected, actual);
    }

    @Test
    public void testSubtractingTwoNegativeDecimals() {
        double expected = 22.099999999999998;
        double actual = new Operations().subtract(-15.8, -37.9);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingTwoTinyPositiveNumbers() {
        double expected = 9;
        double actual = new Operations().multiply(3, 3);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingTwoTinyNegativeNumbers() {
        double expected = 9;
        double actual = new Operations().multiply(-3, -3);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingTwoLargePositive() {
        double expected = 44435556;
        double actual = new Operations().multiply(6666, 6666);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingTwoLargeNegative() {
        double expected = 44435556;
        double actual = new Operations().multiply(-6666, -6666);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingTwoPositiveDecimals() {
        double expected = 4644.2321999999995;
        double actual = new Operations().multiply(69.66, 66.67);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingTwoNegativeDecimals() {
        double expected = 4644.2321999999995;
        double actual = new Operations().multiply(-69.66, -66.67);
        assertEquals (expected, actual);
    }

    @Test
    public void testMultiplyingOneLargePositiveNumberAndOneNegativeNumber() {
        double expected = -13120;
        double actual = new Operations().multiply(3280, -4);
        assertEquals (expected, actual);
    }

    @Test
    public void testDividingTwoTinyPositiveNumbers() {
        double expected = 2;
        double actual = new Operations().divide(6, 3);
        assertEquals (expected, actual);

    }

    @Test
    public void testDividingTwoTinyNegativeNumbers() {
        double expected = 2;
        double actual = new Operations().divide(-6, -3);
        assertEquals (expected, actual);

    }

    @Test
    public void testDividingTwoLargePositiveNumbers() {
        double expected = 9.377611111111111;
        double actual = new Operations().divide(843985, 90000);
        assertEquals (expected, actual);

    }

    @Test
    public void testDividingTwoLargeNegativeNumbers() {
        double expected = 9.377611111111111;
        double actual = new Operations().divide(-843985, -90000);
        assertEquals (expected, actual);

    }

    @Test
    public void testDividingTwoDecimals() {
        double expected = 0.6981818181818181;
        double actual = new Operations().divide(5.76, 8.25);
        assertEquals (expected, actual);

    }

    @Test
    public void testDividingTwoNegativeDecimals() {
        double expected = 4.6923076923076925;
        double actual = new Operations().divide(-30.5, -6.5);
        assertEquals (expected, actual);

    }

    @Test
    public void testDividingOneNegativeAndOnePositive() {
        double expected = -60;
        double actual = new Operations().divide(-540, 9);
        assertEquals (expected, actual);

    }

    @Test
    public void testPowerUp() {
        double expected = 14348907;
        double actual = new Operations().pow(3, 15);
        assertEquals (expected, actual);

    }

    @Test
    public void testLargePowerUps() {
        double expected = 9765625;
        double actual = new Operations().pow(5, 10);
        assertEquals (expected, actual);

    }

    @Test
    public void testPowerUpNegative() {
        double expected = 10000;
        double actual = new Operations().pow(-10, 4);
        assertEquals (expected, actual);

    }

    @Test
    public void testPowerUpDecimals() {
        double expected = 238.32800000000003;
        double actual = new Operations().pow(6.2, 3);
        assertEquals (expected, actual);

    }

    @Test
    public void testSin() {
        double expected = 0.8414709848078965;
        double actual = new Operations().sin(1);
        assertEquals (expected, actual);

    }

    @Test
    public void testCos() {
        double expected = 0.5403023058681398;
        double actual = new Operations().cos(-1);
        assertEquals (expected, actual);

    }

    @Test
    public void testTan() {
        double expected = 1.5574077246549023;
        double actual = new Operations().tan(1);
        assertEquals (expected, actual);

    }

    @Test
    public void testCosh() {
        double expected = 1.543080634815244;
        double actual = new Operations().cosh(1);
        assertEquals (expected, actual);

    }

    @Test
    public void testCosh2() {
        double expected = 10.067661995777765;
        double actual = new Operations().cosh(3);
        assertEquals (expected, actual);

    }

    @Test
    public void testTanh() {
        double expected = 0.9981778976111987;
        double actual = new Operations().tanh(3.5);
        assertEquals (expected, actual);

    }

    @Test
    public void testSinh() {
        double expected = 27.28991719712775;
        double actual = new Operations().sinh(4);
        assertEquals (expected, actual);

    }

    @Test
    public void testSqrt() {
        double expected = 6.2449979983983982058468;
        double actual = new Operations().sqrt(39);
        assertEquals (expected, actual);

    }

    @Test
    public void testSqrt2() {
        double expected = 2.23606797749979;
        double actual = new Operations().sqrt(5);
        assertEquals (expected, actual);

    }

    @Test
    public void testSqrt3() {
        double expected = 9;
        double actual = new Operations().sqrt(81);
        assertEquals (expected, actual);

    }

    @Test
    public void testModulous() {
        double expected = 0;
        double actual = new Operations().modulous(5,5);
        assertEquals (expected, actual);

    }

    @Test
    public void testModulous2() {
        double expected = 10;
        double actual = new Operations().modulous(10,100);
        assertEquals (expected, actual);

    }

    @Test
    public void testModulous3() {
        double expected = 17;
        double actual = new Operations().modulous(397,20);
        assertEquals (expected, actual);

    }

    @Test
    public void testLog() {
        double expected = 1.6094379124341003;
        double actual = new Operations().log(5);
        assertEquals (expected, actual);

    }

    @Test
    public void testLog2() {
        double expected = 3.5263605246161616;
        double actual = new Operations().log(34);
        assertEquals (expected, actual);

    }

     @Test
    public void testBigIntFact() {
        Operations test = new Operations();
        double expected = 120;
        double actual = test.factorial(5).doubleValue();
        assertEquals (expected, actual);

    }
    
     @Test
    public void testBigIntFact2() {
        Operations test = new Operations();
        double expected = 3628800;
        double actual = test.factorial(10).doubleValue();
        assertEquals (expected, actual);

    }
  
}
