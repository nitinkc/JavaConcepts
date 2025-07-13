package nitin.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenExtractor {
    public static void main(String[] args) {
        String[] inputStrings = {
            "Non-Reactive",
            "Reactive",
            "0.8",
            "0.8 Reactive",
            "<=0.8",
            ">0.8",
            "<0.8",
            ">=0.8",
            "<=0.8 Reactive",
            ">0.8 Reactive",
            "<0.8 Reactive",
            ">=0.8 Reactive"
        };

        for (String input : inputStrings) {
            System.out.println("Tokens for '" + input + "':");
            List<String> tokens = extractTokens3(input);
            for (String token : tokens) {
                System.out.println(token);
            }
            System.out.println();
        }
    }

    private static List<String> extractTokens(String input) {
        // Define a regular expression to match tokens
        String regex = "([<>]=?|=)?(0\\.\\d+)?(\\s+.+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Extract tokens from the input string and store in a list
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            String relationalOperator =
                    matcher.group(1); // Extract the first capturing group ([<>]=?|=)
            if (relationalOperator != null && !relationalOperator.isEmpty()) {
                tokens.add(relationalOperator);
            }
            String numericValue = matcher.group(2); // Extract the second capturing group (0.\d+)
            if (numericValue != null && !numericValue.isEmpty()) {
                tokens.add(Double.parseDouble(numericValue) + "");
            }
            String additionalString = matcher.group(3); // Extract the third capturing group (.+)
            if (additionalString != null && !additionalString.isEmpty()) {
                tokens.add(additionalString.trim());
            }
        }

        return tokens;
    }

    private static List<String> extractTokens2(String input) {
        // Define a regular expression to match tokens
        String regex = "(Reactive|Non-Reactive)|([<>]=?|=)?(d\\.\\d+)?(\\s+.+)?|(.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Extract tokens from the input string and store in a list
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            String relationalOperator =
                    matcher.group(1); // Extract the first capturing group ([<>]=?|=)
            if (relationalOperator != null && !relationalOperator.isEmpty()) {
                tokens.add(relationalOperator);
            }
            String numericValue = matcher.group(2); // Extract the second capturing group (0.\d+)
            if (numericValue != null && !numericValue.isEmpty()) {
                tokens.add(Double.parseDouble(numericValue) + "");
            }
            String additionalString = matcher.group(3); // Extract the third capturing group (.+)
            if (additionalString != null && !additionalString.isEmpty()) {
                tokens.add(additionalString.trim());
            }
            String anyString = matcher.group(4); // Extract the fourth capturing group (.+)
            if (anyString != null && !anyString.isEmpty()) {
                tokens.add(anyString.trim());
            }
        }

        return tokens;
    }

    private static List<String> extractTokens3(String input) {
        // Define a regular expression to match tokens
        String regex = "(Reactive|Non-Reactive)|([<>]=?|=)(0\\.\\d+)?(\\s+.+)?|(.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Extract tokens from the input string and store in a list
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            String reactiveStatus =
                    matcher.group(1); // Extract the first capturing group (Reactive|Non-Reactive)
            if (reactiveStatus != null && !reactiveStatus.isEmpty()) {
                tokens.add(reactiveStatus);
            }
            String relationalOperator =
                    matcher.group(2); // Extract the second capturing group ([<>]=?|=)
            if (relationalOperator != null && !relationalOperator.isEmpty()) {
                tokens.add(relationalOperator);
            }
            String numericValue = matcher.group(3); // Extract the third capturing group (0.\d+)
            if (numericValue != null && !numericValue.isEmpty()) {
                tokens.add(Double.parseDouble(numericValue) + "");
            }
            String additionalString = matcher.group(4); // Extract the fourth capturing group (.+)
            if (additionalString != null && !additionalString.isEmpty()) {
                tokens.add(additionalString.trim());
            }
            String anyString = matcher.group(5); // Extract the fifth capturing group (.+)
            if (anyString != null && !anyString.isEmpty()) {
                tokens.add(anyString.trim());
            }
        }

        return tokens;
    }
}
