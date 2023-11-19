public class Main{
    public static void main(String[] args){
        Customer customer1 = new Customer();
        customer1.atasNama = "ilmi";
        customer1.berat = 1;
        customer1.alamat = "Palem 2 Blok A5-1";
        customer1.noHP = "081240218317";
        customer1.harga = 6000;

        System.out.println("Atas Nama : " + customer1.atasNama);
        System.out.println("Berat : " + customer1.berat);
        System.out.println("Alamat : " + customer1.alamat);
        System.out.println("No HP : " + customer1.noHP);
        System.out.println("Harga : " + customer1.harga);
        customer1.Carabayar1();
        customer1.Carabayar2();
        System.out.println();
    }
}