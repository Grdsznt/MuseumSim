import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Human class is a blueprint for all humans that will appear in the world.
 * 
 * @author Jean, Edwin Dong
 * @version Apr 10 2024
 */
public abstract class Human extends SuperSmoothMover
{
    
    private int R = 41,C = 33; // 661/20 x 816/20
    // based on one node being 20x20 pixels, off of the world size
    private boolean vis[][] = new boolean[70][50];  // give it some extra cells
    private int mx[] = {0, 1, 0, -1}, my[] = {1, 0, -1, 0}; // move in 4 directions: up, down, left, right
    
    /**
     * Pair is a utility class that stores 2 numbers. 
     * <p>
     * Used for coordinates in the world's tile system.
     */
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x; this.y = y; // stores 2 numbers
        }
        
        // Override java's equals method to ensure that hashmap lookup works
        @Override
        public boolean equals(Object obj) { 
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y; //compare the values
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y); //hashing mechanism for fields x and y (so if same x and y, same hash)
        }
    }
    
    
    public class Greater implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            // Compare the two pairs based on their 'x' value for ascending order.
            // Returns a negative integer, zero, or a positive integer as the
            // first argument is less than, equal to, or greater than the second.
            return Integer.compare(a.x, b.x);
        }
    }
    
    /**
     * Act - do whatever the Furniture wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    
    /**
     *  Use Breadth-First-Search to get the shortest distance
     * From a source to a destination, then return the directions to move
     * using a tile system
     *
     * @param srcx    Source row number
     * @param srcy    Sourc column number
     * @param destx    Destination row number
     * @param desty    Destination column number
     * @return List<Pair>   List of (r, c) coordinates to be able to move the character
    */
    public ArrayList<Pair> bfs(int srcx, int srcy, int destx, int desty) {
        // Use a hashmap to efficiently access the parent of a node later
        Map<Pair, Pair> par = new HashMap<>();
        // Since we want to return the path as a list of tiles (including x and y coordinates, for context, view class "Pair")
        ArrayList<Pair> path = new ArrayList<>();
        // Standard Breadth-First-Search Setup, Use a queue (linkedlist interface) and a visited array
        // Push the sourcex, sourcey tile into the queue, then mark it visited
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(srcx, srcy));
        vis[srcy][srcx] = true; // notice it's [srcy][srcx] since row is y and column is x
        // While the graph (just a grid representing a bidrectional graph) still contains paths to be explored
        while (!q.isEmpty()) {
            // Get the current tile to explore and remove it from the queue
            Pair p = q.poll();
            int x = p.x, y = p.y;
            // Do a check if reached close enough to the destination
            if (Math.abs(x-destx) <= 3 && Math.abs(y-desty) <= 3) {
                // if so, set all tiles to not visited to use for the next bfs run
                for (int i = 0;i<R;i++) {
                    for (int j = 0;j<C;j++) vis[i][j] = false;
                }
                Pair u = new Pair(x, y);
                // since the parent of each node in the path has been stored as values for the current node as a key, we can iteratively
                // get the parent to sort of "backtrack" the path.
                while (u != null) {
                    path.add(u); // add the tile to the path
                    u = par.get(u);
                }
                Collections.reverse(path); // since it backtracks the path, if we want to use the path iteratively to move the character, we should reverse it.
                return path;
            }
            // Loop all 4 directions
            for (int k = 0;k<4;k++) {
                // get the x and y values of the new tile location
                int nx = x+mx[k], ny = y+my[k];
                // if this tile is valid (does not go outside bounds, and is not visited)
                if (nx >= 1 && nx < C && ny < R && ny >= 1 && !vis[ny][nx]) {
                    // set location of robber to this tile value * 20 (20 pixel x 20 pixel tile size)
                    setLocation(nx*20, ny*20);
                    if (this instanceof Robber) {
                        // if it is a robber, and the tile does not make it intersect an obstacle or a guard
                        if (!getIntersectingObjects(Obstacle.class).isEmpty() || !getIntersectingObjects(Guard.class).isEmpty()) setLocation(srcx*20, srcy*20);
                        else {
                            setLocation(srcx*20, srcy*20);
                            vis[ny][nx] = true; // mark visited
                            q.add(new Pair(nx, ny)); // add it to the queue to be explored (in a 1st year university course, this would be marking it gray)
                            par.put(new Pair(nx, ny), p); // put the parent of this new node as value
                        }
                    } else {
                        // if it is not a robber, do not check whether intersects a guard
                        if (!getIntersectingObjects(Obstacle.class).isEmpty()) setLocation(srcx*20, srcy*20);
                        else {
                            setLocation(srcx*20, srcy*20);
                            vis[ny][nx] = true;
                            q.add(new Pair(nx, ny));
                            par.put(new Pair(nx, ny), p);
                        }
                    }
                }
            }
        }
        // at the end of the bfs, even if it didn't find a path (pretty much never), make visited all false for next run
        for (int i = 0;i<R;i++) {
            for (int j = 0;j<C;j++) vis[i][j] = false;
        }
        // return to make sure it always returns something (to make the code compile)
        return path;
    }
    
    
}
