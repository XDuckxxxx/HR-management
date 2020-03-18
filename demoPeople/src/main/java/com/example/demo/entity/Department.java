package com.example.demo.entity;

public class Department {

    private int Dept_id;
    private String Dept_name;
    private String Remark;
    private int Is_delete;

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int dept_id) {
        Dept_id = dept_id;
    }

    public String getDept_name() {
        return Dept_name;
    }

    public void setDept_name(String dept_name) {
        Dept_name = dept_name;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getIs_delete() {
        return Is_delete;
    }

    public void setIs_delete(int is_delete) {
        Is_delete = is_delete;
    }
}
