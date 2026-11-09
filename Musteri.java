public class Musteri {
    private String tcNo;
    private String musteriNo;
    private String ad;
    private String soyad;
    private int yas;

    public Musteri(String tcNo, String musteriNo, String ad, String soyad, int yas) {
        if (yas < 18) {
            System.out.println("18 yaşından küçükler müşteri olamaz!");
        }else {
           this.tcNo = tcNo;
           this.musteriNo = musteriNo;
           this.ad = ad;
           this.soyad = soyad;
           this.yas = yas;
        }

    }

    public String getTcNo() {
        return tcNo;
    }
    public String getMusteriNo() {
        return musteriNo;
    }
    public String getAd() {
        return ad;
    }
    public String getSoyad() {
        return soyad;
    }
    public int getYas() {
        return yas;
    }

}
