package java18.io;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.*;

public class FileStreamTest {

    @Test
    public void test(){
//创建文件对象，指定要读取的文件路径(要读的文件一定要存在)
        File file=new File("D:\\abc.txt");
        File file1=new File("D:\\ccc.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一行");
            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(file1));
            String tempString = null;
            int line = 1;
            //一次读一行，读入null时文件结束
            while ((tempString = reader.readLine()) != null) {
            //把当前行号显示出来
                if(StringUtils.isNotBlank(tempString) && !tempString.contains("pic_cnt_") && tempString.contains("nn.cbcb.us")){
                    String str = "'";
                    str += tempString.substring(81,110);
                    str += "',";
                    System.out.println("line " + line + ": " + str);
                    writer.write(str);
                    writer.newLine();
                }
                line++;
            }
            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    @Test
    public void test1(){
        String str = "HTTPSConnectionPool(host='nn.cbcb.us', port=443): Max retries exceeded with url: /htm_data/8/1810/3298938.html (Caused by ConnectTimeoutError(<urllib3.connection.VerifiedHTTPSConnection object at 0x000001F07B95F7F0>, 'Connection to nn.cbcb.us timed out. (connect timeout=10)'))";
        //System.out.println(str.indexOf("/htm_data/8/1810/3298938.html"));
        System.out.println("/htm_data/8/1810/3298938.html".length());
        System.out.println(str.substring(81,110));
    }
}
