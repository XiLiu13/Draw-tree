import java.util.Arrays;

public class Combination {
    
    public static void main(String[] args) {
        String[] players = {"Dey", "Ruowen", "Josh", "Kinder", "Mario", "Rock", "LOL"};
        showTeam(players, 4); 

        String[] na = {"a", "b", "c"};
        showTeam(na, 2); 
    }

    public static void showTeam(String[] names, int teamSize) {
        helpShowTeam(names, teamSize, new String[0], 0);
    }

    /**
     * Base case 1: we get enough person in the result_list.
     * Base case 2: we have checked all the players.
     * 
     * Create two branches
     * Branch 1 add current person to result_list
     * Branch 2 does not add current person to result_list(copy)
     * Move on to the next person
     * 
     * @param names : list of players
     * @param teamSize : choose how many players
     * @param resultList : Additional list parameter for recursion
     * @param position : Additional index parameter for recursion
     * @return nothing
     * @print All the combinations players
     */
    public static void helpShowTeam(String[] names, int teamSize, String[] resultList, int pos) {
        int iniLen = resultList.length;
        //base case 1
        if(resultList.length==teamSize)
        {
            System.out.println(Arrays.toString(resultList));
            return;
        }        

        //base case 2
        if(pos>=names.length)
        {return;}

           //branch 1
           String[] r1 = Arrays.copyOf(resultList,iniLen+1); //include the element at the current position
           r1[iniLen] = names[pos];
           helpShowTeam(names, teamSize, r1, pos+1);
           
           //branch 2
           String[] r2 = Arrays.copyOf(resultList,iniLen); //exclude the element at the current position
           helpShowTeam(names, teamSize, r2, pos+1);
    }
}