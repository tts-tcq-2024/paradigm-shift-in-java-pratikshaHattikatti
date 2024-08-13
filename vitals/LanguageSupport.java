package vitals;

import java.util.HashMap;
import java.util.Map;

public class LanguageSupport {
    private static final Map<String, Map<String, String>> messages = createMessages();

    public static String getMessage(String language, String parameter, String condition) {
        String key = condition + "_" + parameter.toUpperCase().replace(" ", "_");
        return messages.getOrDefault(language, messages.get("EN")).getOrDefault(key, "Unknown condition");
    }

    private static Map<String, Map<String, String>> createMessages() {
        Map<String, Map<String, String>> messages = new HashMap<>();

        Map<String, String> enMessages = new HashMap<>();
        enMessages.put("LOW_TEMPERATURE", "Temperature is too low");
        enMessages.put("HIGH_TEMPERATURE", "Temperature is too high");
        enMessages.put("LOW_SOC", "State of Charge is too low");
        enMessages.put("HIGH_SOC", "State of Charge is too high");
        enMessages.put("LOW_CHARGE_RATE", "Charge Rate is too low");
        enMessages.put("HIGH_CHARGE_RATE", "Charge Rate is too high");
        enMessages.put("LOW_TEMPERATURE_WARNING", "Warning: Approaching low temperature");
        enMessages.put("HIGH_TEMPERATURE_WARNING", "Warning: Approaching high temperature");
        enMessages.put("LOW_SOC_WARNING", "Warning: Approaching discharge");
        enMessages.put("HIGH_SOC_WARNING", "Warning: Approaching charge peak");
        enMessages.put("LOW_CHARGE_RATE_WARNING", "Warning: Approaching low charge rate");
        enMessages.put("HIGH_CHARGE_RATE_WARNING", "Warning: Approaching high charge rate");
        messages.put("EN", enMessages);

        Map<String, String> deMessages = new HashMap<>();
        deMessages.put("LOW_TEMPERATURE", "Temperatur ist zu niedrig");
        deMessages.put("HIGH_TEMPERATURE", "Temperatur ist zu hoch");
        deMessages.put("LOW_SOC", "Ladezustand ist zu niedrig");
        deMessages.put("HIGH_SOC", "Ladezustand ist zu hoch");
        deMessages.put("LOW_CHARGE_RATE", "Laderate ist zu niedrig");
        deMessages.put("HIGH_CHARGE_RATE", "Laderate ist zu hoch");
        deMessages.put("LOW_TEMPERATURE_WARNING", "Warnung: Annäherung an niedrige Temperatur");
        deMessages.put("HIGH_TEMPERATURE_WARNING", "Warnung: Annäherung an hohe Temperatur");
        deMessages.put("LOW_SOC_WARNING", "Warnung: Annäherung an Entladung");
        deMessages.put("HIGH_SOC_WARNING", "Warnung: Annäherung an Ladehöhepunkt");
        deMessages.put("LOW_CHARGE_RATE_WARNING", "Warnung: Annäherung an niedrige Laderate");
        deMessages.put("HIGH_CHARGE_RATE_WARNING", "Warnung: Annäherung an hohe Laderate");
        messages.put("DE", deMessages);

        return messages;
    }
}
