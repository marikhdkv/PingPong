public class Main
{
    private static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; ++i)
        {
            Thread t1 = new Thread(() ->
            {
                synchronized (resource)
                {
                    System.out.println("Ping");
                }
            });
            t1.start();
            t1.join();
            Thread t2 = new Thread(() ->
            {
                synchronized (resource)
                {
                    System.out.println("Pong");
                }
            });
            t2.start();
            t2.join();
        }
    }
}