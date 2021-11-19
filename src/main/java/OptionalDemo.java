import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        String tempString = null;

        Optional<String> optional1 = Optional.ofNullable(tempString);
        optional1.ifPresentOrElse(string ->System.out.println(string),()->System.out.println("test1")); //test1

        System.out.println(optional1.isEmpty()); //true
        System.out.println(optional1.isPresent()); //false

        try{
            Optional<String> optional2 = Optional.of(tempString);  //java.lang.NullPointerException
            optional2.ifPresentOrElse(string ->System.out.println(string),()->System.out.println("test2"));
        }catch (NullPointerException e ){
            System.out.println(e);
        }

        String tempString2 = "test string";

        Optional<String> optional3 = Optional.ofNullable(tempString2);
        optional3.ifPresent(s -> System.out.println(s));   //test string

        System.out.println(optional3.isEmpty()); //false
        System.out.println(optional3.isPresent()); //true

    }
}
