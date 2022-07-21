import java.util.Calendar;
import java.util.Random;

public class generators {
    public long generateCtrlNum (long cnp)
    {
        int[] ctrlKey = {2,7,9,1,4,6,3,5,8,2,7,9};
        int x = 0;
        int poz = 11;
        long cnpBackup =cnp;
        while ( cnpBackup > 0)
        {
            x += cnpBackup%10*ctrlKey[poz];
            poz--;
            cnpBackup /= 10;
        }
        if (x%11 == 10)
        {
            return cnp*10+1;

        }
        else
            return cnp * 10+ (x%11);

    }
    public long generateGender(long cnp)
    {
        Random rand = new Random();
        cnp  = rand.nextInt(1,9);
        return cnp;
    }
    public long generateYear(long cnp)
    {
        Random rand = new Random();
        int year = rand.nextInt(0,100);
        if(cnp == 5 || cnp == 6)
        {

            Calendar cal = Calendar.getInstance();

            while(year > (cal.get(Calendar.YEAR)%100))
                 year = rand.nextInt(0,100);
        }
        return cnp*100 + year;

    }
    public long generateMonth(long cnp)
    {
        Random rand = new Random();
        int month = rand.nextInt(0,12);
        return  cnp *100 + month;
    }
    public long generateDay( long cnp)
    {
        Random rand = new Random();
        int days[] = {31, 28 , 31, 30, 31, 30, 31, 30 , 31, 31, 30 ,31};
        long year = (cnp/100)%100;
        if(year % 4 == 0)
        {
            days[1]=29;
        }
        int day = Math.toIntExact(cnp % 100 - 1);
        return cnp*100 + rand.nextInt(0, days[day]);
    }
    public long generateAreaCode( long cnp)
    {
        Random rand = new Random();
        return cnp*100 + rand.nextInt(0, 52);
    }
    public long generateCtrlDigits( long cnp)
    {
        Random rand = new Random();
        return cnp*1000 + rand.nextInt(0,999);
    }
    public long generateCNP(long cnp)
    {
        cnp = generateGender(1);
        cnp = generateYear(cnp);
        cnp= generateMonth(cnp);
        cnp = generateDay(cnp);
        cnp = generateAreaCode(cnp);
        cnp = generateCtrlDigits(cnp);
        cnp = generateCtrlNum( cnp);
        return cnp;
    }
}
