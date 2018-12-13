import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.io.IOException;

/**
 * ClassName: SparkLauncher <br/>
 * Function:  这中方法需要在安装了spark的机器上能运行. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-6-8 上午11:20 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class MySparkLauncher {
    public static void main(String[] args) throws IOException {
        SparkAppHandle.Listener sparkListener = new SparkAppHandle.Listener() {
            @Override
            public void stateChanged(SparkAppHandle sparkAppHandle) {
                System.out.println("**********  state  changed  **********");
            }

            @Override
            public void infoChanged(SparkAppHandle sparkAppHandle) {
                System.out.println("**********  info  changed  **********");
            }
        };
        SparkAppHandle handler = new SparkLauncher()
                .setAppName("hello-world")
                .setSparkHome("/home/liuyu/workeidea/liuyusprakdemo/out/artifacts")
                .setMaster("spark://bigdata1:7077")
//                .setConf("spark.driver.memory", "2g")
//                .setConf("spark.executor.memory", "1g")
//                .setConf("spark.executor.cores", "3")
                .setAppResource("/home/liuyu/workeidea/liuyusprakdemo/out/artifacts/liuyusprakdemo_jar/liuyusprakdemo.jar")
                .setMainClass("HelloWorld")
//                .addAppArgs("I come from Launcher")
//                .setDeployMode("cluster")
                .startApplication(sparkListener);

        while (!"FINISHED".equalsIgnoreCase(handler.getState().toString())
                && !"FAILED".equalsIgnoreCase(handler.getState().toString())) {
            System.out.println("id    " + handler.getAppId());
            System.out.println("state " + handler.getState());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
