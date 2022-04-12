package fitur_login;

public class Author extends Mahasiswa implements User {
    public void Login(String user, String pass){
        System.out.println("Halo "+user+" Kamu Login Sebagai Author");   
    }
}
