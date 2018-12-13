import org.apache.spark.deploy.SparkSubmit;

/**
 * ClassName: Test <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date: 18-6-8 上午10:12 <br/>
 *
 * @author liuyu
 * @version v1.0
 * @since JDK 1.7+
 */
public class SubmitJobToSpark {


    public static void main(String[] args) {
        String[] myArgs = new String[] { "--master", "spark://bigdata1:7077",
                "--class", "HelloWorld", "/home/liuyu/workeidea/liuyusprakdemo/out/artifacts/liuyusprakdemo_jar/liuyusprakdemo.jar"};
        SparkSubmit.main(myArgs);
        System.out.println();
    }
}
