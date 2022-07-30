package com.redehocus.promotions.util;

public class CustomItemTranslator {

    public static String translate(String s) {

        String translated = s;

        switch (s) {

            case "customitem_launcher": {
                translated = "Lançador";
                break;
            }

            case "customitem_trap": {
                translated = "Armadilha";
                break;


            }

            case "customitem_grapplinghook": {
                translated = "Grappling Hook";
                break;

            }

            case "customitem_blackhole": {
                translated = "Buraco Negro";
                break;

            }

            case "customitem_divinebonus": {
                translated = "Bonificação Divina";
                break;

            }

            default: {
                translated = s;
                break;
            }

        }

        return translated;
    }
}
