public class ProteinTranslation {

    public static int endIndex;
    
    public String protein(String rna) {

        StringBuilder result = new StringBuilder();
    
        for (int i = 0; i < rna.length(); i += 3) {

            switch (rna.substring(i, i+3)) {
                case "GCA" :
                case "GCC" :
                case "GCU" :
                case "GCG" :
                result.append("Ala ");
                break;

                case "CGA" :
                case "CGC" :
                case "CGG" :
                case "CGU" :
                case "AGA" :
                case "AGG" :
                result.append("Arg ");
                break;

                case "AAU" :
                case "AAC" :
                result.append("Asn ");
                break;

                case "GAU" :
                case "GAC" :
                result.append("Asp ");
                break;

                case "UGU" :
                case "UGC" :
                result.append("Cys ");
                break;

                case "CAA" :
                case "CAG" :
                result.append("Gln ");
                break;

                case "GAA" :
                case "GAG" :
                result.append("Glu ");
                break;

                case "GGA" :
                case "GGC" :
                case "GGG" :
                case "GGU" :
                result.append("Gly ");
                break;

                case "CAU" :
                case "CAC" :
                result.append("His ");
                break;

                case "AUU" :
                case "AUC" :
                case "AUA" :
                result.append("Ile ");
                break;

                case "CUA" :
                case "CUC" :
                case "CUG" :
                case "CUU" :
                case "UUA" :
                case "UUG" :
                result.append("Leu ");
                break;

                case "AAA" :
                case "AAG" :
                result.append("Lys ");
                break;
                
                case "AUG" :
                result.append("Met ");
                break;

                case "UUU" :
                case "UUC" :
                result.append("Phe ");
                break;

                case "CCA" :
                case "CCC" :
                case "CCU" :
                case "CCG" :
                result.append("Pro ");
                break;

                case "UCA" :
                case "UCC" :
                case "UCG" :
                case "UCU" :
                case "AGU" :
                case "AGC" :
                result.append("Ser ");
                break;

                case "ACA" :
                case "ACC" :
                case "ACG" :
                case "ACU" :
                result.append("Thr ");
                break;

                case "UGG" :
                result.append("Trp ");
                break;

                case "UAU" :
                case "UAC" :
                result.append("Tyr ");
                break;

                case "GUA" :
                case "GUC" :
                case "GUG" :
                case "GUU" :
                result.append("Val ");
                break;
            }           
        }    

        return result.toString();

    }

    public static void main(String[] args) {

        ProteinTranslation execute = new ProteinTranslation();

        String dna = args[0];

        String[] dnaArray = new String[dna.length()];
        String[] rnaArray = new String[dna.length()];

        for (int i = 0 ; i < dna.length() ; i++) {
            dnaArray[i] = dna.substring(i, i + 1);
        }

        for (int i = 0 ; i < dnaArray.length ; i++) {
            if (dnaArray[i].equals("A"))       
                rnaArray[i] = "U";
            else if (dnaArray[i].equals("C"))
                rnaArray[i] = "G";
            else if (dnaArray[i].equals("G")) 
                rnaArray[i] = "C";
            else if (dnaArray[i].equals("T")) 
                rnaArray[i] = "A";
        }

        int startIndex = 0;
        int a = 0;
        int startCount = 0;

        while ((a < rnaArray.length - 3) && (startCount < 1)) {

            if (rnaArray[a].equals("A") && rnaArray[a + 1].equals("U") && rnaArray[a + 2].equals("G")) {
                startIndex = a;
                startCount++;
                a++;   
            } 
            else {
                a++;
            }

        }

        String rnaString = "";
        String rnaEdit = "";

        for (int i = startIndex ; i < rnaArray.length ; i++) {
            rnaString += rnaArray[i];
        }

        endIndex = 0;
        int b = 0;
        int endCount = 0;

        while ((b < rnaArray.length - 3) && (endCount < 1)) { {
            if (rnaString.substring(b, b + 3).equals("UAA") || rnaString.substring(b, b + 3).equals("UGA") || rnaString.substring(b, b + 3).equals("UAG")) {
                endIndex = (b + 3);
                endCount++;
                b++;
            }
            else {
                b++;
            }
        }

        for (int i = 0 ; i < endIndex ; i += 3) {
            rnaEdit += (rnaString.substring(i, i + 3));
        }

        System.out.print(execute.protein(rnaEdit));
 
        }
    }
}