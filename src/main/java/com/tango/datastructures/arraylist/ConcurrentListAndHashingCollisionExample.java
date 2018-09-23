package com.tango.datastructures.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentListAndHashingCollisionExample implements Runnable
{

    Thread t = new Thread( this );

    @Override
    public void run()
    {
        System.out.println( "running" );

    }

    public static void main( String[] args ) throws InterruptedException
    {
        

        Set lSet1 = new HashSet();
        lSet1.add( new Integer( 2 ) );
        lSet1.add( new Integer( 2 ) );
        
        lSet1.add(2);
        System.out.println( lSet1.toArray() );

        
        Map hashMap = new HashMap();
        hashMap.put("a", 1);
        hashMap.put(new String("a"), 2);
        hashMap.put("a", 3);
        
        Integer ln = Integer.parseUnsignedInt( "4294967295" );
        Integer ln2 = Integer.parseInt( "1" );
        System.out.println( ln.compareTo( ln2 ) );
        int value = Integer.compareUnsigned( ln2, ln );
        System.out.println( value );

        Map<DummyKey, Integer> lHashMap = new HashMap<>();

        for( int i = 0; i < 1000; i++ )
        {
            //if( i > 900000000 )
                //System.out.println( i );
            lHashMap.put( new DummyKey(i), i );
        }

        Set<Integer> lSet = new TreeSet<>();
        lSet.add( 2 );
        lSet.contains( 3 );
        lSet.add( 4 );

        List<String> list = new CopyOnWriteArrayList<>();
        //new ArrayList<>();
        list.add( "1" );
        list.add( "2" );
        list.add( "3" );
        list.add( "4" );
        list.add( "5" );
        //List<String> list = new ArrayList<>();

        // get the iterator
        Iterator<String> it = list.iterator();

        // manipulate list while iterating
        while( it.hasNext() )
        {
            System.out.println( "list is:" + list );
            String str = it.next();
            System.out.println( str );
            if( str.equals( "2" ) )
            {

            }
            // list.remove("5");
            if( str.equals( "3" ) )
            {
                list.add( "3 found" );
                list.add( "3 found1" );
            }
            // below code don't throw ConcurrentModificationException
            // because it doesn't change modCount variable of list
            if( str.equals( "4" ) )
                list.set( 1, "4" );
        }
    }

}

class DummyKey implements Comparable<DummyKey>
{
    private final int value;

    DummyKey( int value )
    {
        this.value = value;
    }

    @Override
    public int compareTo( DummyKey o )
    {
        return Integer.compare( this.value, o.value );
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DummyKey key = (DummyKey) o;
        return value == key.value;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
