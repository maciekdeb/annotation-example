package maciekdeb;

import maciekdeb.annotations.Getter;
import maciekdeb.annotations.GetterProcessor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by maciej.debowski on 03.11.2016.
 */
public class Main {

    @Getter
    public ArrayList<String> list;

    @Getter
    public HashMap<String, String> map;

    public static void main(String[] args) {
        GetterProcessor.process(Main.class);
    }

}
