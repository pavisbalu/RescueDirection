package zophop;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import static java.lang.Math.*;

public class RescueOps
{
        public static void main(String[] args) throws  NumberFormatException{
        RescueOps ops=new RescueOps();
       List out= ops.shortPath(2,2);
        System.out.print(out.toString());
    }


    enum Direction{
        NORTH(5),
        SOUTH(7),
        WEST(8),
        EAST(6),
        NORTHWEST(4),
        NORTHEAST(1),
        SOUTHWEST(3),
        SOUTHEAST(2);

private int position;

        Direction(int position) {
            this.position=position;
        }
    }
    public List<String> shortPath(int x, int y){
             if(x==0){
                StringBuffer sb=new StringBuffer();
                String output=sb.append(directionOfY(y).position).append(0).toString();
                //int o=Integer.parseInt(output);
                List<String> l=new ArrayList<>();
                l.add(output);
                return l;
             }


             else if(y==0){
                 StringBuffer sb=new StringBuffer();
                 String output=sb.append(directionOfX(x).position).append(0).toString();
                 //int o=Integer.parseInt(output);
                 List<String> l=new ArrayList<>();
                 l.add(output);
                 return l;

             }
             else if(x==y){
                 StringBuffer sb=new StringBuffer();
                String output=sb.append(move(directionOfDiagonal(x,y).position,abs(x))).append(list(0)).toString();
                 //int o=Integer.parseInt(output);
                 List<String> l=new ArrayList<>();
                 l.add(output);
                 return l;
             }
             else{
                 StringBuffer sb=new StringBuffer();
                 int minimumDistance=min(abs(x),abs(y));
                 int axisPath=max(abs(x),abs(y))-minimumDistance;
                 String output=sb.append(move(directionOfDiagonal(x,y).position,minimumDistance)).
                         append(move(directionOf(x,y).position,axisPath)).append(list(0)).toString();

                 //int o=Integer.parseInt(output);
                 List<String> l=new ArrayList<>();
                 l.add(output);
                 /*for(String i:l ) {
                     System.out.print(i);
                 }*/


return  l;
             }

    }

    public static<O> List<O> list(final O...i)
    {
        List<O> list = new ArrayList<>();
        list.addAll(Arrays.asList(i));
        return list;
    }

    private static<T> String move(T direction, int minimumDistance) {
        Set<T> s=new HashSet<T>();
        List<T> list=new ArrayList();
        for(int i=0;i<minimumDistance;i++){
            list.add(direction);
        }
        s.addAll(list);
        list.clear();
        list.addAll(s);
        return  String.valueOf(list);
    }
    private Direction directionOf(int x,int y){
Direction diagonalDirection=directionOfDiagonal(x,y);
switch (diagonalDirection) {
    case NORTHEAST:
        return abs(x)>abs(y)?Direction.EAST:Direction.NORTH;
    case SOUTHWEST:
        return abs(x)>abs(y)?Direction.WEST:Direction.SOUTH;
    case NORTHWEST:
        return abs(x)<abs(y)?Direction.NORTH:Direction.WEST;
    default:
        return abs(x)<abs(y)?Direction.SOUTH:Direction.EAST;
}


    }

    private Direction directionOfDiagonal(int x, int y) {
        if(x>0 && y>0) return Direction.NORTHEAST;
        else if(x<0 && y>0) return  Direction.NORTHWEST;
        else if(x>0 && y<0) return  Direction.SOUTHEAST;
        else return  Direction.SOUTHWEST;
    }


    private Direction directionOfX(int x) {
        if(x>0)
            return Direction.EAST;

        else
            return  Direction.WEST;
    }

    private Direction directionOfY(int y) {
        if(y>0)
            return Direction.NORTH;

        else
            return  Direction.SOUTH;

    }

}
