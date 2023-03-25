package com.hr.whitus.dto;

public class FormDataDTO {

    private int start;
    private int end;

    public FormDataDTO() {
    }

    public FormDataDTO(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
