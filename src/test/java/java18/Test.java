package java18;

import java18.dto.RenterOrderWzCostDetailEntity;
import java18.utils.CompareHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Test
 *
 * @author shisong
 * @date 2020/1/7
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception{
        List<RenterOrderWzCostDetailEntity> list = new ArrayList<>();
        RenterOrderWzCostDetailEntity target = new RenterOrderWzCostDetailEntity();
        target.setAmount("300");
        target.setRemark("11111");
        list.add(target);
        RenterOrderWzCostDetailEntity source = new RenterOrderWzCostDetailEntity();
        source.setAmount("300");
        source.setRemark("2222");
        list.add(source);

        int sum = list.stream().map(RenterOrderWzCostDetailEntity::getAmount).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        /*Map<String,String> paramNames = new LinkedHashMap<>();
        paramNames.put("amount","其他扣款");
        paramNames.put("remark","其他扣款备注");*/

        /*CompareHelper<RenterOrderWzCostDetailEntity> comparable = new CompareHelper<>(target,source,paramNames);
        String compare = comparable.compare();
        System.out.println(compare);*/

    }


}
