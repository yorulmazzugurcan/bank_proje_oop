public class hesap {
    private String ibanNo;
    private double bakiye;
    private Musteri hesapSahibiS;

    // Yapıcı Metot (Constructor)
    public hesap(String ibanNo, double bakiye, Musteri hesapSahibi) {
        this.ibanNo = ibanNo;
        this.bakiye = bakiye;
        this.hesapSahibiS = hesapSahibi;
    }

    // Para Yatırma Metodu
    public void paraYatir(double miktar) {
        if (miktar > 0) {
            this.bakiye += miktar; // Bakiyeye parayı ekledik
            System.out.println("Hesabınıza " + miktar + " TL yatırıldı. Güncel bakiye: " + this.bakiye);
        } else {
            System.out.println("Lütfen geçerli bir miktar giriniz.");
        }
    }

    // Para Çekme Metodu
    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= this.bakiye) {
            this.bakiye -= miktar; // Bakiyeden parayı düştük
            System.out.println("Hesabınızdan " + miktar + " TL çekildi. Güncel bakiye: " + this.bakiye);
        } else {
            System.out.println("Hesabınızda yeterli bakiye bulunmamaktadır veya geçersiz miktar girdiniz.");
        }
    }

    // Getter ve Setter Metotları
    public String getIbanNo() {
        return ibanNo;
    }
    public double getBakiye() {
        return bakiye;
    }
    public Musteri getHesapSahibi() {
        return hesapSahibiS;
    }
}








