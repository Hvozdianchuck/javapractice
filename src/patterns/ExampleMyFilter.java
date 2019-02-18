package patterns;

import java.util.ArrayList;
import java.util.List;

public class ExampleMyFilter {
    public static void main(String[] args) {
 FileManager fileManager = new FileManager(new FilterChain());
 fileManager.setFilter(new FilterOne());
 fileManager.setFilter(new FilterTwo());
 fileManager.filterRequest("one");
    }
}
interface IFilter{
    void execute(String data);
}
class FilterOne implements IFilter{
    @Override
    public void execute(String data) {
        System.out.println("filter one "+data);
    }
}
class FilterTwo implements IFilter{
    @Override
    public void execute(String data) {
        System.out.println("filter two "+data);
    }
}
class FilterChain{
    List<IFilter> filters = new ArrayList<>();
    Target target = new Target();
    void addFilter(IFilter iFilter){
        filters.add(iFilter);
    }
    void filter(String data){
        for (IFilter i: filters) {
       i.execute(data);
        }
     target.doJob(data);
    }
}
class Target{
    void doJob(String data){
        System.out.println("do job");
    }
}
class FileManager{
    private FilterChain filterChain;

    public FileManager(FilterChain filterChain) {
        this.filterChain = filterChain;
    }
    public void  setFilter(IFilter iFilter){
        filterChain.addFilter(iFilter);
    }
    public void filterRequest(String request){
        filterChain.filter(request);
    }
}