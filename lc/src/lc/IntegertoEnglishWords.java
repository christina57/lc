package lc;

/**
 * Created by zzren on 7/22/2016.
 */
public class IntegertoEnglishWords {
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String[] chunk = {"Billion","Million","Thousand",""};
        String[] chunk1 = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] chunk2 = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] chunk3 = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        StringBuilder sb = new StringBuilder();

        int divisor = 1000000000;
        int quo = 0;
        int reminder = num;

        for(int i=0;i<4;i++){
            quo = reminder / divisor;
            if(quo == 0){
                divisor /= 1000;
                continue;
            }
            int temp = quo / 100;
            if(temp > 0){
                sb.append(" " + chunk1[temp-1] + " Hundred");
                quo %= 100;
            }
            temp = quo / 10;
            if(temp > 0){
                if(temp == 1){
                    temp = quo % 10;
                    sb.append(" " + chunk2[temp]);
                } else {
                    sb.append(" " + chunk3[temp-2]);
                    temp = quo % 10;
                    if(temp != 0){
                        sb.append(" " + chunk1[temp-1]);
                    }
                }
            } else {
                temp = quo % 10;
                if(temp != 0){
                    sb.append(" " + chunk1[temp-1]);
                }
            }
            sb.append(" " + chunk[i]);
            reminder %= divisor;
            divisor /= 1000;
        }
        return sb.toString().trim();
    }
}
