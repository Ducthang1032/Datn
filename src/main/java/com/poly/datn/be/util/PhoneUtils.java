package com.poly.datn.be.util;


import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.poly.datn.be.constants.RegexConstants;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtils {
    public static final Pattern VALID_PHONE_NUMBER_REGEX =
            Pattern.compile(RegexConstants.PHONE_REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean isPhoneNumber(final String phoneStr) {
        if (StringUtils.isBlank(phoneStr)) return false;
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phoneStr);
        return matcher.find();
    }

    public static boolean isNotPhoneNumber(String input) {
        return !isPhoneNumber(input);
    }

    public static String formatPhoneNumber(String input) {
        if (StringUtils.isBlank(input) || isNotPhoneNumber(input)) return StringUtils.EMPTY;
        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(input,
                    Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.name());
            if (phoneNumberUtil.isValidNumber(phoneNumber))
                return phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
            return StringUtils.EMPTY;
        } catch (NumberParseException e) {
            return StringUtils.EMPTY;
        }
    }
}
