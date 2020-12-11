package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyExample {

    public static void main(String[] args) throws Exception {
        try {
            String fileName= ".\\Test.fcl";
            int jasnoscOtoczenia=5;
            int jasnoscZarowki=40;
            int poraDnia=13;

            //String fileName = args[0];
            //int poziomNatezenia = Integer.parseInt(args[1]);
            //int poraDnia = Integer.parseInt(args[2]);
            FIS fis = FIS.load(fileName,false);

            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();
            fuzzyRuleSet.setVariable("jasnosc_otoczenia", jasnoscOtoczenia);
            fuzzyRuleSet.setVariable("pora_dnia", poraDnia);
            fuzzyRuleSet.setVariable("jasnosc_zarowki", jasnoscZarowki);
            fuzzyRuleSet.evaluate();
            fuzzyRuleSet.getVariable("zmiana_natezenia").chartDefuzzifier(true);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow.");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr.");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}