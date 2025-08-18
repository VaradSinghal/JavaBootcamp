public class StringArrays {
public static String findLongestName(String[] names) {
    String longestName = "";
    for (String name : names) {
        if (name.length() > longestName.length()) {
            longestName = name;
        }
    }
    return longestName;
}

// start with a given letter (case-insensitive)
public static int countNamesStartingWith(String[] names, char letter) {
    int count = 0;
    for (String name : names) {
        if (name.toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
            count++;
        }
    }
    return count;
}




// Assume names are given as "First Last"
public static String[] formatNames(String[] names) {
    String[] formattedNames = new String[names.length];
    for (int i = 0; i < names.length; i++) {
        String[] parts = names[i].split(" ");
        if (parts.length == 2) {
            formattedNames[i] = parts[1] + ", " + parts[0];
        } else {
            formattedNames[i] = names[i]; 
        }
    }
    return formattedNames;
}


    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown",
                "Carol Davis", "David Wilson"};

        String longest = findLongestName(students);
        System.out.println("Longest Name: " + longest);

        int countA = countNamesStartingWith(students, 'A');
        System.out.println("Names starting with 'A': " + countA);

    
        String[] formatted = formatNames(students);
        System.out.println("Formatted Names:");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}