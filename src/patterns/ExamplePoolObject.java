package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExamplePoolObject {
    public static void main(String[] args) {
ObjectPool objectPool = new ObjectPool();
  PooledObject pooledObject= objectPool.getPooledObject();
  objectPool.realisedPooledObject(pooledObject);
    }
}
class PooledObject{}
class ObjectPool{
    List<PooledObject> free = new ArrayList<>();
    List<PooledObject> used = new ArrayList<>();
    public PooledObject getPooledObject(){
        if (free.isEmpty()){
            PooledObject pooledObject = new PooledObject();
            free.add(pooledObject);
            return pooledObject;
        }else {
            PooledObject pooledObject=free.get(0);
          used.add(pooledObject);
          free.remove(pooledObject);
        }

   return null; }
   public void realisedPooledObject(PooledObject pooledObject){
        used.remove(pooledObject);
        free.add(pooledObject);
   }
}