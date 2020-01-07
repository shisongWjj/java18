package java18;

import java18.dto.RenterOrderWzCostDetailEntity;
import java18.utils.CompareHelper;

import java.util.LinkedHashMap;
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
        RenterOrderWzCostDetailEntity target = new RenterOrderWzCostDetailEntity();
        //target.setAmount(null);
        target.setRemark("11111");
        RenterOrderWzCostDetailEntity source = new RenterOrderWzCostDetailEntity();
        source.setAmount(300);
        source.setRemark("2222");

        Map<String,String> paramNames = new LinkedHashMap<>();
        paramNames.put("amount","其他扣款");
        paramNames.put("remark","其他扣款备注");

        CompareHelper<RenterOrderWzCostDetailEntity> comparable = new CompareHelper<>(null,source,paramNames);
        String compare = comparable.compare();
        System.out.println(compare);
    }

}
