package slip13;

import java.util.Random;

import java.util.Random;
class MyThread extends Thread {
 private String threadName;
 private int sleepTime;
 public MyThread(String threadName) {
 this.threadName = threadName;
 this.sleepTime = new Random().nextInt(5000);
 }
 @Override
 public void run() {
 try {
 System.out.println("Thread " + threadName + " is running.");
 System.out.println("Thread " + threadName + " will sleep for " +
sleepTime + " milliseconds.");
 Thread.sleep(sleepTime);
 System.out.println("Thread " + threadName + " has woken up.");
 } catch (InterruptedException e) {
 e.printStackTrace();
 } finally {
 System.out.println("Thread " + threadName + " is terminating.");
 }
 }
}
public class Main2 {
 public static void Main2(String[] args) {
 MyThread myThread = new MyThread("MyThread");
 myThread.start();
 }
}
