package com.dsa_algorithms.String;

public class IntegerToRoman {
    StringBuilder sb;
    public String intToRoman(int num) {
        int i=0;
        char a, b, c;
        sb = new StringBuilder();
        char[] roman = new char[]{'I', 'V', 'X', 'L','C', 'D', 'M', '-', '-'};

        while(num > 0){
            int val = num%10;
            a = roman[i];
            b = roman[i+1];
            c = roman[i+2];

            if (val < 4){
                romanNum(a, val);
            }
            else if (val > 4 && val < 9){
                romanNum(a, val-5);
                sb.append(b);
            }
            else if (val == 4)
                sb.append(b).append(a);
            else
                sb.append(c).append(a);
            i += 2;
            num /= 10;
        }
        return sb.reverse().toString();
    }
    public void romanNum(char a, int val){
        while(val-- > 0)
            sb.append(a);
    }
}
