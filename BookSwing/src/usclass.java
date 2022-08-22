public class usclass {
    private String zhenghao;
    private String psword;
    private int id;
    private String usname;
    private String idcard;

    public usclass(){}
    public usclass(String zhenghao, String psword, int id, String usname, String idcard) {
        this.zhenghao = zhenghao;
        this.psword = psword;
        this.id = id;
        this.usname = usname;
        this.idcard = idcard;
    }

    public String getZhenghao() {
        return zhenghao;
    }

    public void setZhenghao(String zhenghao) {
        this.zhenghao = zhenghao;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
