import java.util.Scanner;

public class CardNumber {
    public static void main(String [] args) {
        long ccnum;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        ccnum=in.nextLong();
        if (isValid(ccnum))
            System.out.println(ccnum+" is valid.");
        else
            System.out.println(ccnum+" is not valid.");
    }
    /** Return true if the card number is valid */
    public static Boolean isValid(long number) {
        int n;
        long p;
        p=getPrefix(number,1);
        if(p<4)
            return false;
        if(p>6)
        if(getPrefix(number,2)!=37)
            return false;
            n=getSize(number);
        if(n<13||n>16)
            return false;
        if((sumOfDoubleEvenPlace(number)+sumOfoddPlace(number))%10!=0)
            return false;
            return true;
    }
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int i,sum=0;
        for(i=1;i<=16;i++) {
            if(i%2==0)
            sum=sum+getDigit((int)(number%10)*2);
            number/=10;
        }
        return sum;
    }
    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {
        if(number<10)
            return number;
        else
            return (number/10)+(number%10);
    }
    /** Return sum of odd-place digits in number */
    public static int sumOfoddPlace(long number) {
        int i,sum=0;
        for(i=1;i<=16;i++) {
            if(i%2==1)
                sum=sum+(int)(number%10);
                number/=10;
            }
            return sum;
        }
    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        if(getPrefix(number,1)==d||getPrefix(number,2)==d)
            return true;
            return false;
        }
    /** Return true if the number d is a prefix for number */
    public static int getSize(long d) {
        int n=0;
        while(d!=0) {
            n++;
            d/=10;
        }
        return n;
    }
    /** Return true if the number d is a prefix for number */
    public static long getPrefix(long number, int k) {
        if(k==1)
            return number/1000000000000000L;
        if(k==2)
            return number/100000000000000L;
            return 0;
        }
    }