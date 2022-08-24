public class Expirience {

    public static void main(String[] args) throws InterruptedException {
        String progress = "";
        for(int i = 0; i < 5; i++) {
            progress = progress + "х";
            System.out.print("\r" + progress);
            Thread.sleep(1000);
        }
    }
}
