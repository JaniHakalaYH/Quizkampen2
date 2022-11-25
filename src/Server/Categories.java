package Server;

import java.util.ArrayList;
import java.util.HashMap;

public class Categories {

    private HashMap<String, ArrayList<Question>> categoriesMap;

    public Categories(){
        this.categoriesMap = createCategoriesHashmap();
    }

    public HashMap<String, ArrayList<Question>> getCategoriesMap(){
        return categoriesMap;
    }
    public HashMap<String, ArrayList<Question>> createCategoriesHashmap() {

        return categoriesMap;
    }

}
