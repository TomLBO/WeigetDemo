package com.bob.notificationlibrary;

import android.app.Notification;
import android.content.Context;

/**
 * Created by bob on 16.6.15.
 * 通知例子
 */
public class NotificationHelper {

    public void show(Context context, int icon){
        //通知栏管理
        //是状态栏通知的管理类，负责发通知、清除通知等操作。
        final android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);



        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentTitle("通知标题")
                .setContentText("通知内容")
                .setNumber(5)//设置通知集合的数量
                .setTicker("ticker")//通知首次出现在通知栏，带上升动画效果的
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示，一般是系统获取到的时间
                .setPriority(Notification.PRIORITY_DEFAULT)//设置通知的优先级
                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(true)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
//                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(icon)
//                .setContentIntent()
                .setLights(0x123456, 300, 0);

        final Notification notification = builder.build();
//        notification.flags = Notification.FLAG_ONLY_ALERT_ONCE;
        notification.vibrate = new long[]{0, 300, 600, 1000, 300, 500};
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    notificationManager.notify(1,notification);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
