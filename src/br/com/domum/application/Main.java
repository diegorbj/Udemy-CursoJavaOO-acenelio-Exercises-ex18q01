package br.com.domum.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> apuracao = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the full path: ");
        String fullPath = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            String line = br.readLine();

            while (line != null){
                String[] votacao = line.split(",");
                String candidato = votacao[0];
                Integer votos = Integer.parseInt(votacao[1]);

                if (apuracao.containsKey(candidato)){
                    votos += apuracao.get(candidato);
                }
                apuracao.put(candidato, votos);
                line = br.readLine();
            }

            for (String candidato : apuracao.keySet()) {
                System.out.printf("%s: %d%n", candidato, apuracao.get(candidato));
            }
        } catch (IOException e){
            System.out.println("Unexpected error!");
        }

    }
}
