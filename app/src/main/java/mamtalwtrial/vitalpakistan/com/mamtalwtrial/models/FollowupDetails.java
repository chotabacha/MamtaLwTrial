package mamtalwtrial.vitalpakistan.com.mamtalwtrial.models;

public class FollowupDetails {

    //CRF2 depends on CRF1 data
    private String assistId;
    private String name; //lw_crf_1_09
    private String husbandName; //lw_crf_1_10
    private String site; //lw_crf_1_11
    private String para; //lw_crf_1_12
    private String block; //lw_crf_1_13
    private String structure; //lw_crf_1_14
    private String householdOrFamily; //lw_crf_1_15
    private Integer womanNumber;//lw_crf_1_16
    private Integer endDate;
    private String dateOfBirth;
    private String timeOfBirth;
    private String fNum;

    private String pwd;
    private String chd;

    private String wnum;
    private String stdyId;
    private String arm;
    private String age;
    private String lastVisit;

    private String form;
    private String lmp; //CRF1 q26

    private Vaccination vaccination;

    public Vaccination getVaccination() {
        return vaccination;
    }

    public void setVaccination(Vaccination vaccination) {
        this.vaccination = vaccination;
    }

    public String getLmp() {
        return lmp;
    }

    public void setLmp(String lmp) {
        this.lmp = lmp;
    }

    public String getAssistId() {
        return assistId;
    }

    public void setAssistId(String assistId) {
        this.assistId = assistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getHouseholdOrFamily() {
        return householdOrFamily;
    }

    public void setHouseholdOrFamily(String householdOrFamily) {
        this.householdOrFamily = householdOrFamily;
    }

    public Integer getWomanNumber() {
        return womanNumber;
    }

    public void setWomanNumber(Integer womanNumber) {
        this.womanNumber = womanNumber;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(String timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public String getfNum() {
        return fNum;
    }

    public void setfNum(String fNum) {
        this.fNum = fNum;
    }

    public String getWnum() {
        return wnum;
    }

    public void setWnum(String wnum) {
        this.wnum = wnum;
    }

    public String getStdyId() {
        return stdyId;
    }

    public void setStdyId(String stdyId) {
        this.stdyId = stdyId;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getChd() {
        return chd;
    }

    public void setChd(String chd) {
        this.chd = chd;
    }
}
