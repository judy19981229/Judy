package TCP;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//BIO 客户端程序
//通过 9999 端口连接服务器端，getInputStream 方法用来等待服务器端返回数据，
//如果没有返回，就一直等待，程序会阻塞到这里。
//造成乱码的问题是因为读取的信息是按照特定编码读取的字节流信息，
//读取的时候 受到读取限定，就有可能出现读取的不是一个完整的字节数组信息。
public class TCPClient {
    public static void main(String[] args) throws Exception {
        while (true) {
            //1.创建 Socket 对象
            Socket s = new Socket("127.0.0.1", 9999);
            //2.从连接中取出输出流并发消息
            OutputStream os = s.getOutputStream();
            System.out.println("请输入:");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            os.write(msg.getBytes());
            //3.从连接中取出输入流并接收回话
            InputStream is = s.getInputStream(); //阻塞
            byte[] b = new byte[20];
            is.read(b);
            System.out.println("老板说:" + new String(b).trim());
            //4.关闭
            s.close();
        }
    }
}
