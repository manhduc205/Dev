package Cau6_lamlai;

/**
 *
 * @author DucPc
 */
public class Word {
    private String id, en, vn;

    public Word() {
    }

    public Word(String id, String en, String vn) {
        this.id = id;
        this.en = en;
        this.vn = vn;
    }

    public String getId() {
        return id;
    }

    public String getEn() {
        return en;
    }

    public String getVn() {
        return vn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
    public void in(){
        System.out.println("ID: "+ id);
        System.out.println("Nghia EN:" + en);
        System.out.println("Nghia VN: " + vn);
        
    }
}
