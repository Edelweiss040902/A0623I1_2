package com.example.e1_blog_upgrade.model;

import com.example.e1_blog_upgrade.untils.annotation.DoBConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Entity
public class Infor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inforId;
    @NotBlank(message = "title không được để trống")
    @Pattern(regexp = "^[a-z ]{4,50}$",message = "title không đúng định dạng ")
    private String inforName;
    @DoBConstraint
    private LocalDate inforDoB;
    @NotBlank(message = "số điện thoại không được bỏ trống")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91){7}$",message = "không đúm định dạng số điện thoại")
    private String inforPhone;
    private String inforAddress;
    @NotBlank(message = "không đúng định dạng")
    @Email(message = "không đúng định dạng email")
    private String inforEmail;

    public Infor() {
    }

    public Long getInforId() {
        return inforId;
    }
    @DoBConstraint
    public LocalDate getInforDoB() {
        return inforDoB;
    }

    public void setInforDoB(LocalDate inforDoB) {
        this.inforDoB = inforDoB;
    }

    public void setInforId(Long inforId) {
        this.inforId = inforId;
    }

    public String getInforName() {
        return inforName;
    }

    public void setInforName(String inforName) {
        this.inforName = inforName;
    }

    public String getInforPhone() {
        return inforPhone;
    }

    public void setInforPhone(String inforPhone) {
        this.inforPhone = inforPhone;
    }

    public String getInforAddress() {
        return inforAddress;
    }

    public void setInforAddress(String inforAddress) {
        this.inforAddress = inforAddress;
    }
    public String getInforEmail() {
        return inforEmail;
    }

    public void setInforEmail(String inforEmail) {
        this.inforEmail = inforEmail;
    }
}
