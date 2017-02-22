package com.lorelib.jvm;

/**
 * 步骤：
 * 1. 通过jsp查询当前线程的pid;
 * 2. 使用jstack -l pid 查看堆栈信息；如出现pic/deadloop.png的错误提示，表示程序进入死循环了。
 * Created by listening on 2017/2/17.
 */
public class DeadLoop {
    public static void main(String[] args) {
        while (true);
    }
}
