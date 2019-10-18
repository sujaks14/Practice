package test.Amz;

public class NumberAtmostNGivenDigit {

    public static void main(String[] args) {
        String[] D = new String[]{"1","2","3"};
        int N =529;
        NumberAtmostNGivenDigit inst = new NumberAtmostNGivenDigit();
        int res = inst.atMostNGivenDigitSet(D, N);
        System.out.println("final result:" + res);
    }

        public int atMostNGivenDigitSet(String[] D, int N) {
            int digitCount = 0, copy = N;
            String number = "";
            while(copy > 0){
                number = (copy % 10) + number;
                copy = copy/10;
                digitCount++;
            }
            System.out.println("digitalCount:" + digitCount +", number:" + number);
            int result = 0;
            // Calculate the combo that is shorter than N
            for(int i = 0; i < digitCount - 1; i++) {
                result += Math.pow(D.length, i+1);
            System.out.println("result each time at i ="+i +", result:" +result);
            }

            System.out.println("result-:" + result);

            // Convert the string array to char array
            char[] choice = new char[D.length];
            for(int i = 0; i < D.length; i++)
                choice[i] = D[i].toCharArray()[0];

            // The choice array is sorted, we only want to go up to the number that is the same as target numbers corresponding digit
            for (int i = 0; i < choice.length && choice[i] <= number.charAt(0); i++){
                if (choice[i] == number.charAt(0)){
                    result += helper(choice, number, N, digitCount, i, "");
                }else{
                    //If the current digit(most significant) is less than target's first digit already, any digit can come after
                    result += Math.pow(D.length, number.length() - 1);
                }
            }
            return result;
        }

        private int helper(char[] choice, String number, int N, int digitCount, int index, String cur){
            cur += choice[index];
            if (cur.length() == digitCount){
                return 1;
            }
            int result = 0;
            for (int i = 0 ; i < choice.length && choice[i] <= number.charAt(cur.length()); i++){

                if (choice[i] == number.charAt(cur.length())){
                    result += helper(choice, number, N, digitCount, i, new String(cur));
                }else{
                    // If the current digit is less than the target number's current digit, the subsequent digit can be any number in the choice
                    result += Math.pow(choice.length, number.length() - cur.length() - 1);
                }
            }
            return result;
        }
    }




