package marcheur.blanc;

import java.util.*;

public class RandomWalker {
    private Map<String, List<String>> map;
    private Random random;

    public RandomWalker(Map<String, List<String>> map) {
        this.map = map;
        this.random = new Random();
    }

    public List<String> randomWalk(String start, String destination) {
        List<String> path = new ArrayList<>();
        String current = start;
        path.add(current);

        while (!current.equals(destination)) {
            List<String> neighbors = map.get(current);
            if (neighbors == null || neighbors.isEmpty()) {
                return null;
            }
            current = neighbors.get(random.nextInt(neighbors.size()));
            path.add(current);
        }

        return path;
    }
}
