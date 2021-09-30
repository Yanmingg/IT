public class CRMObject {
    private String name = "NULL";
    private String phone = "NULL";
    private String email = "NULL";
    private String teamName = "NULL";
    private String remark = "NULL";
    private Boolean marked = false;

    public CRMObject() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CRMObject(String name){
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }


    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                '}';
    }
}
