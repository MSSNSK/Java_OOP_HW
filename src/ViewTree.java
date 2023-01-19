public class ViewTree {
    public static void view(Persona p, int num) {
        String line = "  ".repeat(num);
        String partner = "";
        if (p.partner != null){
            partner = " (Супруг(а) - " + p.partner.name + ")";

        }
        System.out.println(line + p.name + partner);

        for (Persona itemPersona : p.getChildList()) {
            view(itemPersona, num + 1);

        }
    }

}
