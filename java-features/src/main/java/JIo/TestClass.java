package JIo;
public class TestClass{

    public static void main(String argv[]){
        Test1 pm1 = new Test1("1");
        pm1.run();
        Test1 pm2 = new Test1("2");
        pm2.run();
        Test1 pm3 = new Test1("break");
        pm3.run();
    }
}
