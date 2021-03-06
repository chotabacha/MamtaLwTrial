package mamtalwtrial.vitalpakistan.com.mamtalwtrial.models;

import java.util.List;

public class LoginDTO {

    private Integer teamId;
    private String teamType;
    private List<FollowupsDTO> followups;
    private String site;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public List<FollowupsDTO> getFollowups() {
        return followups;
    }

    public void setFollowups(List<FollowupsDTO> followups) {
        this.followups = followups;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
