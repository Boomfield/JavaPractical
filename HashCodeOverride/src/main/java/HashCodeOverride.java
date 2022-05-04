import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashCodeOverride {
    public static void main(String[] args) {
        Map<MyString, Integer> hashMap = new HashMap<>();
        Map<MyString, Integer> linkedMap = new LinkedHashMap<>();
        MyString privet = new MyString("privet");

        hashMap.put(new MyString("privet"),1);
        hashMap.put(new MyString("poka"),2);
        hashMap.put(new MyString("soska"),3);
        hashMap.put(new MyString("morda"),4);
        linkedMap.put(new MyString("privet"),1);
        linkedMap.put(new MyString("poka"),2);
        linkedMap.put(new MyString("soska"),3);
        linkedMap.put(new MyString("morda"),4);

        hashMap.entrySet().stream().forEach(x-> System.out.println(x.getKey().hashCode()));
        System.out.println("new Map");
        linkedMap.entrySet().stream().forEach(x-> System.out.println(x.getKey().hashCode()));
        System.out.println("new Map");
        System.out.println(privet.hashCode());
    }
}
