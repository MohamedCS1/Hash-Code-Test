import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Pizza{
    public static void main(String[] args) throws IOException {
        HashMap<String ,Integer> listingredient = listOfingredient();
        HashMap<String ,Integer> calcu = calculation(listingredient);
        
        System.out.println(calcu);
    }

    public static boolean isNumeric(String string) {
       return string.matches("[+-]?\\d*(\\.\\d+)?"); 
    }

    public static HashMap<String ,Integer> listOfingredient() throws IOException
    {
        String stringline;
        String[] stringsplit;

        String[] emptyarray = new String[]{};
        List<String> temparray = Arrays.asList(emptyarray);
        List<String> finalarray = new ArrayList<>(temparray);


        File file = new File("/home/moh/Desktop/pizza/d_difficult.in.txt");

        HashMap<String ,Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((stringline = br.readLine()) != null)
        {
            stringsplit = stringline.split(" ");
            for(String word :stringsplit)
            {
                if(isNumeric(word))
                {
                    continue;
                }
                else
                {
                    if(!finalarray.contains(word))
                    {
                        map.put(word, 0);
                    }
                }
            }
        }
        return map;
    }

    public static HashMap<String ,Integer> calculation(HashMap<String ,Integer> map) throws IOException
    {
        String stringline;
        String[] stringsplit;

        File file = new File("/home/moh/Desktop/pizza/d_difficult.in.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        
        br.readLine();

        boolean isfirstline = true;

        while ((stringline = br.readLine()) != null)
        {

            stringsplit = stringline.split(" ");
            
            if(isfirstline)
            {

                for(String word :stringsplit)
                {
                    if(isNumeric(word))
                    {
                        continue;
                    }
                    else
                    {
                       map.put(word, map.get(word).intValue()+1);
                    }
                }

                isfirstline = false;
            }
            else
            {
                for(String word :stringsplit)
                {
                    if(isNumeric(word))
                    {
                        continue;
                    }
                    else
                    {
                       map.put(word, map.get(word).intValue()-1);
                    }
                }

                isfirstline = true;
            }
        }
        return map;
    }
}

