package mamtalwtrial.vitalpakistan.com.mamtalwtrial.models;

import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.crf2.FormCrf2DTO;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.crf3.crf3a.FormCrf3aDTO;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.crf3.crf3b.FormCrf3bDTO;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.crf3.crf3c.FormCrf3cDTO;

public class FormsCrf2AndCrf3All {


    private boolean crf2Status;
    private boolean crf3aStatus;
    private boolean crf3bStatus;
    private boolean crf3cStatus;

    private FormCrf2DTO formCrf2DTO;
    private FormCrf3aDTO formCrf3aDTO;
    private FormCrf3bDTO formCrf3bDTO;
    private FormCrf3cDTO formCrf3cDTO;


    public boolean getCrf2Status() {
        return crf2Status;
    }

    public void setCrf2Status(boolean crf2Status) {
        this.crf2Status = crf2Status;
    }

    public boolean getCrf3aStatus() {
        return crf3aStatus;
    }

    public void setCrf3aStatus(boolean crf3aStatus) {
        this.crf3aStatus = crf3aStatus;
    }

    public boolean getCrf3bStatus() {
        return crf3bStatus;
    }

    public void setCrf3bStatus(boolean crf3bStatus) {
        this.crf3bStatus = crf3bStatus;
    }

    public boolean getCrf3cStatus() {
        return crf3cStatus;
    }

    public void setCrf3cStatus(boolean crf3cStatus) {
        this.crf3cStatus = crf3cStatus;
    }

    public FormCrf2DTO getFormCrf2DTO() {
        return formCrf2DTO;
    }

    public void setFormCrf2DTO(FormCrf2DTO formCrf2DTO) {
        this.formCrf2DTO = formCrf2DTO;
    }

    public FormCrf3aDTO getFormCrf3aDTO() {
        return formCrf3aDTO;
    }

    public void setFormCrf3aDTO(FormCrf3aDTO formCrf3aDTO) {
        this.formCrf3aDTO = formCrf3aDTO;
    }

    public FormCrf3bDTO getFormCrf3bDTO() {
        return formCrf3bDTO;
    }

    public void setFormCrf3bDTO(FormCrf3bDTO formCrf3bDTO) {
        this.formCrf3bDTO = formCrf3bDTO;
    }

    public FormCrf3cDTO getFormCrf3cDTO() {
        return formCrf3cDTO;
    }

    public void setFormCrf3cDTO(FormCrf3cDTO formCrf3cDTO) {
        this.formCrf3cDTO = formCrf3cDTO;
    }
}
