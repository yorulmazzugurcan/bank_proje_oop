import java.util.Scanner;

public class main {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        banka banka = new banka("Java Bank");

        boolean calisiyor = true;

        while (calisiyor) {
            System.out.println("\n========== JAVA BANK KONSOL PANELİ ==========");
            System.out.println("1 - Yeni Müşteri Ekle");
            System.out.println("2 - Yeni Hesap Aç");
            System.out.println("3 - Para Yatır");
            System.out.println("4 - Para Çek");
            System.out.println("5 - Müşterileri Listele");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Sayısal girdiden sonra oluşan satır sonu tamponunu temizler

            switch (secim) {
                case 1:
                    System.out.println("\n--- YENİ MÜŞTERİ KAYDI ---");
                    System.out.print("TC Kimlik No: ");
                    String tcNo = scanner.nextLine();

                    System.out.print("Müşteri No: ");
                    String musteriNo = scanner.nextLine();

                    System.out.print("Ad: ");
                    String ad = scanner.nextLine();

                    System.out.print("Soyad: ");
                    String soyad = scanner.nextLine();

                    System.out.print("Yaş: ");
                    int yas = scanner.nextInt();
                    scanner.nextLine(); // Tampon temizleme

                    Musteri yeniMusteri = new Musteri(tcNo, musteriNo, ad, soyad, yas);
                    banka.musteriEkle(yeniMusteri);
                    break;

                case 2:
                    System.out.println("\n--- YENİ HESAP AÇMA ---");
                    System.out.print("Müşteri No: ");
                    String arananMusteriNo = scanner.nextLine();

                    // Banka sınıfındaki müşteri listesinde arama yapıyoruz
                    Musteri hesapSahibi = banka.musteriBul(arananMusteriNo);

                    if (hesapSahibi != null) {
                        System.out.print("IBAN No: ");
                        String iban = scanner.nextLine();

                        System.out.print("İlk Bakiye: ");
                        double bakiye = scanner.nextDouble();
                        scanner.nextLine(); // Tampon temizleme

                        hesap yeniHesap = new hesap(iban, bakiye, hesapSahibi);
                        banka.hesapAc(yeniHesap);
                    } else {
                        System.out.println("Hata: " + arananMusteriNo + " numaralı müşteri bulunamadı! Önce müşteri kaydı yapın.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- PARA YATIRMA ---");
                    System.out.print("İşlem Yapılacak IBAN: ");
                    String yatirilacakIban = scanner.nextLine();

                    System.out.print("Yatırılacak Miktar: ");
                    double yatirilacakMiktar = scanner.nextDouble();
                    scanner.nextLine(); // Tampon temizleme

                    banka.paraYatir(yatirilacakIban, yatirilacakMiktar);
                    break;

                case 4:
                    System.out.println("\n--- PARA ÇEKME ---");
                    System.out.print("İşlem Yapılacak IBAN: ");
                    String cekilecekIban = scanner.nextLine();

                    System.out.print("Çekilecek Miktar: ");
                    double cekilecekMiktar = scanner.nextDouble();
                    scanner.nextLine(); // Tampon temizleme

                    banka.paraCek(cekilecekIban, cekilecekMiktar);
                    break;

                case 5:
                    banka.musterileriListele();
                    break;

                case 0:
                    System.out.println("Bankacılık sisteminden çıkış yapılıyor... İyi günler!");
                    calisiyor = false;
                    break;

                default:
                    System.out.println("Geçersiz bir seçim yaptınız, tekrar deneyin.");
            }
        }

        scanner.close();
    }
}