
//import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;




class UMTproblem {
    public boolean ImpartireEgalaVector(int[] v) {
        int totalSum= SumaElemente(v);//introducerea intr-o variabila valoarea returnata de metoda SumaElemente
        Map<Integer, Set<Integer>> sum2Count = new HashMap<>();// Map-urile  sunt perfecte pentru a fi utilizate pentru asocierea valorilor cheie, map-uri sunt utilizate pentru a efectua căutări prin chei sau când cineva dorește să recupereze și să actualizeze elemente prin chei.
        Set<Integer> initial = new HashSet<>();// set-urile sunt colectii de obiecte care nu contine elemente duplicate
        initial.add(0);//adauga valoarea 0 in setul 'initial'
        sum2Count.put(0, initial);//adauga cheia 0 al valorii 'initial' al map-ul sum2Count 
        
        
        
        for (int i = 0; i < v.length; ++i) { //parcurgem vectorul dat 
            for (int sum = totalSum; sum >= v[i]; --sum) {   
                if (!sum2Count.containsKey(sum - v[i])) {// verifica daca exista cheia 'sum-v[i]' , atunci nu, atunci se continua 
                    continue;
                }
                
                if (!sum2Count.containsKey(sum)) { //verifica daca sum2Count contine cheia sum, si daca da, se va adauga in sum2Count cheia sum
                    sum2Count.put(sum, new HashSet<>());
                }
                Set<Integer> tmp = new HashSet<>(); // initializarea unei valori temp pentru evitarea ConcurrentModityException
                

                for (int count : sum2Count.get(sum - v[i])) { //bucla pentru elementele HashMap-ului sum2Count
                    if (count + 1 != v.length) { //se adauga in set-ul temp valoarea lui count+1 daca aceasta este diferita de lungimea vectorului
                        tmp.add(count + 1);
                    }
                }
                
                sum2Count.get(sum).addAll(tmp);
                for (int count : sum2Count.get(sum)) {
                    if (EgalitateMedie(sum, count, totalSum, v.length)) {
                        System.out.println(sum2Count.entrySet());//afisarea listelor
                        System.out.println(sum + "/" + count + " and " + totalSum + "/" + v.length);//afisarea dimensiunii
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
   
    private boolean EgalitateMedie(int a, int x, int b, int y) { // lungimiile trebuie sa fie mai mari ca si 0
        return x > 0 && y > 0 && x * b == y * a;
    }
    
    
    
    public static int SumaElemente(int[] array) { //suma elementelor din vector folosint stream-uri. Un stream este o secvență de obiecte care acceptă diferite metode care pot fi canalizate pentru a produce rezultatul dorit.Fiecare operație intermediară este executată leneș și returnează un stream ca urmare, prin urmare, diverse operații intermediare pot fi canalizate.
        return Arrays.stream(array).sum(); // Operațiunile terminalului marchează sfârșitul stream-ului și returnează rezultatul.
    }
}
