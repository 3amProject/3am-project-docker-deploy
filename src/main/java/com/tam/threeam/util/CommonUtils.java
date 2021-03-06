package com.tam.threeam.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author 이동은
 * @version 1.0
 * @Description
 * @Modification Information
 * Created 2021/01/02
 * @
 * @ 수정일         수정자                   수정내용
 * @ ———    ————    —————————————
 * @ 2021/01/02     최초 작성
 */
@Component
public class CommonUtils {


    // 아이디 유효성 검사
    public static boolean isUserId(String str) {
        String userIdRegex = "^[a-zA-Z0-9]+$";
        boolean patternUserId = Pattern.matches(userIdRegex, str);
        if(patternUserId == false) {
            return false;
        }
        if(str.length() < 3 || str.length() > 12){
            return false;
        }
        return true;
    }

    //TODO 비밀번호와 영대소문자 포함 필수 정규식 작성
    // 비밀번호 유효성 검사
    public static boolean isPassword(String str) {
        String passwordRegex = "^[a-zA-Z0-9]+$";
        boolean patternPassword = Pattern.matches(passwordRegex, str);
        if(patternPassword == false){
            return false;
        }
        if(str.length() < 3 || str.length() > 12){
            return false;
        }
        return true;
    }

    // 이메일 유효성 검사
    public static boolean isEmail(String str) {
        String emailRegex = "^[a-zA-Z0-9_.]+@(\\w+\\.)+\\w+$";
        boolean patternEmail = Pattern.matches(emailRegex, str);
        if(patternEmail == false) {
            return false;
        }
        return true;
    }

    // 전화번호 유효성 검사
    public static boolean isPhoneNum(String str) {
        String phoneNumRegex = "^[0-9]+$";
        boolean patternPhoneNum = Pattern.matches(phoneNumRegex, str);
        if(patternPhoneNum == false) {
            return false;
        }
        return true;
    }

    // 빈 값 체크
    public static boolean isNotEmpty(Object obj) {
        if(obj == null) {
            return false;
        }
        if((obj instanceof String) && (((String) obj).trim().length() == 0)) {
            return false;
        }
        if((obj instanceof Map) && ((Map) obj).isEmpty()) {
            return false;
        }
        if((obj instanceof List) && ((List) obj).isEmpty()) {
            return false;
        }
        return true;
    }

}
