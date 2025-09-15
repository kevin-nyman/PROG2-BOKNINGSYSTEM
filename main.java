import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[] passagerare = new int[20];
        
        for (int i = 0; i < passagerare.length; i++) {
            passagerare[i] = 0;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        boolean kör = true;
        
        while (kör) {
            System.out.println("1. Lägga till en passagerare");
            System.out.println("2. Skriv ut hur många lediga platser det finns");
            System.out.println("3. Beräkna vinsten av antalet sålda biljetter");
            System.out.println("4. Avsluta programmet");
            System.out.print("Välj ett alternativ: ");
            
            int val = scanner.nextInt();
            
            switch (val) {
                case 1:
                    System.out.println("\nBoka en plats");
                    
                    int ledigPlats = -1;
                    for (int i = 0; i < passagerare.length; i++) {
                        if (passagerare[i] == 0) {
                            ledigPlats = i;
                            break;
                        }
                    }
                    
                    if (ledigPlats == -1) {
                        System.out.println("Det finns inga lediga platser.");
                    } else {
                        System.out.print("Ange födelsedatum (ÅÅÅÅMMDD): ");
                        int födelsedatum = scanner.nextInt();
                        
                        if (födelsedatum >= 10000000 && födelsedatum <= 99999999) {
                            passagerare[ledigPlats] = födelsedatum;
                            System.out.println("Plats " + (ledigPlats + 1) + " har bokats.");
                        } else {
                            System.out.println("Ogiltigt födelsedatum. Ange datum i formatet ÅÅÅÅMMDD (8 siffror).");
                        }
                    }
                    break;
                    
                case 2:
                    int antalLediga = 0;
                    for (int i = 0; i < passagerare.length; i++) {
                        if (passagerare[i] == 0) {
                            antalLediga++;
                        }
                    }
                    System.out.println("\nDet finns " + antalLediga + " lediga platser av " + passagerare.length + " totalt.");
                    break;
                    
                case 3:
                    int antalBokade = 0;
                    for (int i = 0; i < passagerare.length; i++) {
                        if (passagerare[i] != 0) {
                            antalBokade++;
                        }
                    }
                    double vinst = antalBokade * 299.90;
                    System.out.printf("\nAntal sålda biljetter: %d\nVinst: %.2f kr\n", antalBokade, vinst);
                    break;
                    
                case 4:
                    System.out.println("\nProgrammet avslutas.");
                    kör = false;
                    break;
                    
                default:
                    System.out.println("\nOgiltigt val. Försök igen.");
            }
        }
        
        scanner.close();
    }
}
