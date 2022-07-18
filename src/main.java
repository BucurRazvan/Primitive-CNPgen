import java.sql.SQLOutput;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rand = new Random();
        long cnp  = rand.nextInt(1,4);
        cnp = cnp*100 + rand.nextInt(10, 99);
        cnp = cnp*100 + rand.nextInt(10 ,12);
        cnp = cnp*100 + rand.nextInt(10,29);
        cnp = cnp*100 + rand.nextInt(10 , 51);
        cnp = cnp*1000 + rand.nextInt(100 , 999);

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
            cnp = cnp*10+1;

        }
        else
        {
            cnp = cnp * 10+ (x%11);
        }
        System.out.println(cnp);
    }


}