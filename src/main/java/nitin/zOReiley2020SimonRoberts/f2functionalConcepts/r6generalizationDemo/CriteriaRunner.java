package nitin.zOReiley2020SimonRoberts.f2functionalConcepts.r6generalizationDemo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CriteriaRunner {

    //The Type declaration of the Generic Variable is placed immediately before the Return Type
    private static <E> List<E> getByCriteria(Iterable<E> iter, Criteria<E> criteria) {
        List<E> returnCars = new ArrayList<>();
        for (E c : iter) {
            //Passing the criteria based on the users input
            if (criteria.test(c)) {
                returnCars.add(c);
            }
        }
        return returnCars;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Haradanahalli Doddegowda Deve Gowda",
                "Avul Pakir Jainulabdeen Abdul Kalam",
                "Venkata Narasimha Rajuvaripet",
                "Sarvepalli Radhakrishnan",
                "Kocheril Raman Narayanan",
                "Puratchi Thalaivar Maruthur Gopalan Ramachandran"
        );
        List<String> namesGT30Chars = getByCriteria(names, st -> st.length() >= 30);
        showAll(namesGT30Chars);

        System.out.println("*********************************************************************************************");
        List<Integer> intList = Arrays.asList(2, 43, 564567, 678, 897, 9874, 456, 23, 3, 5, 3, 25324, 45, 6546, 56);
        List<Integer> intListFiltered = getByCriteria(intList, ints -> ints > 999);
        showAll(intListFiltered);

        System.out.println(" ********************************************************************************************");
        LocalDate today = LocalDate.now();
        List<LocalDate> appointments = Arrays.asList(today, today.plusDays(2), today.minusDays(4), today.plusMonths(1));
        System.out.println("All appointments");
        showAll(appointments);
        System.out.println("Future appointments after: " + today);
        showAll(getByCriteria(appointments, a -> a.isAfter(today)));
    }

    public static <E> void showAll(List<E> lc) {
        for (E c : lc) {
            System.out.println(c);
        }
        System.out.println("-------------------------------------");
    }
}