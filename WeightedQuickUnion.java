/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saurabh;

/**
 *
 * @author saurabh
 * weighted quick union  with path compression
 * coplexity to find N 
 * and union for nobjects  N+Mlog*N
 */
public class WeightedQuickUnion {
    
     private int[] id, sz;
   
     
    public WeightedQuickUnion(int N)
    {
        id = new int[N];
        sz= new int[N];
        for(int i=0 ; i<N ; i++)
        { id[i]=i;
            sz[i]=1;
        }
      
        
    }
    
    private int root(int i)
    {
            while(i != id[i]) 
            {       i=id[i];
            }
            return i;
            
    }
    public boolean connection(int p , int q)
    {
        return root(p) == root(q);
	
    }
    public void Union(int p , int q)
    {
        int i = root(p);
        int j = root(q);
        if(sz[i]<sz[j])
        {
            id[i]=j;
            sz[j]+=sz[i];
        }
        else
        {
            id[j]=i;
            sz[i]+=sz[j];
        }
        System.out.print("\n id[i] " + id[i] + " id[j] " + id[j] );
        System.out.print("\n szi " + sz[i] + " szb "+ sz[j] );
    }
    
    public static void main(String[] args)
{   
        WeightedQuickUnion a;
        
        a = new WeightedQuickUnion(10);
        a.Union(1, 4);
        a.Union(3, 2);
        a.Union(8, 0);
        a.Union(4, 7);
        a.Union(8, 9);
        a.Union(1, 6);
        a.Union(7, 5);
        a.Union(0, 3); 
        a.Union(7, 0);
        System.out.print("\n ");
        for(int i=0;i<a.id.length ; i++)
        {
        System.out.print(" "+a.id[i]);
        }
        System.out.print("\n ");
         for(int i=0;i<a.id.length ; i++)
        {
        System.out.print(" "+a.root(i));
        }
        
}     
}
