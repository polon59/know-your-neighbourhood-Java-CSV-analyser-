import java.util.HashMap;
import java.lang.Integer;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

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

    private List<String> createLocationNamesList(){
        List<String> listOfLocationNames = new ArrayList<String>();

        while(locationsIterator.hasNext()){
            listOfLocationNames.add(locationsIterator.next().getName());
        }
        return listOfLocationNames;
    }


    private String[] getSearchPatternFromInput(){
        Scanner input = new Scanner(System.in);
        String[] searchPattern = input.nextLine().split("");
        input.close();
        return searchPattern;
    }

    public void handleAdvancedSearch(){
        String[] pattern = getSearchPatternFromInput();
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        List<String> locationNames = createLocationNamesList();
        List<String> searchResults = new ArrayList<String>();
        int matchingLetters = 0;
        int i = 0;
        int a = 0;

        for (String locationName : locationNames){
            String[] splittedName = locationName.split("");

            a = 0;
            i = 0;
            matchingLetters = 0;
            while (i <= pattern.length){

                while (a < splittedName.length){
                    
                    if(splittedName[a].equals(pattern[i])){
                        splittedName[a] = ANSI_GREEN + splittedName[a] + ANSI_RESET;
                        matchingLetters++;
                        i++;
                    }
                    else{
                        i = 0;
                        matchingLetters = 0;
                        splittedName = resetWordColor(splittedName);
                        //resetColor
                    }
                    a++;
                    if (i == pattern.length ){break;}
                }

                if (matchingLetters == pattern.length){
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
        for (String letter : word){
            letter = ANSI_WHITE + letter + ANSI_RESET;
        }
        return word;
    }
    
}