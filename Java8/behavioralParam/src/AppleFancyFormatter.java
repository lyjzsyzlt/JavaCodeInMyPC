public class AppleFancyFormatter implements AppleToString {

    @Override
    public String accept(Apple apple) {
        String characteristic=apple.getWeight()>150?"heavy":"light";
        return "A "+characteristic+" "+apple.getColor()+" apple";
    }
}
