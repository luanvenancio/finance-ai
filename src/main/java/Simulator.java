package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;

public class Simulator {

    public static void main(String... args) {

        List<MarketData> marketDatas = readDataFromCSV("rent3_dados_financeiros.csv");

        for (MarketData m : marketDatas) {
            System.out.println(m);
        }

    }

    // 1. Ler Dados do mercado
    private static List<MarketData> readDataFromCSV(String fileName) {

        List<MarketData> marketDatas = new ArrayList<>();
        Path pathToFile = Paths.get("./src/main/resource/" + fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line;

            int count = 0;
            while ((line = br.readLine()) != null) {

                if (count == 0) {
                    count++;
                    continue;
                }

                String[] attributes = line.split(",");

                MarketData marketData = createMarketData(attributes);

                marketDatas.add(marketData);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return marketDatas;
    }

    private static MarketData createMarketData(String[] values) {
        LocalDate date = LocalDate.parse(values[0]);
        Double open = Double.parseDouble(values[1]);
        Double high = Double.parseDouble(values[2]);
        Double low = Double.parseDouble(values[3]);
        Double close = Double.parseDouble(values[4]);
        int volume = Integer.parseInt(values[5]);

        return new MarketData(date, open, high, low, close, volume);
    }

}
