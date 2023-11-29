package nitin.zkcura.java8Solution.part2;

import nitin.zkcura.oldSolution.part1.Data;

import java.util.*;

/**
 * Created by Nitin Chaurasia on 11/10/15 at 10:05 PM.
 */
public class BredthFirstTraversal {
    private final Set<nitin.zkcura.oldSolution.part1.Data> visited = new HashSet<nitin.zkcura.oldSolution.part1.Data>();
    private final Queue<CityDistance> inline = new LinkedList<CityDistance>();
    private final List<CityDistance> allCitiesWithDistance = new ArrayList<CityDistance>();

    public void traverseGraph(Map<nitin.zkcura.oldSolution.part1.Data, Set<nitin.zkcura.oldSolution.part1.Data>> citiesAdjList, nitin.zkcura.oldSolution.part1.Data root) {
        int currDistance = 0;
        inline.add(new CityDistance(currDistance, root));
        visited.add(root);
        CityDistance currentCityDistance;
        allCitiesWithDistance.add(new CityDistance(currDistance, root));

        while (inline.size() > 0) {
            currentCityDistance = inline.remove();
            if (currentCityDistance == null) {
                System.out.println("CURR DISTANCE IS NULL");
            } else if (currentCityDistance.data == null) {
                System.out.println("CURR DISTANCE DATA IS NULL");
            }
            for (nitin.zkcura.oldSolution.part1.Data connections : citiesAdjList.get(currentCityDistance.data)) {
                if (!visited.contains(connections)) {
                    currDistance = currentCityDistance.distance + 1;
                    visited.add(connections);
                    inline.add(new CityDistance(currDistance, connections));
                    allCitiesWithDistance.add(new CityDistance(currDistance, connections));
                }
            }
        }
    }

    public String printList() {
        String value = "";
        for (CityDistance cityDistance : allCitiesWithDistance) {
            value = value + cityDistance.data + " " + cityDistance.distance + "\n";
            //System.out.println("Distance:" + value);
        }
        return value;
    }

    private class CityDistance {
        int distance;
        nitin.zkcura.oldSolution.part1.Data data;

        public CityDistance(int distance, Data data) {
            this.distance = distance;
            this.data = data;
        }
    }
}
