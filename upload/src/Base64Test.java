import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws Exception {

        String content = "这是需要Base64编码的内容";
        // 创建一个Base64编码器
        Base64.Encoder encoder = Base64.getEncoder();
        // 执行Base64编码操作
        String encodedString = encoder.encodeToString(content.getBytes("UTF-8"));

        System.out.println( encodedString );

        // 创建Base64解码器
        Base64.Decoder decoder = Base64.getDecoder();
        // 解码操作
        byte[] bytes = decoder.decode(encodedString);

        String str = new String(bytes, "UTF-8");

        System.out.println(str);
    }
}
