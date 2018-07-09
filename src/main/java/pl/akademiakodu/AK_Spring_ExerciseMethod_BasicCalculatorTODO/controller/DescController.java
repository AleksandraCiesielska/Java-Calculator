package pl.akademiakodu.AK_Spring_ExerciseMethod_BasicCalculatorTODO.controller;

/**
 * Import section
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class DescController
{

    /**
     * Method responsible to get description template
     * @return template with image containing description of exercise
     */
    @GetMapping("/desc")
    public String descGet()
    {
        return "desc";
    }

    //@ResponseBody //@- adnotacje jaka to jest ścieżka w przeglądarce
    @GetMapping("/random") // będzie wywołana metoda random która zwraca string random od metody get rządanie adres URL
    public String getRandom(ModelMap map)
    {
        Set<Integer> lotto = new TreeSet<>();
        Random random = new Random();

        while (lotto.size() !=6) //do jakiego pliku w html ma przejść string
        {
            lotto.add(random.nextInt((49) +1 ));
        }
        map.put("lotto",lotto);  //wrzucenie klucza i wartości

        return "random"; //spring do przekazywania mapy do html używa hash map
        // szuka pliku random.htmlktóry musi znajdować się w katalogu template
    }
}
