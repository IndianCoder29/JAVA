public class AlphabetThread implements Runnable{
    @Override
    public void run(){
        char currChar = 'A';
        while(currChar <= 'Z'){
            System.out.print(currChar+" ");
            currChar++;
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        AlphabetThread at = new AlphabetThread();
        Thread t1 = new Thread(at);
        t1.start();
    }
}