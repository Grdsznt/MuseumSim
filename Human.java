import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Human class is a blueprint for all humans that will appear in the world.
 * 
 * @author Jean, Edwin Dong
 * @version Apr 10 2024
 */
public class Human extends SuperSmoothMover
{
    
    private int R = 41,C = 31;
    // based on one node being 20x20 pixels, off of the world size
    private boolean vis[][] = new boolean[70][50];  // give it some extra cells
    private int mx[] = {0, 1, 0, -1}, my[] = {1, 0, -1, 0}; // move in 4 directions: up, down, left, right
    
    private boolean enteredNewRoom = true;
    
    /**
     * Pair is a utility class that stores 2 numbers. 
     * <p>
     * Used for coordinates in the world's tile system.
     */
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
        
        public boolean equals(Object obj) { 
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
        if (enteredNewRoom) {
            if (getWorld() instanceof MuseumRoom) {
                MuseumRoom r = (MuseumRoom) getWorld();
                R = r.getHeight()/20 + 1;
                C = r.getWidth()/20 + 1;
            }
            enteredNewRoom = false;
        }
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
        Map<Pair, Pair> par = new HashMap<>();
        ArrayList<Pair> path = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(srcx, srcy));
        vis[srcy][srcx] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x, y = p.y;
            if (Math.abs(x-destx) <= 3 && Math.abs(y-desty) <= 3) {
                for (int i = 0;i<R;i++) {
                    for (int j = 0;j<C;j++) vis[i][j] = false;
                }
                Pair u = new Pair(x, y);
                while (u != null) {
                    path.add(u);
                    u = par.get(u);
                }
                Collections.reverse(path);
                return path;
            }
            for (int k = 0;k<4;k++) {
                int nx = x+mx[k], ny = y+my[k];
                if (nx >= 1 && nx < C && ny < R && ny >= 1 && !vis[ny][nx]) {
                    setLocation(nx*20, ny*20);
                    if (this instanceof Robber) {
                        if (!getIntersectingObjects(Obstacle.class).isEmpty() || !getIntersectingObjects(Guard.class).isEmpty()) setLocation(srcx*20, srcy*20);
                        else {
                            setLocation(srcx*20, srcy*20);
                            vis[ny][nx] = true;
                            q.add(new Pair(nx, ny));
                            par.put(new Pair(nx, ny), p);
                        }
                    } else {
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
        for (int i = 0;i<R;i++) {
            for (int j = 0;j<C;j++) vis[i][j] = false;
        }
        return path;
    }
    
    
}
