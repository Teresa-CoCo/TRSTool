package cocloud.teresacoco.life;

import java.io.IOException;

public class OpenNotePad {
    public static void start() {
        try {
            // 创建并启动ProcessBuilder实例以运行记事本
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            pb.start();
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }
}
