package ao.jfpack.patterns.iterator;

public class IteratorTest {
    public static void main(String[] args) {
        GenericArrayIterator<String> iterator =
                new GenericArrayIterator<>(new String[]{"Robert" , "John" ,"Julie" , "Lora"});

        for(Iterator<String> iter = iterator.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
