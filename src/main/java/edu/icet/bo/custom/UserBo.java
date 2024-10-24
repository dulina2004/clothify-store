package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;

public interface UserBo extends SuperBo {
    boolean sendOTPEmail(String email, String otp);
    void storeOTP(String email, String otp);
    boolean validateOTP(String email, String otp);
}
