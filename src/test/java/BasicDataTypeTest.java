import org.junit.Test;

/**
 * Test
 *
 * @author shisong
 * @date 2019/3/11
 */
public class BasicDataTypeTest {

    @Test
    public void test(){
        System.out.println("Byte :" +Byte.SIZE);//8
        System.out.println("Short :" +Short.SIZE);//16
        System.out.println("Character :" +Character.SIZE);//16
        System.out.println("Integer :" +Integer.SIZE);//32
        System.out.println("Float :" +Float.SIZE);//32
        System.out.println("Long :" +Long.SIZE);//64
        System.out.println("Double :" +Double.SIZE);//64
        System.out.println("Boolean :" +Boolean.toString(false));//false
    }

}
