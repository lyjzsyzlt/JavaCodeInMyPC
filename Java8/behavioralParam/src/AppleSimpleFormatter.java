public class AppleSimpleFormatter implements AppleToString {
    @Override
    public String accept(Apple apple) {
        return "An apple of "+apple.getWeight()+" g";
    }
}
