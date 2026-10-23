package baitap8;

public class Sinhvien {
    private String msv;
    private String tensv;
    private int tuoi;

    public Sinhvien() {}

    public Sinhvien(String msv, String tensv, int tuoi) {
        this.msv = msv;
        this.tensv = tensv;
        this.tuoi = tuoi;
    }

    public String getMsv() {
        return msv;
    }

    public String getTensv() {
        return tensv;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

}
