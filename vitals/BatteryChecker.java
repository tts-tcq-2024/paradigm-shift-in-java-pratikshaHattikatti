package vitals;

class BatteryChecker {
    private String language;
    private boolean enableWarningForTemperature = true;
    private boolean enableWarningForSoc = true;
    private boolean enableWarningForChargeRate = true;

    public BatteryChecker(String language) {
        this.language = language;
    }

    public boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean temperatureOk = isParameterOk("Temperature", temperature, 0, 45, 2.25f, enableWarningForTemperature);
        boolean socOk = isParameterOk("State of Charge", soc, 20, 80, 4, enableWarningForSoc);
        boolean chargeRateOk = isParameterOk("Charge Rate", chargeRate, 0, 0.8f, 0.04f, enableWarningForChargeRate);
        return temperatureOk && socOk && chargeRateOk;
    }

    private boolean isParameterOk(String parameter, float value, float min, float max, float warningTolerance, boolean warningEnabled) {
        return !isCritical(parameter, value, min, max) && 
               (!warningEnabled || !isWarning(parameter, value, min, max, warningTolerance));
    }

    private boolean isCritical(String parameter, float value, float min, float max) {
        if (value < min) {
            return true;
        } else if (value > max) {
            return true;
        }
        return false;
    }

    private boolean isWarning(String parameter, float value, float min, float max, float warningTolerance) {
        return value < min + warningTolerance || value > max - warningTolerance;
    }

    public StringBuilder getColorManual() {
        StringBuilder manual = new StringBuilder();
        manual.append(LanguageSupport.getMessage(language, "Temperature", "LOW"))
              .append("\n")
              .append(LanguageSupport.getMessage(language, "Temperature", "HIGH"))
              .append("\n")
              .append(LanguageSupport.getMessage(language, "State of Charge", "LOW"))
              .append("\n")
              .append(LanguageSupport.getMessage(language, "State of Charge", "HIGH"))
              .append("\n")
              .append(LanguageSupport.getMessage(language, "Charge Rate", "LOW"))
              .append("\n")
              .append(LanguageSupport.getMessage(language, "Charge Rate", "HIGH"));
        return manual;
    }

    public void setWarningForTemperature(boolean enable) {
        this.enableWarningForTemperature = enable;
    }

    public void setWarningForSoc(boolean enable) {
        this.enableWarningForSoc = enable;
    }

    public void setWarningForChargeRate(boolean enable) {
        this.enableWarningForChargeRate = enable;
    }
}
