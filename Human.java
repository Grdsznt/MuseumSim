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
    
    private final int R = 67, C = 37;
    // based on one node being 20x20 pixels, off of the world size
    private boolean vis[][] = new boolean[69][39];
    private int adj[][] = new int [69][39];
    private int dist[][] = new int[69][39];
    private int mr[] = {0, 1, 0, -1}, mc[] = {1, 0, -1, 0};
    
    private boolean enteredNewRoom = false;
    
    /**
     * Pair is a utility class that stores 2 numbers. 
     * <p>
     * Used for coordinates in the world's tile system.
     */
    public class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r; this.c = c;
        }
    }
    
    public class Greater implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            // Compare the two pairs based on their 'x' value for ascending order.
            // Returns a negative integer, zero, or a positive integer as the
            // first argument is less than, equal to, or greater than the second.
            return Integer.compare(a.r, b.c);
        }
    }
    
    /**
     * Act - do whatever the Furniture wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (enteredNewRoom) {
            Room r = (Room) getWorld();
            adj = r.updGrid();
            enteredNewRoom = false;
        }
    }
    
    /**
     *  Use Breadth-First-Search to get the shortest distance
     * From a source to a destination, then return the directions to move
     * using a tile system
     *
     * @param srcr	Source row number
     * @param srcc	Sourc column number
     * @param destr	Destination row number
     * @param destc	Destination column number
     * @return List<Pair>   List of (r, c) coordinates to be able to move the character
    */
    public List<Pair> bfs(int srcr, int srcc, int destr, int destc) {
        Map<Pair, Pair> par = new HashMap<>();
        List<Pair> path = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(srcr, srcc));
        vis[srcr][srcc] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r, c = p.c;
            if (r == destr && c == destc) {
                for (Pair u = new Pair(r, c); u != null; u = par.get(u)) {
                    path.add(u);
                }
                Collections.reverse(path);
                return path;
            }
            q.remove();
            for (int k = 0;k<4;k++) {
                int nr = r+mr[k], nc = c+mc[k];
                if (nr >= 1 && nr < R && nc < C && nc >= 1 && !vis[nr][nc] && adj[nr][nc] != 1) {
                    vis[nr][nc] = true;
                    dist[nr][nc] = dist[r][c]+1;
                    q.add(new Pair(nr, nc));
                    par.put(new Pair(nr, nc), p);
                }
            }
        }
        for (int i = 0;i<R;i++) {
            for (int j = 0;j<C;j++) vis[i][j] = false;
        }
        return path;
    }
    
}
