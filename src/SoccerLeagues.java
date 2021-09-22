import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SoccerLeagues {
    public /*static void*/ int[] points(String[] matches) {
        // create array to store results
        //ArrayList<Integer> points = new ArrayList<>();

        // create map to tally teams' scores
        HashMap<Integer, Integer> map = new HashMap<>();

        // for each element of matches array (one team's results)
        for(int k = 0; k < matches.length; k++){
            //split into characters
            char[] current_team = matches[k].toCharArray();
            //int teamScore = 0;

            // loop through each character
            //for(char c : current_team){
            for(int i=0; i < current_team.length; i++){
                // get character
                char result = current_team[i];

                // if character is '-', add 0
                if(result == '-') {
                    map.putIfAbsent(k+1, 0);
                }

                // if character is 'W', add three points to current team
                if(result == 'W'){
                    map.putIfAbsent(k+1, 0);
                    map.put(k+1, map.get(k+1) + 3);
                }

                // if character is 'L'
                if(result == 'L'){
                    // get location of character
                    int index = i + 1;

                    // assign three points to the other team
                    map.putIfAbsent(index, 0);
                    map.put(index, map.get(index) + 3);
                }

                // if character is 'D'
                if(result == 'D'){
                    // assign one point to current team
                    map.putIfAbsent(k+1, 0);
                    map.put(k+1, map.get(k+1) + 1);

                    // get location of character
                    int index = i + 1;

                    // assign one point to the other team
                    map.putIfAbsent(index, 0);
                    map.put(index, map.get(index) + 1);
                }

            }
        }

        // get points of map and put in arrayList
        ArrayList<Integer> points_list = new ArrayList<>(map.values());
        //int[] points_ = new int[matches.length];

        // convert ArrayList to array
        int[] points_array = new int[points_list.size()];
        for(Integer i = 0; i < points_list.size(); i++){
            points_array[i] = points_list.get(i);
        }

        return points_array;
        //System.out.println(points_list);

        //ArrayList<Integer> list = new ArrayList<>();
        //for(int i : points_){
            //System.out.println(i);
        //}
    }

    /*public static void main(String[] args){
       String[] matches_ = {"-LWWLWDLDWWWWWWDDWDW",
               "D-WWLDDWDWDLWDDWLWDD",
               "LL-DLDWDLDLDWWWLWDDW",
               "LDD-LLLDLWLWWWWDWDWL",
               "LWWW-DWDLWDWDWWWDWDW",
               "DLLWD-WWLLDDDLWWDWWW",
               "WWLWDL-LLDWWWWWDWWLW",
               "LLLLLDW-LDLWDDLLLDWL",
               "DWWWWDDD-DWWWWDWWWDW",
               "WWWWLLLWL-LWWWWWLWWW",
               "DWWWWWWWLW-WDWWWWWWW",
               "DDDLLLDWWWL-DDWDWLDD",
               "LWLWLDLLLDLW-DDDWWDD",
               "LLWWLWDDLWLWL-WWWDLL",
               "WWWWLLDDDWLWDD-WWWLW",
               "DLDLLLWWLLLWWLW-DWLL",
               "DLWWWLDLWWDWWDWL-WWD",
               "LLDDLLWLLWLWLDLWW-WW",
               "LLWLLLWWLWLWWDWWLD-W",
               "LLWDLWDWDWLLWWDDWWL-"};
        points(matches_);
    }*/
}
