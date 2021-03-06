package me.kr328.nevo.decorators.smscaptcha;

import android.content.Context;

import net.grandcentrix.tray.TrayPreferences;

public class Settings {
    public final static String SETTING_CAPTCHA_HIDE_ON_LOCKED = "setting_captcha_hide_on_locked";
    public final static String SETTING_CAPTCHA_IDENTIFY_PATTERN = "setting_captcha_identify_pattern";
    public final static String SETTING_CAPTCHA_PARSE_PATTERN = "setting_captcha_parse_pattern";
    public final static String SETTING_SUBSCRIBE_IDENTIFY_PATTERN = "setting_subscribe_identify_pattern";
    public final static String SETTING_SUBSCRIBE_PRIORITY = "setting_subscribe_priority";

    private boolean captchaHideOnLocked;
    private String captchaIdentifyPattern;
    private String captchaParsePattern;
    private String subscribeIdentifyPattern;
    private int subscribePriority;

    public Settings(boolean captchaHideOnLocked, String captchaIdentifyPattern, String captchaParsePattern, String subscribeIdentifyPattern, int subscribePriority) {
        this.setCaptchaHideOnLocked(captchaHideOnLocked);
        this.setCaptchaIdentifyPattern(captchaIdentifyPattern);
        this.setCaptchaParsePattern(captchaParsePattern);
        this.setSubscribeIdentifyPattern(subscribeIdentifyPattern);
        this.setSubscribePriority(subscribePriority);
    }

    public static Settings defaultValueFromContext(Context context) {
        return new Settings(true,
                context.getString(R.string.default_value_identify_captcha_pattern),
                context.getString(R.string.default_value_parse_captcha_pattern),
                context.getString(R.string.default_value_identify_subscribe_pattern),
                -2);
    }

    public Settings readFromTrayPreference(TrayPreferences preferences) {
        setCaptchaHideOnLocked(preferences.getBoolean(SETTING_CAPTCHA_HIDE_ON_LOCKED, isCaptchaHideOnLocked()));
        setCaptchaIdentifyPattern(preferences.getString(SETTING_CAPTCHA_IDENTIFY_PATTERN, getCaptchaIdentifyPattern()));
        setCaptchaParsePattern(preferences.getString(SETTING_CAPTCHA_PARSE_PATTERN, getCaptchaParsePattern()));
        setSubscribeIdentifyPattern(preferences.getString(SETTING_SUBSCRIBE_IDENTIFY_PATTERN, getSubscribeIdentifyPattern()));
        setSubscribePriority(preferences.getInt(SETTING_SUBSCRIBE_PRIORITY, getSubscribePriority()));

        return this;
    }

    public boolean isCaptchaHideOnLocked() {
        return captchaHideOnLocked;
    }

    public void setCaptchaHideOnLocked(boolean captchaHideOnLocked) {
        this.captchaHideOnLocked = captchaHideOnLocked;
    }

    public String getCaptchaIdentifyPattern() {
        return captchaIdentifyPattern;
    }

    public void setCaptchaIdentifyPattern(String captchaIdentifyPattern) {
        this.captchaIdentifyPattern = captchaIdentifyPattern;
    }

    public String getCaptchaParsePattern() {
        return captchaParsePattern;
    }

    public void setCaptchaParsePattern(String captchaParsePattern) {
        this.captchaParsePattern = captchaParsePattern;
    }

    public String getSubscribeIdentifyPattern() {
        return subscribeIdentifyPattern;
    }

    public void setSubscribeIdentifyPattern(String subscribeIdentifyPattern) {
        this.subscribeIdentifyPattern = subscribeIdentifyPattern;
    }

    public int getSubscribePriority() {
        return subscribePriority;
    }

    public void setSubscribePriority(int subscribePriority) {
        this.subscribePriority = subscribePriority;
    }
}
