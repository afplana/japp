package ao.jfpack.patterns.composite;

public class CompositeDemo {

    public static void main(String... args) {
        Access level1 = new Access("GLOBAL");
        Access level2 = new Access("AREA");
        Access level3 = new Access("SECTION");
        Access level4 = new Access("SINGLE");

        level1.add(level2, level3, level4);
        level2.add(level3, level4);
        level3.add(level4);

         for (Access access: level1.accessSet) {
             System.out.println(access.type);
             for (Access a: access.accessSet) {
                 System.out.println(a.type);
             }
         }
    }
}
