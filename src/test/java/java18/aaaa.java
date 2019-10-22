package java18;

import java.util.ArrayList;
import java.util.List;

public class aaaa {

    public static List<Integer> reverseOrOperation(Integer supportCostTypes) {
        List<Integer> results = new ArrayList<>();
        if(supportCostTypes!=null) {
            Integer v = 1;
            for (int i = 0; i < 4; i++) {
                if ((v & supportCostTypes) == v) {

                    results.add(v);
                }
                v = v << 1;
            }
        }
        return results;
    }



}
