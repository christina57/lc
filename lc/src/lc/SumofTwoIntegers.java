package lc;

/**
 * Created by zzren on 7/5/2016.
 */
public class SumofTwoIntegers {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int getSum(int a, int b) {
        int sum = 0;
        int a_bit = 0;
        int b_bit = 0;
        int cur_bit = 0;
        int next_carry = 0;
        int carry = 0;

        for(int pos=0;pos<32;pos++){
            a_bit = (a >> pos ) & 1;
            b_bit = (b >> pos ) & 1;

            cur_bit = a_bit ^ b_bit ^ carry;
            if((a_bit & b_bit) == 1 || (a_bit & carry) == 1 || (b_bit & carry) == 1){
                next_carry = 1;
            } else {
                next_carry = 0;
            }

            sum |= cur_bit << pos;
            carry = next_carry;
        }
        return sum;
    }
}
