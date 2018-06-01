import java.util.HashMap;
import java.lang.Integer;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Searcher {

    private final String ANSI_WHITE = "\u001B[37m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";
    private LocationsIterator locationsIterator;
    private ArrayList<Location> locations;


    public Searcher(ArrayList<Location> locations){
        this.locations = locations;
        locationsIterator = new LocationsIterator(locations);
    }


    public List<String> findLocationsWithManyCategories(HashMap<String, Integer> categoriesCounter){
        Set<String> locationsNames = categoriesCounter.keySet();
        List<String> locationsWithManyCategories = new ArrayList<String>();
        int numberOfLocationCategories;

        for (String locationName : locationsNames){
            numberOfLocationCategories = categoriesCounter.get(locationName);
            if (numberOfLocationCategories > 1){
                locationsWithManyCategories.add(locationName);
            }
        }
        return locationsWithManyCategories;
    }

    private Set<String> createLocationNamesSet(){
        Set<String> setOfLocationNames = new HashSet<String>();

        while(locationsIterator.hasNext()){
            setOfLocationNames.add(locationsIterator.next().getName());
        }
        return setOfLocationNames;
    }


    private String[] getSearchPatternFromInput(){
        Scanner input = new Scanner(System.in);
        String[] searchPattern = input.nextLine().split("");
        input.close();
        return searchPattern;
    }

    public void handleAdvancedSearch(){
        String[] pattern = getSearchPatternFromInput();
        Set<String> locationNames = createLocationNamesSet();
        List<String> searchResults = new ArrayList<String>();
        List<Integer> indexesWithGoodResult = new ArrayList<Integer>();
        int matchingLetters = 0;
        int i = 0;
        int a = 0;

        for (String locationName : locationNames){
            String[] splittedName = locationName.split("");

            a = 0;
            i = 0;
            matchingLetters = 0;
            indexesWithGoodResult.clear();

            while (i <= pattern.length){

                while (a < splittedName.length){
                    
                    if(splittedName[a].equals(pattern[i])){
                        indexesWithGoodResult.add(a);
                        //splittedName[a] = ANSI_GREEN + splittedName[a] + ANSI_RESET;
                        matchingLetters++;
                        i++;
                    }
                    else{
                        i = 0;
                        matchingLetters = 0;
                        indexesWithGoodResult.clear();
                    }
                    a++;
                    if (i == pattern.length ){break;}
                }
                if (matchingLetters == pattern.length){
                    //reconstruct from here
                    for (int index : indexesWithGoodResult){
                        splittedName[index] = ANSI_GREEN + splittedName[index] + ANSI_RESET;
                    }
                    //to here
                    searchResults.add(String.join("", splittedName));
                }
                break;
            }
        }

        for (String result : searchResults){
            System.out.println(result);
        }
    }

    private String[] resetWordColor(String[] word){
        String[] uncoloredWord = new String[word.length];

        for (int index = 0; index < word.length; index++){
            uncoloredWord[index] = ANSI_WHITE + word[index] + ANSI_RESET;

        }

        return uncoloredWord;
        
    }
    
}