import com.osohq.oso.*;

class Test {
    public static class A {
        public String x;
    
        public A(String x) {
            this.x = x;
        }
    }

    public static void main(String[] args) {
        try {
            Oso o = new Oso();
            o.registerClass(A.class, m -> new A((String) m.get("x")), "A");
            o.loadFile("test.polar");
            o.allow("a", "b", "c");
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        System.out.println("Tests Pass");
    }
}