package MainApplication.PoJo;

public class Proimg {
    private Integer id;

    private Integer pId;

    private String imgname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }


    @Override
    public String toString() {
        return "Proimg{" +
                "id=" + id +
                ", pId=" + pId +
                ", imgname='" + imgname + '\'' +
                '}';
    }
}