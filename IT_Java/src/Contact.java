public class Contact extends CRMObject{
    // Attributes of a contact
    protected String name = super.getName();
    protected String phone = "NULL";
    protected String email = "NULL";
    protected String teamName = "NULL";
    protected String remark = "NULL";
    private Boolean marked = false;

    // Getter and setters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getRemark() {
        return remark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    // Constructor
    public Contact() {
    }

    // Constructor
    public Contact(String name) {
        this.name = name;
    }

    // Overload constructor
    public Contact(String name, String phone, String email, String teamName, String remark) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.teamName = teamName;
        this.remark = remark;
    }


    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    // This method marks the contact as "important"
    public Contact mark(){
        this.marked = true;
        return this;
    }

    // This method is returning the attribute information into a csv format
    public String toCsv(){
        String csv = this.getName() + ',' + this.getPhone() + ',' + this.getEmail() + ','
                + ',' + this.getTeamName()+ ',' + this.getRemark();
        return csv;
    }

    // ToString method
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", teamName='" + teamName + '\'' +
                ", remark='" + remark + '\'' +
                ", marked='" + marked + '\'' +
                '}';
    }


}


