package com.nitin.a.sandBox;

import java.util.*;

public class Test {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Test(String magazine, String note) {
        // fill the megazine map
        String[] magMap = magazine.split(" ");
        String[] not = note.split(" ");

        for (String m : magMap){
            if (magazineMap.containsKey(m))
                magazineMap.put(m,1);
            else
                magazineMap.put(m,magazineMap.get(m) + 1);
        }

        for (String n : not){
            if (noteMap.containsKey(n))
                noteMap.put(n,1);
            else
                noteMap.put(n,noteMap.get(n) + 1);
        }
    }

    public boolean solve() {
        Iterator<String> itr = noteMap.keySet().iterator();
        boolean flag = true;

        while(itr.hasNext()){
            String word = itr.next();

            if (magazineMap.get(word) < 1)
                return false;
            else
                magazineMap.put(word, magazineMap.get(word) - 1);
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Test s = new Test(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
