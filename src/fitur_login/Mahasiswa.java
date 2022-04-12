package fitur_login;

public class Mahasiswa implements User {
    String user,pass;
    public void Login(String user, String pass){
        System.out.println("Halo "+user+" Kamu login Sebagai Mahasiswa");
    }
}
