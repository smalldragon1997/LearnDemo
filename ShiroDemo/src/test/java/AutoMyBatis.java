import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class AutoMyBatis {
    //    public static void main(String args[]){
////        String goodsname="测试支付宝";
////        String istype ="1";
////        String notify_url ="http://www.realfake.cn:8080/SSMP/savePay";
////        String orderid ="2";
////        String orderuid ="2";
////        String price ="0.01";
////        String return_url ="http://www.realfake.cn:8080/SSMP/";
////        String token ="1accfbca7c2e54ef824319cec42710f0";
////        String uid="a6fb395e410421b00431fdc7";
////
////        System.out.println(Utils.EncoderByMd5(goodsname+istype+notify_url+orderid+orderuid+price+return_url+token+uid));
//    }
    public static void main(String args[]) throws Exception{

//        MailThread mail = new MailThread();
//        mail.setTargetAddress("1059172012@qq.com");
//        mail.setSubject("测试邮件发送");
//        mail.setContent("测试邮件发送的content");
//        mail.start();
        // 将刚复制的代码放在这，
        // 根据提示将导入的文件导入，异常抛出
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File(java.net.URLDecoder.decode(AutoMyBatis.class.getResource("mbgConfiguration.xml").getPath(),"utf-8"));
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }


}
