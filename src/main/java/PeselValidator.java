
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class PeselValidator {
    private int check[] = {1, 3, 7, 9};

    public boolean validate(String data){
        List<Integer> pesel = new ArrayList<>();

        for(char c : data.toCharArray()){
            pesel.add(Character.getNumericValue(c));
        }

        int checkSum = 0;
        int properEnding = -1;

        if (pesel.size() != 11){
            return false;
        }

        for(int i =0; i < 10; i++){
            checkSum += pesel.get(i) * check[i % 4];
        }

        if(checkSum%10 == 0){
            properEnding = 0;
        }else{
            properEnding = 10 - checkSum%10;
        }

        return properEnding == pesel.get(10) ? true : false;
    }
}
