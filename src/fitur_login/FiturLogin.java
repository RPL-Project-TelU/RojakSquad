package fitur_login;

import java.util.Scanner;

public class FiturLogin {

    enum State {LOGIN,REGISTER,MAHASISWA,AUTHOR,EXIT};
    
    public void login(){
    	Author obj = new Author();
        Mahasiswa mhs = new Mahasiswa();
        State state = State.LOGIN; 
        String username[] = {"author1","mahasiswa1"};
        String password[] = {"123","1234"};
        String status[] = {"author","mahasiswa"};
        Scanner sc = new Scanner(System.in);
        int pil,s;
        String stat="";
        String usern,passw;
        String screenName[] ={"LOGIN","REGISTER","MAHASISWA","AUTHOR","EXIT"};
        //Selama state bukan State.EXIT maka program akan berjalan terus
        while(state!=State.EXIT){
            System.out.println("1. LOGIN\n2. REGISTER\n3. EXIT");
            System.out.print("Masukkan Pilihan: ");
            pil = sc.nextInt();
            sc.nextLine();
            switch(pil){
                case 1:
                    state = State.LOGIN;
                    
                    System.out.println("Kamu saat ini di State "+screenName[pil-1]);
                   
                    System.out.print("Masukkan Username: ");usern = sc.nextLine();
                    System.out.print("Masukkan Password: ");passw = sc.nextLine();
                    //Validasi data
                    for(int i=0;i<username.length;i++){
                        if(usern.equals(username[i]) && passw.equals(password[i])){
                            if(status[i].equals("author")){
                                state = State.AUTHOR;
                                obj.Login(username[i],password[i]);
                            }else if(status[i].equals("mahasiswa")){
                                state = State.MAHASISWA;
                                mhs.Login(username[i],password[i]);
                            }
                        }
                    }
                    //Menampilkan menu log2out atau keluar aplikasi
                    System.out.print("1. Logout\n2. Exit\nSilahkan Pilih: ");
                    pil = sc.nextInt();
                    sc.nextLine();
                    switch(pil){
                        case 1:
                            System.out.println("Berhasil Logout!");
                            break;
                        case 2:
                            state = State.EXIT;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Kamu saat ini di State "+screenName[pil-1]);
                    state = State.REGISTER;
                    System.out.print("Masukkan Username: ");usern = sc.nextLine();
                    System.out.print("Masukkan Password: ");passw = sc.nextLine();
                    System.out.print("1. Author\n2. Mahasiswa\nPilih Status  : ");s = sc.nextInt();
                    sc.nextLine();
                    //Membuat pemilihan status
                    switch(s){
                        case 1:
                            stat ="author";
                            break;
                        case 2:
                            stat = "mahasiswa";
                            break;
                    }
                    //Melakukan penambahan elemen pada indeks terbaru dengan fungsi addX 
                    username = addX(username.length,username,usern);
                    password = addX(password.length,password,passw);
                    status = addX(status.length,status,stat);
                    System.out.println("Daftar Berhasil Silahkan Login!");
                    break;
                case 3:
                    System.out.println("Kamu saat ini di State "+screenName[pil+1]+"\nTerima kasih sudah menggunakan program ini!");
                    state = State.EXIT;
                    break;
            }
        }
    }
    //Fungsi untuk menambahkan data pada indeks terbaru array
    public static String[] addX(int n, String arr[], String x)
    {
        int i;
        String newarr[] = new String[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];  
        newarr[n] = x;  
        return newarr;
    }
    
}
