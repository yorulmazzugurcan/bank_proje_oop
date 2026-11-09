import java.util.ArrayList;
public class banka {

    private String bankaAdi;
    private ArrayList<Musteri> musteriler;
    private ArrayList<hesap> hesaplar;



    public banka(String bankaAdi) {
        this.bankaAdi = bankaAdi;
        this.musteriler = new ArrayList<>();
        this.hesaplar = new ArrayList<>();
    }

    public void musteriEkle(Musteri yeniMusteri) {
    // Müşterinin reşit olup olmadığını kontrol ediyoruz
    if (yeniMusteri.getYas() >= 18) {
        this.musteriler.add(yeniMusteri);
        System.out.println("Müşteri bankaya başarıyla eklendi: " + yeniMusteri.getAd() + " " + yeniMusteri.getSoyad());
    } else {
        System.out.println("Müşteri 18 yaşından küçük olduğu için bankaya kaydedilemedi!");
    }
}

public void hesapAc(hesap yeniHesap) {
    this.hesaplar.add(yeniHesap);
    System.out.println("Hesap başarıyla açıldı. IBAN: " + yeniHesap.getIbanNo());
}

public void musterileriListele() {
    System.out.println("=== " + bankaAdi + " MÜŞTERİ LİSTESİ ===");
    for (Musteri m : musteriler) {
        System.out.println("Müşteri No: " + m.getMusteriNo() + " - İsim: " + m.getAd() + " " + m.getSoyad());
    }
  }
  public Musteri musteriBul(String musteriNo) {
    for (Musteri m : musteriler) {
        if (m.getMusteriNo().equals(musteriNo)) {
            return m; // Müşteri bulunduğunda ilgili nesneyi döndürür
        }
    }
    return null; // Döngü bittiği halde bulunamadıysa null döndürür
}
  // IBAN'a göre hesabı bulup para yatırır
public void paraYatir(String iban, double miktar) {
    for (hesap h : hesaplar) {
        if (h.getIbanNo().equals(iban)) {
            h.paraYatir(miktar);
            return; // Hesabı bulup işlemi yaptıktan sonra döngüden çıkar
        }
    }
    System.out.println("Hata: " + iban + " numaralı IBAN bulunamadı!");
}

// IBAN'a göre hesabı bulup para çeker
public void paraCek(String iban, double miktar) {
    for (hesap h : hesaplar) {
        if (h.getIbanNo().equals(iban)) {
            h.paraCek(miktar);
            return;
        }
    }
    System.out.println("Hata: " + iban + " numaralı IBAN bulunamadı!");
}
}
