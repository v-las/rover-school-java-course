package homeworks;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class HomeWork006Api {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        task01api();
        // https://open-meteo.com/en/docs
    }

    record Response(DailyUnits daily_units, Daily daily) {
    }

    record Daily(
            String[] time,
            double[] temperature_2m_max
    ) {
    }

    record DailyUnits(
            String temperature_2m_max
    ) {
    }

    private static void task01api() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("=== task01 ===\n");

        double[] coordinates = randomCoordinates();

        String uri = String.format("https://api.open-meteo.com/v1/forecast" +
                        "?latitude=%.2f" +
                        "&longitude=%.2f" +
                        "&daily=temperature_2m_max" +
                        "&past_days=31" +
                        "&forecast_days=1",
                coordinates[0],
                coordinates[1]);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //        System.out.println("[response status Code][" + response.statusCode() + "]");
        //        System.out.println("response.body() = " + prettyPrintJSON(response.body()));

        Gson gson = new Gson();
        Response responseBody = gson.fromJson(response.body(), Response.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        String unit = responseBody.daily_units().temperature_2m_max();
        double[] temperatures = responseBody.daily().temperature_2m_max();
        String[] dates = Arrays.stream(responseBody.daily().time())
                .map(LocalDate::parse)
                .map(date -> date.format(formatter))
                .toArray(String[]::new);

        double maxTemperature = Arrays.stream(temperatures).max().getAsDouble();
        double secondMaxTemperature = Arrays.stream(temperatures)
                .filter(t -> t != maxTemperature)
                .max().getAsDouble();

        System.out.printf("Max temperature in the last 31 days: %.1f%s%n", maxTemperature, unit);
        System.out.printf("Second to max temperature in the last 31 days: %.1f%s%n", secondMaxTemperature, unit);

        for (int i = 0; i < temperatures.length; i++) {
            double currentTemperature = temperatures[i];
            String currentDate = dates[i];

            if (currentTemperature == maxTemperature) {
                System.out.printf("In the %s, was a MAX temperature day (%.1f%s)%n", currentDate, currentTemperature, unit);
            } else if (currentTemperature == secondMaxTemperature) {
                System.out.printf("In the %s, was a second to MAX temperature day (%.1f%s)%n", currentDate, currentTemperature, unit);
            }
//            System.out.printf("In the %s the t° was %.1f %s%n", dates[i], temperatures[i], unit);
        }
    }

    // https://stackoverflow.com/a/49564514

    /**
     * A simple implementation to pretty-print JSON file.
     *
     * @param unformattedJsonString
     * @return
     */
    public static String prettyPrintJSON(String unformattedJsonString) {
        StringBuilder prettyJSONBuilder = new StringBuilder();
        int indentLevel = 0;
        boolean inQuote = false;
        for (char charFromUnformattedJson : unformattedJsonString.toCharArray()) {
            switch (charFromUnformattedJson) {
                case '"':
                    // switch the quoting status
                    inQuote = !inQuote;
                    prettyJSONBuilder.append(charFromUnformattedJson);
                    break;
                case ' ':
                    // For space: ignore the space if it is not being quoted.
                    if (inQuote) {
                        prettyJSONBuilder.append(charFromUnformattedJson);
                    }
                    break;
                case '{':
                case '[':
                    // Starting a new block: increase the indent level
                    prettyJSONBuilder.append(charFromUnformattedJson);
                    indentLevel++;
                    appendIndentedNewLine(indentLevel, prettyJSONBuilder);
                    break;
                case '}':
                case ']':
                    // Ending a new block; decrese the indent level
                    indentLevel--;
                    appendIndentedNewLine(indentLevel, prettyJSONBuilder);
                    prettyJSONBuilder.append(charFromUnformattedJson);
                    break;
                case ',':
                    // Ending a json item; create a new line after
                    prettyJSONBuilder.append(charFromUnformattedJson);
                    if (!inQuote) {
                        appendIndentedNewLine(indentLevel, prettyJSONBuilder);
                    }
                    break;
                default:
                    prettyJSONBuilder.append(charFromUnformattedJson);
            }
        }
        return prettyJSONBuilder.toString();
    }

    /**
     * Print a new line with indention at the beginning of the new line.
     *
     * @param indentLevel
     * @param stringBuilder
     */
    private static void appendIndentedNewLine(int indentLevel, StringBuilder stringBuilder) {
        stringBuilder.append("\n");
        for (int i = 0; i < indentLevel; i++) {
            // Assuming indention using 2 spaces
            stringBuilder.append("  ");
        }
    }

    private static double[] randomCoordinates() {
        double lat = ThreadLocalRandom.current().nextDouble(-90.0, 90.0);
        double lon = ThreadLocalRandom.current().nextDouble(-180.0, 180.0);

        return new double[]{lat, lon};

    }
}
