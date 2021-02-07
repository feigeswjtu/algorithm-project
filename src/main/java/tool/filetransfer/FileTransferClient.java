package tool.filetransfer;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 文件传输Client端<br>
 * 功能说明
 */
public class FileTransferClient {

    /**
     * 服务端ip
     */
    private static final String SERVER_IP = "192.168.1.101";
    /**
     * 服务端端口
     */
    private static final int SERVER_PORT = 8899;

    /**
     * socket实例
     */
    private Socket clientSocket;

    /**
     * 文件流输入流
     */
    private FileInputStream fileInputStream;

    /**
     * socket的数据输出流
     */
    private DataOutputStream dataOutputStream;

    /**
     * 构造函数<br/>
     * 与服务器建立连接
     *
     * @throws Exception
     */
    public FileTransferClient() throws Exception {
        clientSocket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("Cliect[port:" + clientSocket.getLocalPort() + "] 成功连接服务端");
    }

    /**
     * 向服务端传输文件
     *
     * @throws Exception
     */
    public void sendFile() throws IOException {
        try {
            File file = new File("/Users/yangen/workspaces/books.zip");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                // 文件名
                dataOutputStream.writeUTF(file.getName());
                dataOutputStream.flush();

                // 长度
                dataOutputStream.writeLong(file.length());
                dataOutputStream.flush();

                // 开始传输文件
                System.out.println("======== 开始传输文件 ========");
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while ((length = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
                    dataOutputStream.write(bytes, 0, length);
                    dataOutputStream.flush();
                    progress += length;
                    System.out.print("| " + (100 * progress / file.length()) + "% |");
                }
                System.out.println();
                System.out.println("======== 文件传输成功 ========");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                fileInputStream.close();
            if (dataOutputStream != null)
                dataOutputStream.close();
            clientSocket.close();
        }
    }

    /**
     * 入口
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            FileTransferClient client = new FileTransferClient(); // 启动客户端连接
            client.sendFile(); // 传输文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}